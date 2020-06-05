package pl.psi.game.move;

import pl.psi.game.Board;
import pl.psi.game.GameEngine;
import pl.psi.game.fractions.Creature;

import java.awt.*;
import java.beans.PropertyChangeSupport;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class WalkMoveStrategy implements MoveStrategyIf {

    private HashMap.Entry<Point, Creature> activeCreature;
    private final Board board;
    private PropertyChangeSupport propertyChangeSupport;

    MoveStrategyWalk(Board aBoard, Map.Entry<Point, Creature> aActiveCreature) {
        board = aBoard;
        propertyChangeSupport = new PropertyChangeSupport(this);
        activeCreature = aActiveCreature;
    }

    @Override
    public void move(int x, int y) {
        Point oldPosition = activeCreature.getKey();

        double xDistance = Math.abs(x - oldPosition.getX());
        double yDistance = Math.abs(y - oldPosition.getY());

        //TODO Improve to A* Algoritm
        for (int i = 0; i < Math.max(xDistance,yDistance) ; i++) {
            if(i < xDistance ) {
                board.move(oldPosition.x + goDirection(x, oldPosition.x), oldPosition.y, activeCreature.getValue());
            }

            if(i < yDistance ) {
                board.move(oldPosition.x, oldPosition.y + goDirection(y, oldPosition.y), activeCreature.getValue());
            }
        }

        activeCreature = new AbstractMap.SimpleEntry<>(new Point(x,y), activeCreature.getValue());
        propertyChangeSupport.firePropertyChange(GameEngine.CREATURE_MOVED, oldPosition, activeCreature.getKey());
    }

    @Override
    public LinkedList getSteps(int finalX, int finalY) {

        return null;
    }

    int goDirection(int x, int oldX){
        if(x > oldX) {
            return 1;
        }

        if(x < oldX) {
            return -1;
        }
        return 0;
    }

    private void AStar(int startX, int startY, int finishX, int finishY){
        Board aStarBoard = Board.getBoard();
    }

}
