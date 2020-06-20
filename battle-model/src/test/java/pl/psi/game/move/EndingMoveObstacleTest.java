package pl.psi.game.move;

import org.junit.jupiter.api.Test;
import pl.psi.game.Board;
import pl.psi.game.fractions.Creature;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EndingMoveObstacleTest {

    @Test
    void applyShouldReturnNewEndPointForCreature() {
        Creature creature = Creature.builder().aCanFly(false).build();
        ObstacleFactory factory = new ObstacleFactory();
        Obstacle obstacle = factory.createObstacle("river", new Point(1, 1));
        assertEquals(new Point(1,1),obstacle.apply(creature));
    }

    @Test
    void applyErrorCase() {
        Creature creature = Creature.builder().aCanFly(false).build();
        ObstacleFactory factory = new ObstacleFactory();
        Obstacle obstacle = factory.createObstacle("river", new Point(1, 1));
        assertNotEquals(new Point(9,1),obstacle.apply(creature));
    }

    @Test
    void endingMoveObstacleWorks(){
        Creature creature = Creature.builder().aCanFly(false).build();
        Board board = Board.getBoard();
        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(5,5), creature);
        board.clearBoard();
        Board.getBoard();
        board.putCreature(5,5, creature);

        ObstacleFactory obstacleFactory = new ObstacleFactory();
        Obstacle river1 = obstacleFactory.createObstacle("river", new Point(5,7));
        Obstacle river2 =  obstacleFactory.createObstacle("river", new Point(4,6));
        Obstacle river3 = obstacleFactory.createObstacle("river", new Point(4,5));
        Obstacle river4 =  obstacleFactory.createObstacle("river", new Point(6,6));
        Obstacle river5 = obstacleFactory.createObstacle("river", new Point(6,5));
        Obstacle river6 =  obstacleFactory.createObstacle("river", new Point(5,4));

        board.putObstacle(river1);
        board.putObstacle(river2);
        board.putObstacle(river3);
        board.putObstacle(river4);
        board.putObstacle(river5);
        board.putObstacle(river6);

        moveEngine.move(5,9);

        assertEquals(creature, board.getCreature(5,7));
        assertNull(board.getCreature(5,5));
    }


    @Test
    void endingMoveObstacleFlyShouldNoWorks(){
        Creature creature = Creature.builder().aCanFly(true).build();
        Board board = Board.getBoard();
        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(5,5), creature);
        board.clearBoard();
        Board.getBoard();
        board.putCreature(5,5, creature);

        java.util.List<Point> paths = new LinkedList<>();
        paths.add(new Point(5,5));
        ObstacleFactory obstacleFactory = new ObstacleFactory();
        Obstacle river1 = obstacleFactory.createObstacle("river", new Point(5,7));
        Obstacle river2 =  obstacleFactory.createObstacle("river", new Point(4,6));
        Obstacle river3 = obstacleFactory.createObstacle("river", new Point(4,5));
        Obstacle river4 =  obstacleFactory.createObstacle("river", new Point(6,6));
        Obstacle river5 = obstacleFactory.createObstacle("river", new Point(6,5));
        Obstacle river6 =  obstacleFactory.createObstacle("river", new Point(5,4));

        board.putObstacle(river1);
        board.putObstacle(river2);
        board.putObstacle(river3);
        board.putObstacle(river4);
        board.putObstacle(river5);
        board.putObstacle(river6);

        moveEngine.move(5,9);

        assertEquals(creature, board.getCreature(5,9));
        assertNull(board.getCreature(5,5));
    }
}
