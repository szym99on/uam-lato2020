package pl.psi.game.move;

import pl.psi.game.Board;
import pl.psi.game.GameEngine;
import pl.psi.game.fractions.Creature;

import java.awt.*;
import java.beans.PropertyChangeSupport;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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
/*
    private Point stepMove(Point destPoint){
        List<GuiTileIf> steps = getSteps(destPoint);

        Obstacle step = (Obstacle) steps.get(0);
        AtomicReference<Point> a = null;
        steps.forEach((Obstacle) s -> a.set(s.isObstacle() ? (Obstacle) s.apply(activeCreature.getValue())));
        return a.get();
    }
*/

    @Override
    public void move(Point destPoint) {
       // stepMove(destPoint);
        Point oldPosition = activeCreature.getKey();
        board.move((int) destPoint.getX(), (int) destPoint.getY(),activeCreature.getValue());
        activeCreature = new AbstractMap.SimpleEntry<>(destPoint, activeCreature.getValue());
        propertyChangeSupport.firePropertyChange(GameEngine.CREATURE_MOVED, oldPosition, activeCreature.getKey());
    }

    @Override
    public List<GuiTileIf> getSteps(Point destPoint) {
        Point oldPosition = activeCreature.getKey().getLocation();

        List<Point> path = new LinkedList();
        path = countPath(oldPosition,destPoint,path);


        List returnPath = new LinkedList();
        path.forEach(p->returnPath.add(board.getObject(p.x,p.y)));

        return returnPath;
    }

    @Override
    public boolean isMovePossible(Point startPoint, Point destPoint) {

        List<Point> path = new LinkedList();
        path = countPath(startPoint, destPoint, path);

        if( path.size() - 1 > activeCreature.getValue().getMoveRange() ){
            return false;
        }
        if ( !path.get(path.size() - 1).equals(destPoint)){
            return false;
        }
        return true;
    }

    public List countPath(Point point, Point endPoint,List path){

        Point up = new Point(point.x,point.y + 1);
        Point down = new Point(point.x,point.y - 1);
        Point left = new Point(point.x - 1,point.y);
        Point right = new Point(point.x + 1,point.y);

        double upDistance = endPoint.distance(up)  + getMapCost(up) + pointInPath(path,up);
        double downDistance = endPoint.distance(down) + getMapCost(down) + pointInPath(path,down);
        double leftDistance = endPoint.distance(left) + getMapCost(left) + pointInPath(path,left);
        double rightDistance = endPoint.distance(right) + getMapCost(right) + pointInPath(path,right);

        //TODO this is ugly, but works. Now I don't now how do it better
        if(point.equals(endPoint)){
            return path;
        } else

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


    int pointInPath(List path, Point point){
       if( path.contains(point))
       {
           return Integer.MAX_VALUE;
       }
       else {
           return 0;
       }
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
                if(Board.getBoard().getTile(key.x, key.y).isCreature()){
                 aStarBoard.replace(key,Integer.MAX_VALUE);
                } else {
                    aStarBoard.replace(key,200);
                }
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
