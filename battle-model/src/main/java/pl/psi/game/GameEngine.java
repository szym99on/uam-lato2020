package pl.psi.game;

import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.move.GuiTileIf;
import pl.psi.game.move.MoveEngine;
import pl.psi.game.spellbook.Spell;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;
import java.util.List;

import static pl.psi.game.Board.BOARD_WIDTH;

public class GameEngine implements PropertyChangeListener {

    public static final String END_OF_TURN = "END_OF_TURN";
    public static final String CREATURE_MOVED = "CREATURE_MOVED";
    public static final String CREATURE_ATTACKED = "CREATURE_ATTACKED";
    public static final String ACTIVE_CREATURE_CHANGED = "ACTIVE_CREATURE_CHANGED";
    public static final String SPELL_CASTED = "SPELL_CASTED";

    private final MoveEngine moveEngine;
    private final Board board;
    private HashMap.Entry<Point, Creature> activeCreature;
    private final Queue<Creature> creaturesQueue;
    private List<Creature> creatureMovedOnThisTurn;
    private PropertyChangeSupport propertyChangeSupport;
    private Spell selectedSpell;
    private Hero hero1;
    private Hero hero2;
    private List<Point> path;

    public GameEngine(Hero aHero1, Hero aHero2) {
        this.board = Board.getBoard();
        this.board.clearBoard();
        propertyChangeSupport = new PropertyChangeSupport(this);
        this.moveEngine = new MoveEngine(board);
        moveEngine.addObserver(CREATURE_MOVED, this);
        propertyChangeSupport.addPropertyChangeListener(ACTIVE_CREATURE_CHANGED, moveEngine);
        putHeroCreaturesIntoBoard(aHero1, 0);
        putHeroCreaturesIntoBoard(aHero2, BOARD_WIDTH);
        creaturesQueue = new LinkedList<>();
        creatureMovedOnThisTurn = new ArrayList<>();
        putCreaturesToQueue(aHero1,aHero2);

        hero1= aHero1;
        hero2= aHero2;
        path = new ArrayList<>();
    }

    private void putCreaturesToQueue(Hero aHero1, Hero aHero2) {
        List<Creature> creatures = new ArrayList<>();
        creatures.addAll(aHero1.getCreatures());
        creatures.addAll(aHero2.getCreatures());
        Collections.shuffle(creatures);
        creatures.sort(Comparator.comparingInt(Creature::getMoveRange).reversed());

        creatures.forEach(c-> addObserver(END_OF_TURN, c));

        creaturesQueue.addAll(creatures);
        Creature activeCreatureWithoutPoint = creaturesQueue.poll();
        activeCreature = new AbstractMap.SimpleEntry<>(board.getCreatureLocation(activeCreatureWithoutPoint).get(), activeCreatureWithoutPoint);
        propertyChangeSupport.firePropertyChange(ACTIVE_CREATURE_CHANGED, null, activeCreature);
    }

    public boolean isMoveAllowed(int x, int y){
        return moveEngine.isMovePossible(new Point(x,y));
    }

    public void move(int x, int y){
        moveEngine.move(x,y);
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        activeCreature = new AbstractMap.SimpleEntry<>( (Point)aPropertyChangeEvent.getNewValue(), activeCreature.getValue());
        propertyChangeSupport.firePropertyChange(CREATURE_MOVED, aPropertyChangeEvent.getOldValue(), aPropertyChangeEvent.getNewValue());
    }

    public GuiTileIf getByPoint(int x, int y){
        return board.getTile(x,y);
    }

    public Creature getCreatureByPoint (int x, int y ){
        return board.getCreature(x,y);
    }

    public void attack(int x, int y){
        activeCreature.getValue().attack(board.getCreature(x,y));
        propertyChangeSupport.firePropertyChange(CREATURE_ATTACKED,null,null);
        pass();
    }

