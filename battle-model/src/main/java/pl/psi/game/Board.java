package pl.psi.game;

import pl.psi.game.fractions.Creature;
import pl.psi.game.move.GuiTileIf;
import pl.psi.game.move.ObstacleFactory;
import pl.psi.game.move.ObstacleIf;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Board {

    private final Map<Point, GuiTileIf> board;
    private Map<Point, ObstacleIf> obstacleInactive = new HashMap<>();
    public final static int BOARD_WIDTH = 14;
    public final static int BOARD_HIGH = 9;

    private static Board INSTANCE = null;

    public Board() {
        board = new HashMap<>();
        ObstacleFactory obstacleFactory = new ObstacleFactory();
        putObstacle(obstacleFactory.createImpactMoveObstacle("rock", new Point(7, 2)));
        putObstacle(obstacleFactory.createImpactMoveObstacle("rock", new Point(7, 3)));
        putObstacle(obstacleFactory.createImpactMoveObstacle("rock", new Point(7, 4)));
        putObstacle(obstacleFactory.createImpactMoveObstacle("rock", new Point(7, 5)));
        putObstacle(obstacleFactory.createImpactMoveObstacle("rock", new Point(7, 6)));
        putObstacle(obstacleFactory.createImpactMoveObstacle("rock", new Point(7, 7)));
    }

    public static Map<Point, GuiTileIf> copyBoardValues(){
        Map<Point, GuiTileIf> newMap = new HashMap<>();
        INSTANCE.board.forEach(newMap::put);

        return newMap;
    }

    public static Board getBoard()
    {
        if (INSTANCE == null)
            INSTANCE = new Board();

        return INSTANCE;
    }

    public void clearBoard(){
        board.clear();
    }

    public void putCreature(int x, int y, Creature aCreature) {
        if (x > BOARD_WIDTH || x < 0 || y > BOARD_HIGH || y < 0) {
            throw new IllegalArgumentException("You tried put creature outside the board");
        }

        if (!isTileEmpty(x, y)) {
            throw new IllegalArgumentException("Field isn't empty");
        }

        board.put(new Point(x, y), aCreature);
    }

    public void putObstacle(ObstacleIf aObstacle) {
        Point point = aObstacle.getPoint();
        int x = (int) point.getX();
        int y = (int) point.getY();
        if (x > BOARD_WIDTH || x < 0 || y > BOARD_HIGH || y < 0) {
            throw new IllegalArgumentException("You tried put obstacle outside the board");
        }

        if (!isTileEmpty(x, y)) {
            throw new IllegalArgumentException("Field isn't empty");
        }

        board.put(new Point(x, y), aObstacle);
    }

    public boolean isTileEmpty(int x, int y) {
        return !board.containsKey(new Point(x, y));
    }

    public Creature getCreature(int x, int y) {
        if (board.get(new Point(x, y)) != null) {
            if (board.get(new Point(x, y)).isCreature()) {
                return (Creature) board.get(new Point(x, y));
            }
        }
        return null;
    }

    public ObstacleIf getObstacle(int x, int y) {
        if (board.get(new Point(x, y)) != null) {
            if (board.get(new Point(x, y)).isObstacle()) {
                return (ObstacleIf) board.get(new Point(x, y));
            }
        }
        return null;
    }

/*    public GuiTileIf getObject(int x, int y){
        if (board.get(new Point(x, y)) != null) {
            if (board.get(new Point(x, y)).isObstacle()) {
                return board.get(new Point(x, y));
            }
        }
        return null;

    }
*/
    public GuiTileIf getTile(int x, int y) {
        return board.get(new Point(x, y));
    }

    public Optional<Point> getCreatureLocation(Creature c1) {
        return board.keySet().stream().filter(p -> board.get(p).equals(c1)).findAny();
    }

    public void move(int x, int y, Creature activeCreature) {
        Point oldPosition = getCreatureLocation(activeCreature).get();
        ObstacleIf obstacle = this.getObstacle(x, y);
        try {
            board.remove(oldPosition);
            if(this.getObstacle(x, y) != null){
                obstacleInactive.put(obstacle.getPoint(),obstacle);
                board.remove(obstacle.getPoint());
            }
            putCreature(x, y, activeCreature);

            if(obstacleInactive.containsKey(new Point(oldPosition.x, oldPosition.y))){
                this.putObstacle(obstacleInactive.get(new Point(oldPosition.x, oldPosition.y)));
                obstacleInactive.remove(new Point(oldPosition.x, oldPosition.y));
            }
        } catch (Exception e) {
            putCreature(oldPosition.x, oldPosition.y, activeCreature);
        }
    }
    public void removeCreature(Creature c)
    {
        board.remove(getCreatureLocation(c).get());
    }

    private void doNothing(){}
}
