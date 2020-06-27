package pl.psi.game.move;

import org.junit.jupiter.api.Test;
import pl.psi.game.Board;
import pl.psi.game.fractions.Creature;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ReduceMoveRangeObstacleTest {


    @Test
    void reduceMoveRangeWalkingCreature(){
        Creature creature = Creature.builder().aCanFly(false).aMoveRange(5).build();
        Board board = Board.getBoard();
        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(5,5), creature);
        board.clearBoard();
        board.putCreature(5,5, creature);
        //    3 4 5 6 7
        //  3 x x o x x
        //  4 x o M o x
        //  5 x R C R x
        //  6 x x R x x
        ObstacleFactory obstacleFactory = new ObstacleFactory();
        board.putObstacle( obstacleFactory.createImpactMoveObstacle("marsh", new Point(5,6)) );
        board.putObstacle( obstacleFactory.createImpactMoveObstacle("rock", new Point(4,5)) );
        board.putObstacle( obstacleFactory.createImpactMoveObstacle("rock", new Point(6,5)) );
        board.putObstacle( obstacleFactory.createImpactMoveObstacle("rock", new Point(5,4)) );

        assertTrue(moveEngine.isMovePossible(new Point(5, 3)));
        assertTrue(moveEngine.isMovePossible(new Point(4,4)));
        assertTrue(moveEngine.isMovePossible(new Point(6, 4)));
        assertTrue(moveEngine.isMovePossible(new Point(5, 4)));

        assertFalse(moveEngine.isMovePossible(new Point(4, 5)));
        assertFalse(moveEngine.isMovePossible(new Point(6, 5)));
        assertFalse(moveEngine.isMovePossible(new Point(5, 6)));k
        assertFalse(moveEngine.isMovePossible(new Point(3, 5)));
        assertFalse(moveEngine.isMovePossible(new Point(7, 5)));
        assertFalse(moveEngine.isMovePossible(new Point(4, 6)));
        assertFalse(moveEngine.isMovePossible(new Point(6, 6)));



    }

    @Test
    void reduceMoveRangeFlyingCreature(){
        Creature creature = Creature.builder().aCanFly(true).aMoveRange(5).build();
        Board board = Board.getBoard();
        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(5,5), creature);
        board.clearBoard();
        board.putCreature(5,5, creature);

        //    0 1 2 3 4 5 6 7 8 9 0 1
        // 0  x x x x x o x x x x x x
        // 1  x x x x o o o x x x x x
        // 2  x x x o o R o o o x x x
        // 3  x x o o o o o o o o x x
        // 4  x o o o R R R o o o o x
        // 5  o o R o R C R o R o o o
        // 6  x o o o R R R o o o o x
        // 7  x x o o o o o o o o x x
        // 8  x x x o o R o o o x x x
        // 9  x x x x o o o o x x x x
        // 10 x x x x x o o x x x x x
        // 11 x x x x x o x x x x x x

        assertTrue(moveEngine.isMovePossible(new Point(5, 3)));
        assertTrue(moveEngine.isMovePossible(new Point(3, 5)));
        assertTrue(moveEngine.isMovePossible(new Point(5, 7)));
        assertTrue(moveEngine.isMovePossible(new Point(7, 5)));
        assertTrue(moveEngine.isMovePossible(new Point(11, 5)));
        assertTrue(moveEngine.isMovePossible(new Point(0, 5)));
        assertTrue(moveEngine.isMovePossible(new Point(5, 11)));

        assertFalse(moveEngine.isMovePossible(new Point(5, 2)));
        assertFalse(moveEngine.isMovePossible(new Point(4, 4)));
        assertFalse(moveEngine.isMovePossible(new Point(4, 5)));
        assertFalse(moveEngine.isMovePossible(new Point(4, 6)));
        assertFalse(moveEngine.isMovePossible(new Point(5, 2)));
        assertFalse(moveEngine.isMovePossible(new Point(5, 4)));
        assertFalse(moveEngine.isMovePossible(new Point(5, 6)));
        assertFalse(moveEngine.isMovePossible(new Point(5, 11)));
        assertFalse(moveEngine.isMovePossible(new Point(6, 4)));
        assertFalse(moveEngine.isMovePossible(new Point(6, 5)));
        assertFalse(moveEngine.isMovePossible(new Point(6, 6)));
        assertFalse(moveEngine.isMovePossible(new Point(5, 8)));
    }
}
