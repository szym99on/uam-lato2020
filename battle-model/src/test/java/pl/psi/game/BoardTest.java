package pl.psi.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.Creature;
import pl.psi.game.move.ObstacleFactory;
import pl.psi.game.move.ObstacleIf;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void shouldClearBoard(){
        Board board = Board.getBoard();

        Creature c1 = Creature.builder().aName("C1").build();
        Creature c2 = Creature.builder().aName("C2").build();

        board.putCreature(1,2, c1);
        board.putCreature(2,2, c2);

        assertEquals(c1,board.getCreature(1,2));
        assertEquals(c2,board.getCreature(2,2));
        board.clearBoard();
    }

    @Test
    void putCreatureToBoard(){
        Board board = Board.getBoard();

        Creature c1 = Creature.builder().aName("C1").build();
        Creature c2 = Creature.builder().aName("C2").build();

        board.putCreature(1,2, c1);
        board.putCreature(2,2, c2);

        board.clearBoard();
        assertEquals(null, board.getCreature(1,2));
        assertEquals(null, board.getCreature(2,2));
    }

    @Test
    void shouldReturnCorrectCreatureLocation(){
        Board board = Board.getBoard();

        Creature c1 = Creature.builder().aName("C1").build();

        board.putCreature(1,1, c1);
        assertEquals(new Point(1,1),board.getCreatureLocation(c1).get());
        board.clearBoard();
    }

    @Test
    void shouldThrowExceptionWhileYouTryAddCreatureOutsideTheMap(){
        Board board = Board.getBoard();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            board.putCreature(1,100, Creature.builder().aName("C1").build());
        });
        board.clearBoard();
    }

    @Test
    void putObstacleTest(){
        Board board = Board.getBoard();
        ObstacleFactory obstacleFactory = new ObstacleFactory();

        ObstacleIf marsh =  obstacleFactory.createImpactMoveObstacle("marsh", new Point(1,1));
        ObstacleIf rock = obstacleFactory.createImpactMoveObstacle("rock", new Point(1,2));
        ObstacleIf lava = obstacleFactory.createImpactCreatureObstacle("lava", new Point(1,3));

        board.putObstacle(marsh);
        board.putObstacle(rock);
        board.putObstacle(lava);

        assertTrue(marsh.equals(board.getObstacle(1, 1)));
        assertTrue(rock.equals(board.getObstacle(1, 2)));
        assertTrue(lava.equals(board.getObstacle(1, 3)));
        board.clearBoard();
    }
}