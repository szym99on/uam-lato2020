package pl.psi.game.move;

import pl.psi.game.Board;
import pl.psi.game.GameEngine;
import pl.psi.game.fractions.Creature;

import java.awt.*;
import java.beans.PropertyChangeSupport;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class WalkMoveStrategy implements MoveStrategyIf {

    private HashMap.Entry<Point, Creature> activeCreature;
    private final Board board;
    private PropertyChangeSupport propertyChangeSupport;
    private final PathCounter pathCounter;

    WalkMoveStrategy(Board aBoard, Map.Entry<Point, Creature> aActiveCreature) {
        board = aBoard;
        propertyChangeSupport = new PropertyChangeSupport(this);
        activeCreature = aActiveCreature;
        pathCounter = new PathCounter("walk");
    }

    @Override
    public void move(Point destPoint) {
        if(isMovePossible(destPoint)) {
            List<Point> path = getMovePath(destPoint);
            List<GuiTileIf> pathObs = getObstaclesFromPath(path);
            List<DealDamageObstacle> pathDealDamageObs = pathObs.stream().filter(t -> t instanceof DealDamageObstacle).map(o -> (DealDamageObstacle) o).collect(Collectors.toList());
            pathDealDamageObs.forEach(o -> o.apply(activeCreature.getValue()));


            Point oldPosition = activeCreature.getKey();
            board.move((int) destPoint.getX(), (int) destPoint.getY(), activeCreature.getValue());
            activeCreature = new AbstractMap.SimpleEntry<>(destPoint, activeCreature.getValue());
            propertyChangeSupport.firePropertyChange(GameEngine.CREATURE_MOVED, oldPosition, activeCreature.getKey());
        }else{
            throw new IllegalArgumentException("You cannot move to this point!");
        }
    }


    @Override
    public boolean isMovePossible(Point destPoint) {
        List<Point> path = getMovePath(destPoint);
        List<GuiTileIf> pathObs = getObstaclesFromPath(path);
        boolean returnValue = false;
        List<ReduceMoveRangeObstacle> reduceMoveRangeObstacles = pathObs.stream()
                .filter(t -> t instanceof ReduceMoveRangeObstacle)
                .map(o -> (ReduceMoveRangeObstacle) o)
                .collect(Collectors.toList());
        int moveRangeReduce = reduceMoveRangeObstacles.stream().mapToInt(ReduceMoveRangeObstacle::getMoveReduce).sum();

        if (path.size() - 1 <= activeCreature.getValue().getMoveRange() - moveRangeReduce) {

            for (Point point : path) {
                if (board.getTile((int) point.getX(), (int) point.getY()) == null) {
                    returnValue = true;
                } else if (board.getTile((int) point.getX(), (int) point.getY()).isObstacle()) {
                    returnValue = board.getObstacle((int) point.getX(), (int) point.getY()).isPassable();
                    if (!returnValue) break;
                } else if (board.getTile((int) point.getX(), (int) point.getY()).isCreature()) {
                    returnValue = false;
                    break;
                }
            }
        }else {
            returnValue = false;
        }
        return returnValue;

    }

    @Override
    public List<Point> getMovePath(Point destPoint) {
        Point oldPosition = activeCreature.getKey().getLocation();

        pathCounter.init(oldPosition);
        List<Point> path = new LinkedList();
        path.add(oldPosition);
        path = pathCounter.countPath(oldPosition,destPoint,path);

        return pathCounter.removeBadPaths(path, oldPosition, destPoint);
    }

    private List<GuiTileIf> getObstaclesFromPath(List<Point> path) {
        List<GuiTileIf> returnPath = new LinkedList();
        path.forEach(p->returnPath.add((GuiTileIf)board.getObstacle(p.x,p.y)));

        return returnPath;
    }
}