    public boolean spellCastPossible(int x,int y,Spell selectedSpell){
        switch (selectedSpell.getTarget()){
            case ALLY:
                if(getByPoint(x,y)!=null)
                return getActiveHero().haveThisCreature(getCreatureByPoint(x,y));
                else return false;
            case ENEMY:
                if(getByPoint(x,y)!=null)
                return !getActiveHero().haveThisCreature(getCreatureByPoint(x,y)) && getByPoint(x,y).isCreature();
                else return false;
            case EMPTY: return getByPoint(x,y) == null;
            case ANY: return true;
            default: throw new IllegalStateException("Spell has wrong target");
        }
    }

    public void castSpell(int aX, int aY, Spell selectedSpell){
        Spell spellToCast = (Spell) selectedSpell.clone();
        getActiveHero().getSpellBook().decreaseMana(selectedSpell.getManaCost());
        addObserver(END_OF_TURN,spellToCast);
        spellToCast.cast(aX, aY);
    }

    public boolean isAttackPossible(int x, int y){
        GuiTileIf somethingOnTile = getByPoint(x, y);
        if(somethingOnTile != null)
            return isInAttackRange(x,y) && somethingOnTile.isCreature();
        else
        return false;
    }

    public boolean isInAttackRange(int x, int y){
        Creature creature = activeCreature.getValue();
        if(creature.canShoot()){
            return true;
        }
        return activeCreature.getKey().distance(new Point(x,y)) == 1;
    }

    public void pass() {
        creatureMovedOnThisTurn.add(activeCreature.getValue());

        if (creaturesQueue.isEmpty()){
            endOfTurn();
        }

        //creaturesQueue.stream().filter(c -> c.getAmount()==0).forEach(cr -> {board.removeCreature(cr);creaturesQueue.remove(cr);});
        //creatureMovedOnThisTurn.stream().filter(c -> c.getAmount()==0).forEach(cr -> {board.removeCreature(cr);creatureMovedOnThisTurn.remove(cr);});
        Creature creatureFromQueue = creaturesQueue.poll();
        activeCreature = new AbstractMap.SimpleEntry<>(board.getCreatureLocation(creatureFromQueue).get(), creatureFromQueue);
        propertyChangeSupport.firePropertyChange(ACTIVE_CREATURE_CHANGED, null, activeCreature);
    }

    private void endOfTurn() {
        creaturesQueue.addAll(creatureMovedOnThisTurn);
        creatureMovedOnThisTurn.clear();

        propertyChangeSupport.firePropertyChange(END_OF_TURN, null,null );
    }

    public void addObserver(String aPropertyType, PropertyChangeListener aObserver){
        propertyChangeSupport.addPropertyChangeListener(aPropertyType, aObserver);
    }

    public void addObserver(PropertyChangeListener aObserver){
        propertyChangeSupport.addPropertyChangeListener(aObserver);
    }

    public void removeObserver(PropertyChangeListener aObserver){
        propertyChangeSupport.removePropertyChangeListener(aObserver);
    }

    private void putHeroCreaturesIntoBoard(Hero aHero2, int boardWidth) {
        for (int i = 0; i < aHero2.getCreatures().size(); i++) {
            board.putCreature(boardWidth, 2 * i, aHero2.getCreatures().get(i));
        }
    }

    public HashMap.Entry<Point, Creature> getActiveCreature() {
        return activeCreature;
    }

    public boolean belongsToRightHero(Creature aCreature){
        return hero2.haveThisCreature(aCreature);
    }

    public Hero getActiveHero(){
        if (hero1.haveThisCreature(activeCreature.getValue())) return hero1;
        if (hero2.haveThisCreature(activeCreature.getValue())) return hero2;

//        for(Creature creature : hero1.getCreatures()){
//            if(creature==activeCreature.getValue()) return hero1;
//        }
//        for (Creature creature : hero2.getCreatures()){
//            if(creature==activeCreature.getValue()) return hero2;
//        }
        throw new IllegalStateException("Active creature not belong to any hero.");
    }

    public void getMovePath(int x, int y){
        path = moveEngine.getMovePath(new Point(x,y));
    }

    public boolean isPointInPath(int x, int y){
        return path.contains(new Point(x,y));
    }

    public void invokeSpellCastedEvent() {
        propertyChangeSupport.firePropertyChange(GameEngine.SPELL_CASTED,null,null);
    }
}
