package pl.psi.game.move;

import pl.psi.game.Board;
import pl.psi.game.GameEngine;
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
    private boolean isMoveAllow = true;

    public MoveEngine(Board aBoard) {

        board = aBoard;
        propertyChangeSupport = new PropertyChangeSupport(this);

    }

    public boolean isMovePossible(Point endPoint) {
        setMoveStrategy();
        return moveStrategyIf.isMovePossible(endPoint);
    }

    public void move(int x, int y) {
        if (isMoveAllow) {
            Point oldPosition = activeCreature.getKey();
            setMoveStrategy();
            moveStrategyIf.move(new Point(x, y));
            isMoveAllow = false;
            propertyChangeSupport.firePropertyChange(GameEngine.CREATURE_MOVED, oldPosition, new Point(x, y));
        }
    }

    public List<Point> getMovePath(Point destPoint) {
        setMoveStrategy();
        return moveStrategyIf.getMovePath(destPoint);
    }

    public HashMap.Entry<Point, Creature> getActiveCreature() {
        return activeCreature;
    }

    private void setMoveStrategy() {
        if (activeCreature.getValue().isCanFly()) {
            moveStrategyIf = new FlyMoveStrategy(board, activeCreature);
        } else {
            moveStrategyIf = new WalkMoveStrategy(board, activeCreature);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        activeCreature = (HashMap.Entry<Point, Creature>) aPropertyChangeEvent.getNewValue();
        isMoveAllow = true;
    }

    void setActiveCreature(Point aPoint, Creature aCreature) {
        activeCreature = new AbstractMap.SimpleEntry<>(aPoint, aCreature);
        setMoveStrategy();
    }

    public void addObserver(String aPropertyType, PropertyChangeListener aObserver) {
        propertyChangeSupport.addPropertyChangeListener(aPropertyType, aObserver);
    }

    public void removeObserver(PropertyChangeListener aObserver) {
        propertyChangeSupport.removePropertyChangeListener(aObserver);
    }


}
