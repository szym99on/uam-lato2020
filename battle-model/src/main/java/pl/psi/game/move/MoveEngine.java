package pl.psi.game.move;

import pl.psi.game.Board;
import pl.psi.game.fractions.Creature;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


public class MoveEngine implements PropertyChangeListener {


    private HashMap.Entry<Point, Creature> activeCreature;
    private final Board board;
    private PropertyChangeSupport propertyChangeSupport;
    private MoveStrategyIf moveStrategyIf;

    public MoveEngine(Board aBoard) {
        board = aBoard;
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public boolean isMovePossible(Point endPoint) {
        return board.isTileEmpty((int) endPoint.getX(),(int) endPoint.getY()) && endPoint.distance(activeCreature.getKey()) <= activeCreature.getValue().getMoveRange();
    }

    public void move(int x, int y) {
        if(activeCreature.getValue().isCanFly()) {
            //activeCreature.getValue().getMoveStrategy().move(x,y);
            moveStrategyIf = new FlyMoveStrategy(board, activeCreature);
        } else {
            moveStrategyIf = new WalkMoveStrategy(board, activeCreature);
        }

        AtomicReference<Point> endPoint = new AtomicReference<>(null);
        List<GuiTileIf> path = getMovePath(x, y);
        List<ObstacleIf> pathObs = path.stream().filter(t -> t instanceof ObstacleIf).map(o -> (ObstacleIf)o).collect(Collectors.toList());
        // pathObs.forEach(o -> endPoint.set(o.apply(activeCreature.getValue())));

        if(endPoint.get() == null){
            endPoint.set(new Point(x,y));
        }

        moveStrategyIf.move(endPoint.get());
    }

    public List<GuiTileIf> getMovePath(int x, int y){
        if(activeCreature.getValue().isCanFly()) {
            moveStrategyIf = new FlyMoveStrategy(board, activeCreature);
        } else {
            moveStrategyIf = new WalkMoveStrategy(board, activeCreature);
        }
        return moveStrategyIf.getSteps(new Point(x, y));
    }

    public HashMap.Entry<Point, Creature> getActiveCreature() {
        return activeCreature;
    }



/*    public void wait(){
    // ta metoda będzie pomijała ruch danej kreatury, przenosząc ją na koniec kolejki.
   // Każda kreatura może wykonać tę metodę raz na turę

    }
  */

/*    public int howManyFieldsWalked(){
    //Metoda zwróci odległość jaką przebyła kreatura. (Dla poprawnej implementacji ataku np. kawalerzysty)
}
 */

    /* public boolean isFieldOnCreatureBack(){
         //Metoda zwróci true jeśli pole jest za plecami kreatury. Będzie potrzebne dla obliczania bonusu ataku od tyłu
     }
 */
    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        activeCreature = (HashMap.Entry<Point, Creature>)aPropertyChangeEvent.getNewValue();
    }

    void setActiveCreature(Point aPoint, Creature aCreature) {
        activeCreature = new AbstractMap.SimpleEntry<>(aPoint, aCreature);
    }

    public void addObserver(String aPropertyType, PropertyChangeListener aObserver){
        propertyChangeSupport.addPropertyChangeListener(aPropertyType, aObserver);
    }

    public void removeObserver(PropertyChangeListener aObserver){
        propertyChangeSupport.removePropertyChangeListener(aObserver);
    }
}
