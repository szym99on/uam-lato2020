package pl.psi.game.move;

import pl.psi.game.Board;
import pl.psi.game.GameEngine;
import pl.psi.game.fractions.Creature;

import java.awt.*;
import java.beans.PropertyChangeSupport;
import java.util.*;
import java.util.List;
import java.util.stream.DoubleStream;

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
        Point oldPosition = activeCreature.getKey().getLocation();

        List<Point> path = new LinkedList();
        path = countPath(oldPosition,destPoint,path);


        List returnPath = new LinkedList();

        path.forEach(p->returnPath.add(new EmptyTile(p)));

        return returnPath;
    }

    @Override
    public boolean isMovePossible(Point startPoint, Point destPoint) {
        return false;
    }

    public List countPath(Point point, Point endPoint,List path){
        Point up = new Point(point.x,point.y + 1);
        Point down = new Point(point.x,point.y - 1);
        Point left = new Point(point.x - 1,point.y);
        Point right = new Point(point.x + 1,point.y);

        double upDistance = endPoint.distance(up)  + getMapCost(up);
        double downDistance = endPoint.distance(down) + getMapCost(down);
        double leftDistance = endPoint.distance(left) + getMapCost(left);
        double rightDistance = endPoint.distance(right) + getMapCost(right);

        if(point.equals(endPoint)){
            return path;
        }

            if (upDistance <= downDistance && upDistance <= leftDistance && upDistance <= rightDistance) {
                path.add(up);
                countPath(up, endPoint, path);
            }
            if (downDistance < upDistance && downDistance < leftDistance && downDistance < rightDistance) {
                path.add(down);
                countPath(down, endPoint, path);
            }
            if (leftDistance < upDistance && leftDistance < downDistance && leftDistance < rightDistance) {
                path.add(left);
                countPath(left, endPoint, path);
            }
            if (rightDistance < upDistance && rightDistance < downDistance && rightDistance < leftDistance) {
                path.add(right);
                countPath(right, endPoint, path);
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

    OptionalDouble min(double... vals) {
        return DoubleStream.of(vals).min();
    }
}
