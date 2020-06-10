package pl.psi.game.move;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.Board;
import pl.psi.game.fractions.Creature;
import pl.psi.game.move.MoveEngine;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoveEngineTest {

    @Test
    void moveShouldBePossible(){
        Creature c = Creature.builder().aMoveRange(1).build();
        Board board = Board.getBoard();
        board.clearBoard();
        Board.getBoard();
        board.putCreature(1,1, c);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(1,1),c);

        Point startPoint = new Point(1,1);
        assertTrue(moveEngine.isMovePossible(startPoint,new Point(1,2)));
        assertTrue(moveEngine.isMovePossible(startPoint,new Point(1,0)));
        assertTrue(moveEngine.isMovePossible(startPoint,new Point(0,1)));
        assertTrue(moveEngine.isMovePossible(startPoint,new Point(2,1)));
    }

    @Test
    void moveRangeTooSmall(){
        Creature c = Creature.builder().aMoveRange(1).build();
        Board board = Board.getBoard();
        board.clearBoard();
        Board.getBoard();
        board.putCreature(1,1, c);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(1,1),c);

        Point startPoint = new Point(1,1);
        assertFalse(moveEngine.isMovePossible(startPoint,new Point(1,3)));
        assertFalse(moveEngine.isMovePossible(startPoint,new Point(3,1)));
    }




    @Test
    @Disabled
    void moveCreature(){
        Creature c = Creature.builder().aMoveRange(1).aCanFly(true).build();
        Board board = Board.getBoard();
        board.clearBoard();
        Board.getBoard();
        board.putCreature(1,1, c);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(1,1), c);
        moveEngine.move(1,2);

        assertEquals(c, board.getCreature(1,2));
        assertNull(board.getCreature(1,1));
    }


    @Test
    void flyFrom2_2To5_4(){
        Creature creature = Creature.builder().aMoveRange(99).aCanFly(true).build();

        Board board = Board.getBoard();
        board.clearBoard();
        Board.getBoard();
        board.putCreature(2,2, creature);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(2,2), creature);


        Point finalPoint = new Point(5,4);

        MoveStrategyIf moveStrategyIf = new FlyMoveStrategy(board,moveEngine.getActiveCreature());

        List<GuiTileIf> path = moveStrategyIf.getSteps(finalPoint);
        //PATH
        assertEquals(path.get(0).getPoint(),new Point(3,2));
        assertEquals(path.get(1).getPoint(),new Point(3,3));
        assertEquals(path.get(2).getPoint(),new Point(4,3));
        assertEquals(path.get(3).getPoint(),new Point(4,4));
        assertEquals(path.get(4).getPoint(),new Point(5,4));

    }


    @Test
    void flyFrom5_4To1_2(){
        Creature creature = Creature.builder().aMoveRange(99).aCanFly(true).build();

        Board board = Board.getBoard();
        board.clearBoard();
        Board.getBoard();
        board.putCreature(5,4, creature);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(5,4), creature);


        Point finalPoint = new Point(1,2);

        MoveStrategyIf moveStrategyIf = new FlyMoveStrategy(board,moveEngine.getActiveCreature());

        List<GuiTileIf> path = moveStrategyIf.getSteps(finalPoint);
        //PATH
        assertEquals(path.get(0).getPoint(),new Point(4,4));
        assertEquals(path.get(1).getPoint(),new Point(4,3));
        assertEquals(path.get(2).getPoint(),new Point(3,3));
        assertEquals(path.get(3).getPoint(),new Point(3,2));
        assertEquals(path.get(4).getPoint(),new Point(2,2));
        assertEquals(path.get(5).getPoint(),new Point(1,2));

    }


    @Test
    void isMovePossibleTrueFlyingCreature(){
        Creature creature = Creature.builder().aMoveRange(99).aCanFly(true).build();

        Board board = Board.getBoard();
        board.clearBoard();
        Board.getBoard();
        board.putCreature(2,2, creature);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(2,2), creature);

        Point finalPoint = new Point(5,4);

        MoveStrategyIf moveStrategyIf = new FlyMoveStrategy(board,moveEngine.getActiveCreature());

        boolean bool = moveStrategyIf.isMovePossible(board, new Point(2, 2), finalPoint);
        assertTrue(bool);

    }

    @Test
    void walkingCreatureShouldCanMove(){
        Board board = Board.getBoard();
        Creature creature = Creature.builder().aMoveRange(2).build();
        board.putCreature(8,4, creature);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(board.getCreatureLocation(creature).get(),creature);

        assertTrue(moveEngine.isMovePossible(moveEngine.getActiveCreature().getKey(),new Point(8,5)));
        assertFalse(moveEngine.isMovePossible(moveEngine.getActiveCreature().getKey(),new Point(8,7)));
        assertTrue(moveEngine.isMovePossible(moveEngine.getActiveCreature().getKey(),new Point(7,4)));
        assertFalse(moveEngine.isMovePossible(moveEngine.getActiveCreature().getKey(),new Point(6,4)));

    }



}

