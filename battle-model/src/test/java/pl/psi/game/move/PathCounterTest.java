package pl.psi.game.move;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.psi.game.Board;
import pl.psi.game.fractions.Creature;

import java.awt.*;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class PathCounterTest {
    PathCounter pathCounterFly = new PathCounter("fly");
    PathCounter pathCounterWalk = new PathCounter("walk");


    @Test
    void walkPathFrom1_1To1_5(){
        Creature c = Creature.builder().aMoveRange(4).build();
        Board board = Board.getBoard();
        board.clearBoard();
        board.putCreature(1,1, c);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(1,1),c);
        List<Point> path = new LinkedList<>();
        path.add(new Point(1,1));

        path = pathCounterWalk.countPath(new Point(1, 1), new Point(1, 5), path);

        assertTrue(path.contains(new Point(1,2)));
        assertTrue(path.contains(new Point(1,3)));
        assertTrue(path.contains(new Point(1,4)));
        assertTrue(path.contains(new Point(1,5)));
    }

    @Test
    void walkPathFrom1_1To5_5(){
        Creature c = Creature.builder().aMoveRange(4).build();
        Board board = Board.getBoard();
        board.clearBoard();
        board.putCreature(1,1, c);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(1,1),c);

        List<Point> path = new LinkedList<>();
        path.add(new Point(1,1));

        path = pathCounterWalk.countPath(new Point(1, 1), new Point(5, 5), path);

        assertTrue(path.contains(new Point(1,2)));
        assertTrue(path.contains(new Point(2,2)));
        assertTrue(path.contains(new Point(2,3)));
        assertTrue(path.contains(new Point(3,3)));
        assertTrue(path.contains(new Point(3,4)));
        assertTrue(path.contains(new Point(4,4)));
        assertTrue(path.contains(new Point(4,5)));
        assertTrue(path.contains(new Point(5,5)));
    }

    @Test
    void flyPathFrom1_1To1_5(){
        Creature c = Creature.builder().aMoveRange(4).build();
        Board board = Board.getBoard();
        board.clearBoard();
        board.putCreature(1,1, c);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(1,1),c);

        List<Point> path = new LinkedList<>();
        path.add(new Point(1,1));

        path = pathCounterFly.countPath(new Point(1, 1), new Point(1, 5), path);

        assertTrue(path.contains(new Point(1,2)));
        assertTrue(path.contains(new Point(1,3)));
        assertTrue(path.contains(new Point(1,4)));
        assertTrue(path.contains(new Point(1,5)));
    }

    @Test
    void flyPathFrom1_1To5_5(){
        Creature c = Creature.builder().aMoveRange(4).build();
        Board board = Board.getBoard();
        board.clearBoard();
        board.putCreature(1,1, c);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(1,1),c);

        List<Point> path = new LinkedList<>();
        path.add(new Point(1,1));

        path = pathCounterFly.countPath(new Point(1, 1), new Point(5, 5), path);

        assertTrue(path.contains(new Point(1,2)));
        assertTrue(path.contains(new Point(2,2)));
        assertTrue(path.contains(new Point(2,3)));
        assertTrue(path.contains(new Point(3,3)));
        assertTrue(path.contains(new Point(3,4)));
        assertTrue(path.contains(new Point(4,4)));
        assertTrue(path.contains(new Point(4,5)));
        assertTrue(path.contains(new Point(5,5)));
    }

    @Test
    void findMinValue1(){
        double x = pathCounterWalk.findMinValue(1,1,1,1);
        assertEquals(1,x);
    }

    @Test
    void findMinValue2(){
        double x = pathCounterWalk.findMinValue(1,2,3,4);
        assertEquals(1,x);
    }

    @Test
    void findMinValue3(){
        double x = pathCounterWalk.findMinValue(2,1,3,4);
        assertEquals(1,x);
    }

    @Test
    void findMinValue4(){
        double x = pathCounterWalk.findMinValue(2,3,1,4);
        assertEquals(1,x);
    }

    @Test
    void findMinValue5(){
        double x = pathCounterWalk.findMinValue(2,3,4,1);
        assertEquals(1,x);
    }

    @Test
    void findMinValue6(){
        double x = pathCounterWalk.findMinValue(1,1,2,2);
        assertEquals(1,x);
    }

    @Test
    void findMinValue7(){
        double x = pathCounterWalk.findMinValue(1,1,1,2);
        assertEquals(1,x);
    }
}
