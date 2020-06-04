package pl.psi.game.move;

import pl.psi.game.Board;
import pl.psi.game.GameEngine;
import pl.psi.game.fractions.Creature;

import java.awt.*;
import java.beans.PropertyChangeSupport;
import java.util.*;

public class MoveStrategyFly implements MoveStrategyIf {
    private HashMap.Entry<Point, Creature> activeCreature;
    private final Board board;
    private PropertyChangeSupport propertyChangeSupport;
    private LinkedList<Step> moveSteps = new LinkedList();

    MoveStrategyFly(Board aBoard, Map.Entry<Point, Creature> aActiveCreature) {
        board = aBoard;
        propertyChangeSupport = new PropertyChangeSupport(this);
        activeCreature = aActiveCreature;
    }

    @Override
    public void move(int x, int y) {

            Point oldPosition = activeCreature.getKey();
            board.move(x,y,activeCreature.getValue());
            activeCreature = new AbstractMap.SimpleEntry<>(new Point(x,y), activeCreature.getValue());
            propertyChangeSupport.firePropertyChange(GameEngine.CREATURE_MOVED, oldPosition, activeCreature.getKey());
    }

    private int goDirection(int x, int oldX){
        if(x > oldX) {
            return 1;
        }

        if(x < oldX) {
            return -1;
        }
        return 0;
    }

    @Override
    public LinkedList getSteps(int finalX, int finalY) {
        Point oldPosition = activeCreature.getKey();

        int oldX = oldPosition.x;
        int oldY = oldPosition.y;

        double xDistance = Math.abs(finalX - oldPosition.getX());
        double yDistance = Math.abs(finalY - oldPosition.getY());

        for (int i = 0; i < Math.max(xDistance,yDistance) ; i++) {

            if(i < xDistance ) {
                oldX += goDirection(finalX, oldX);
                moveSteps.add(new Step(oldX, oldY));
            }

            if(i < yDistance ) {
                oldY += goDirection(finalY, oldY);
                moveSteps.add(new Step(oldX, oldY));
            }
        }
        return moveSteps;
    }


}
