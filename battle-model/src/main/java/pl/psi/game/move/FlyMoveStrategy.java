package pl.psi.game.move;

import pl.psi.game.Board;
import pl.psi.game.GameEngine;
import pl.psi.game.fractions.Creature;

import java.awt.*;
import java.beans.PropertyChangeSupport;
import java.util.*;
import java.util.List;

public class FlyMoveStrategy implements MoveStrategyIf {
    private HashMap.Entry<Point, Creature> activeCreature;
    private final Board board;
    private PropertyChangeSupport propertyChangeSupport;
    private LinkedList<GuiTileIf> moveSteps = new LinkedList();

    FlyMoveStrategy(Board aBoard, Map.Entry<Point, Creature> aActiveCreature) {
        board = aBoard;
        propertyChangeSupport = new PropertyChangeSupport(this);
        activeCreature = aActiveCreature;
    }

    @Override
    public void move(Point destPoint) {

            Point oldPosition = activeCreature.getKey();
            board.move((int) destPoint.getX(), (int) destPoint.getY(),activeCreature.getValue());
            activeCreature = new AbstractMap.SimpleEntry<>(destPoint, activeCreature.getValue());
            propertyChangeSupport.firePropertyChange(GameEngine.CREATURE_MOVED, oldPosition, activeCreature.getKey());

    }

    @Override
    public boolean isMovePossible(Point destPoint) {
        Point oldPosition = activeCreature.getKey();

        double distance = Math.abs(destPoint.getX() - oldPosition.getX()) + Math.abs(destPoint.getY() - oldPosition.getY());

        return activeCreature.getValue().getMoveRange() - distance >= 0;
    }


}
