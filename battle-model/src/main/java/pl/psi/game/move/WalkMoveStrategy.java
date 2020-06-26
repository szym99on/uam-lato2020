package pl.psi.game.move;

import pl.psi.game.Board;
import pl.psi.game.GameEngine;
import pl.psi.game.fractions.Creature;

import java.awt.*;
import java.beans.PropertyChangeSupport;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static pl.psi.game.Board.BOARD_HIGH;
import static pl.psi.game.Board.BOARD_WIDTH;

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

        AtomicReference<Point> endPoint = new AtomicReference<>(null);
        List<GuiTileIf> path = getSteps(destPoint);
        List<ImpactMoveObstacle> pathObs = path.stream().filter(t -> t instanceof ImpactMoveObstacle).map(o -> (ImpactMoveObstacle)o).collect(Collectors.toList());
        //pathObs.forEach(o -> endPoint.set(o.apply()));

        if(endPoint.get() == null){
            endPoint.set(destPoint);
        }

        Point oldPosition = activeCreature.getKey();
        board.move((int) endPoint.get().getX(), (int) endPoint.get().getY(),activeCreature.getValue());
        activeCreature = new AbstractMap.SimpleEntry<>(endPoint.get(), activeCreature.getValue());
        propertyChangeSupport.firePropertyChange(GameEngine.CREATURE_MOVED, oldPosition, activeCreature.getKey());
    }


    @Override
    public boolean isMovePossible(Point destPoint) {
        Point oldPosition = activeCreature.getKey();

        List<Point> path = new LinkedList();
        path = pathCounter.countPath(oldPosition, destPoint, path);

        if( path.size() - 1 > activeCreature.getValue().getMoveRange() ){
            return false;
        }
        return true;
    }

    @Override
    public List<Point> getMovePath(Point destPoint) {
        Point oldPosition = activeCreature.getKey().getLocation();

        List<Point> path = new LinkedList();
        path = pathCounter.countPath(oldPosition,destPoint,path);

        return path;
    }

    private List<GuiTileIf> getSteps(Point destPoint) {
        List<Point> path = getMovePath(destPoint);

        List<GuiTileIf> returnPath = new LinkedList();
        path.forEach(p->returnPath.add((GuiTileIf)board.getObstacle(p.x,p.y)));

        return returnPath;
    }
}
