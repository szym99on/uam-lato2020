package pl.psi.game.move;

import pl.psi.game.Board;
import pl.psi.game.GameEngine;
import pl.psi.game.fractions.Creature;

import java.awt.*;
import java.beans.PropertyChangeSupport;
import java.util.*;
import java.util.List;

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
    public boolean isMovePossible(Point startPoint, Point destPoint) {
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

    public void AStar(Point startPoint, Point endPoint){
       List list = new LinkedList<Point>();
        list.add(startPoint);
        AStarStep(list,endPoint);

    }

    void AStarStep(List<Point> path,Point endPoint){
        List temp = new LinkedList<Point>();

        while(temp.get(temp.size()) == endPoint) {
            Point stepUp = goUp(path.get(path.size()));
            temp.addAll(path);
            temp.add(stepUp);
            AStarStep(temp, endPoint);
            temp.clear();

            Point stepDown = goDown(path.get(path.size()));
            temp.addAll(path);
            temp.add(stepDown);
            AStarStep(temp, endPoint);
            temp.clear();

            Point stepLeft = goLeft(path.get(path.size()));
            temp.addAll(path);
            temp.add(stepLeft);
            AStarStep(temp, endPoint);
            temp.clear();

            Point stepRight = goRight(path.get(path.size()));
            temp.addAll(path);
            temp.add(stepRight);
            AStarStep(temp, endPoint);
            temp.clear();
        }
    }



    Point goDown(Point point){
        return new Point(point.x, point.y - 1);
    }

    Point goUp(Point point){
        return new Point(point.x, point.y + 1);
    }

    Point goLeft(Point point){
        return new Point(point.x - 1, point.y);
    }

    Point goRight(Point point){
        return new Point(point.x + 1, point.y);
    }

    Map<Point, Integer> mapCostGenerate(){
        Map<Point, GuiTileIf> copyBoard = Board.copyBoardValues();
        Map<Point, Integer> aStarBoard = new HashMap<>();

        for (int i = 1; i <= Board.BOARD_WIDTH ; i++) {
            for (int j = 0; j <= Board.BOARD_HIGH ; j++) {
                aStarBoard.put(new Point(i,j),0);
            }
        }

        for (Point key: copyBoard.keySet()
        ) {
                 aStarBoard.replace(key,Integer.MAX_VALUE);
        }
        return aStarBoard;

    }

}
