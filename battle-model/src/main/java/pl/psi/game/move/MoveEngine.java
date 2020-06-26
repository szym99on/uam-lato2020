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

    private boolean isTrue(){
        return true;
    }

    public boolean isMovePossible(Point endPoint) {
        setMoveStrategy();
        return moveStrategyIf.isMovePossible(endPoint);
    }

    /* We have a specific isMovePossible in fly and walk strategy
    public boolean isMovePossible(Point endPoint) {
        return board.isTileEmpty((int) endPoint.getX(),(int) endPoint.getY()) && endPoint.distance(activeCreature.getKey()) <= activeCreature.getValue().getMoveRange();
    }
     */
    public void move(int x, int y) {
          setMoveStrategy();
          moveStrategyIf.move(new Point(x,y));
        }

    public HashMap.Entry<Point, Creature> getActiveCreature() {
        return activeCreature;
    }

    public void setMoveStrategy() {
        if(activeCreature.getValue().isCanFly()) {
            moveStrategyIf = new FlyMoveStrategy(board, activeCreature);
        } else {
            moveStrategyIf = new WalkMoveStrategy(board, activeCreature);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        activeCreature = (HashMap.Entry<Point, Creature>)aPropertyChangeEvent.getNewValue();
    }

    void setActiveCreature(Point aPoint, Creature aCreature) {
        activeCreature = new AbstractMap.SimpleEntry<>(aPoint, aCreature);
        setMoveStrategy();
    }

    public void addObserver(String aPropertyType, PropertyChangeListener aObserver){
        propertyChangeSupport.addPropertyChangeListener(aPropertyType, aObserver);
    }

    public void removeObserver(PropertyChangeListener aObserver){
        propertyChangeSupport.removePropertyChangeListener(aObserver);
    }
}
