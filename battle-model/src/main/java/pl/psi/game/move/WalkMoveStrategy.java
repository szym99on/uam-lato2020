package pl.psi.game.move;

import pl.psi.game.Board;
import pl.psi.game.GameEngine;
import pl.psi.game.fractions.Creature;

import java.awt.*;
import java.beans.PropertyChangeSupport;
import java.util.*;
import java.util.List;

import static pl.psi.game.Board.BOARD_HIGH;
import static pl.psi.game.Board.BOARD_WIDTH;

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


        activeCreature = new AbstractMap.SimpleEntry<>(destPoint, activeCreature.getValue());
        propertyChangeSupport.firePropertyChange(GameEngine.CREATURE_MOVED, oldPosition, activeCreature.getKey());
    }

    @Override
    public List<GuiTileIf> getSteps(Point destPoint) {

        return null;
    }

    @Override
    public boolean isMovePossible(Point startPoint, Point destPoint) {
        return false;
    }

    //TODO Its not working good if path is straight work ok. Should add Step counter so migrate from List to Map <Point, Integer>.
    public List countPath(Point point, Point endPoint,List path){
        double initDistance = endPoint.distance(point);

        Point up = new Point(point.x,point.y + 1);
        Point down = new Point(point.x,point.y - 1);
        Point left = new Point(point.x - 1,point.y);
        Point right = new Point(point.x + 1,point.y);

        double upDistance = endPoint.distance(up);
        double downDistance = endPoint.distance(down);
        double leftDistance = endPoint.distance(left);
        double rightDistance = endPoint.distance(right);

        if(upDistance + getMapCost(up) < initDistance){
            path.add(up);
            countPath(up,endPoint,path);
        }
        if(downDistance  + getMapCost(down)  < initDistance){
            path.add(down);
            countPath(down,endPoint,path);
        }
        if(leftDistance  + getMapCost(left) < initDistance){
            path.add(left);
            countPath(left,endPoint,path);
        }
        if(rightDistance  + getMapCost(right) < initDistance){
            path.add(right);
            countPath(right,endPoint,path);
        }

        return path;
    }

    Map<Point, Integer> mapCostGenerate(){
        Map<Point, GuiTileIf> copyBoard = Board.copyBoardValues();
        Map<Point, Integer> aStarBoard = new HashMap<>();

        for (int i = 0; i <= BOARD_WIDTH ; i++) {
            for (int j = 0; j <= BOARD_HIGH ; j++) {
                aStarBoard.put(new Point(i,j),0);
            }
        }

        for (Point key: copyBoard.keySet()
        ) {
                 aStarBoard.replace(key,Integer.MAX_VALUE);
        }
        return aStarBoard;

    }

    int getMapCost(Point point){
        Map<Point,Integer> mapCost = mapCostGenerate();

        if (point.x > BOARD_WIDTH || point.x < 0 || point.y > BOARD_HIGH || point.y < 0) {
            return Integer.MAX_VALUE;
        }
        else {
            return mapCost.get(point);
        }
    }
}
