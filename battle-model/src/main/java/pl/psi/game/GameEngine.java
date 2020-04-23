package pl.psi.game;

import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.move.GuiTileIf;
import pl.psi.game.move.MoveEngine;

import java.awt.*;
import java.util.*;
import java.util.List;

import static pl.psi.game.Board.BOARD_WIDTH;

public class GameEngine {

    private final MoveEngine moveEngine;
    private final Board board;
    private HashMap.Entry<Point, Creature> activeCreature;
    private final Queue<Creature> creaturesQueue;

    public GameEngine(Hero aHero1, Hero aHero2) {
        this.board = new Board();
        putHeroCreaturesIntoBoard(aHero1, 0);
        putHeroCreaturesIntoBoard(aHero2, BOARD_WIDTH);
        creaturesQueue = new LinkedList<>();
        putCreaturesToQueue(aHero1,aHero2);

        this.moveEngine = new MoveEngine(board);
    }

    private void putCreaturesToQueue(Hero aHero1, Hero aHero2) {
        List<Creature> creatures = aHero1.getCreatures();
        creatures.addAll(aHero2.getCreatures());
        Collections.shuffle(creatures);
        creatures.sort(Comparator.comparingInt(Creature::getMoveRange).reversed());
        creaturesQueue.addAll(creatures);
        pass();
    }

    public boolean isMoveAllowed(int x, int y){
        return moveEngine.isMovePossible(x,y);
    }

    public void move(int x, int y){
        moveEngine.move(x,y);
    }

    public GuiTileIf getByPoint(int x, int y){
        return board.getTile(x,y);
    }

    public Creature getCreatureByPoint (int x, int y ){
        return board.getCreature(x,y);
    }

    public void attack(int x, int y){
        activeCreature.getValue().attack(board.getCreature(x,y));
    }

    public boolean isAttackPossible(int x, int y){
        Creature creature = activeCreature.getValue();
        if(creature.canShoot()){
            return true;
        }
        return activeCreature.getKey().distance(new Point(x,y)) == 1;
    }

    public void pass() {
        Creature creatureFromQueue = creaturesQueue.poll();
        creaturesQueue.add(creatureFromQueue);
        activeCreature = new AbstractMap.SimpleEntry<>(board.getCreatureLocation(creatureFromQueue).get(), creatureFromQueue);
    }

    private void putHeroCreaturesIntoBoard(Hero aHero2, int boardWidth) {
        for (int i = 0; i < aHero2.getCreatures().size(); i++) {
            board.putCreature(boardWidth, 2 * i, aHero2.getCreatures().get(i));
        }
    }

    public HashMap.Entry<Point, Creature> getActiveCreature() {
        return activeCreature;
    }

}
