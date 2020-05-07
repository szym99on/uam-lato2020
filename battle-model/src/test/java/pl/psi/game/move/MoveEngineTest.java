package pl.psi.game.move;

import org.junit.jupiter.api.Test;
import pl.psi.game.Board;
import pl.psi.game.fractions.Creature;
import pl.psi.game.move.MoveEngine;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MoveEngineTest {

    @Test
    void moveShouldBePossible(){
        Creature c = Creature.builder().aMoveRange(1).build();
        Board board = new Board();
        board.putCreature(1,1, c);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(1,1),c);

        assertTrue(moveEngine.isMovePossible(1,2));
        assertTrue(moveEngine.isMovePossible(2,1));
        assertTrue(moveEngine.isMovePossible(0,1));
        assertTrue(moveEngine.isMovePossible(1,0));
    }

    @Test
    void moveCreature(){
        Creature c = Creature.builder().aMoveRange(1).build();
        Board board = new Board();
        board.putCreature(1,1, c);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(1,1), c);
        moveEngine.move(1,2);

        assertEquals(c, board.getCreature(1,2));
        assertNull(board.getCreature(1,1));
    }

    @Test
    void isAnythingOnWayWalk(){

        Creature c1 = Creature.builder().type(walking).aMoveRange(5).build();
        Creature c2 = Creature.build();

        Board board = new Board();
        board.putCreature(1,1, c1);
        board.putCreature(1, 3, c2);
        board.putSmth(3, 1);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(1,1), c1);

        assertFalse(moveEngine.isMovePossible(1, 5));
        assertFalse(moveEngine.isMovePossible(5,1));

    }

    @Test
    void isAnythingOnWayFly(){

        Creature c1 = Creature.builder().type(fly).aMoveRange(5).build();
        Creature c2 = Creature.build();

        Board board = new Board();
        board.putCreature(1,1, c1);
        board.putCreature(1, 3, c2);
        board.putSmth(3, 1);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(1,1), c1);

        assertTrue(moveEngine.isMovePossible(1, 5));
        assertTrue(moveEngine.isMovePossible(5,1));

    }

    @Test
    void hurtingFieldWalk(){

        Creature c = Creature.builder().type(walking).aMoveRange(5).build();

        Board board = new Board();
        board.putCreature(1,1, c);
        board.putLava(1, 2);

        int hp = c.getCurrentHp();

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(1,1), c);
        moveEngine.move(1,3);

        assertFalse(hp == c.getCurrentHp());

    }

    @Test
    void hurtingFieldFly(){

        Creature c = Creature.builder().type(fly).aMoveRange(5).build();

        Board board = new Board();
        board.putCreature(1,1, c);
        board.putLava(1, 2);

        int hp = c.getCurrentHp();

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(1,1), c);
        moveEngine.move(1,3);

        assertTrue(hp == c.getCurrentHp());

    }




}