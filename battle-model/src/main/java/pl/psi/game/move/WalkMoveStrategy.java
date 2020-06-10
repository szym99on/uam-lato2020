package pl.psi.game.move;

import pl.psi.game.Board;
import pl.psi.game.GameEngine;
import pl.psi.game.fractions.Creature;

import java.awt.*;
import java.beans.PropertyChangeSupport;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WalkMoveStrategy implements MoveStrategyIf {

    private HashMap.Entry<Point, Creature> activeCreature;
    private final Board board;
    private PropertyChangeSupport propertyChangeSupport;

    WalkMoveStrategy(Board aBoard, Map.Entry<Point, Creature> aActiveCreature) {
        board = aBoard;
        propertyChangeSupport = new PropertyChangeSupport(this);
        activeCreature = aActiveCreature;
    }

    @Override
    public void move(Point destPoint) {
        Point oldPosition = activeCreature.getKey();

        int xDistance = (int) Math.abs(destPoint.getX() - oldPosition.getX());
        int yDistance = (int) Math.abs(destPoint.getY() - oldPosition.getY());
/*
        //TODO Improve to A* Algoritm
        for (int i = 0; i < Math.max(xDistance,yDistance) ; i++) {
            if(i < xDistance ) {
                board.move(oldPosition.x + goDirection(x, oldPosition.x), oldPosition.y, activeCreature.getValue());
            }

            if(i < yDistance ) {
                board.move(oldPosition.x, oldPosition.y + goDirection(y, oldPosition.y), activeCreature.getValue());
            }
        }
*/
        activeCreature = new AbstractMap.SimpleEntry<>(destPoint, activeCreature.getValue());
        propertyChangeSupport.firePropertyChange(GameEngine.CREATURE_MOVED, oldPosition, activeCreature.getKey());
    }

    @Override
    public List<GuiTileIf> getSteps(Point destPoint) {

        return null;
    }

    @Override
    public boolean isMovePossible(Board board, Point startPoint, Point destPoint) {
        return false;
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
