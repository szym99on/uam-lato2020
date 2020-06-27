package pl.psi.game.move;

import org.junit.jupiter.api.Test;
import pl.psi.game.Board;
import pl.psi.game.fractions.Creature;

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
        board.putCreature(1,1, c);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(1,1),c);

        assertTrue(moveEngine.isMovePossible(new Point(1,2)));
        assertTrue(moveEngine.isMovePossible(new Point(1,0)));
        assertTrue(moveEngine.isMovePossible(new Point(0,1)));
        assertTrue(moveEngine.isMovePossible(new Point(2,1)));
    }

    @Test
    void moveRangeTooSmall(){
        Creature c = Creature.builder().aMoveRange(1).aCanFly(true).build();
        Board board = Board.getBoard();
        board.clearBoard();
        board.putCreature(1,1, c);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(1,1),c);

        assertFalse(moveEngine.isMovePossible(new Point(1,3)));
        assertFalse(moveEngine.isMovePossible(new Point(3,1)));
        assertFalse(moveEngine.isMovePossible(new Point(-1,1)));
        assertFalse(moveEngine.isMovePossible(new Point(-1,1)));
    }

    @Test
    void moveCreature(){
        Creature c = Creature.builder().aMoveRange(1).aCanFly(true).build();
        Board board = Board.getBoard();
        board.clearBoard();
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
        board.putCreature(2,2, creature);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(2,2), creature);

        moveEngine.move(5,4);
        assertEquals(creature, board.getCreature(5,4));
        assertNull(board.getCreature(2,2));

    }


    @Test
    void flyFrom5_4To1_2(){
        Creature creature = Creature.builder().aMoveRange(99).aCanFly(true).build();

        Board board = Board.getBoard();
        board.clearBoard();
        //Board.getBoard();
        board.putCreature(5,4, creature);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(5,4), creature);

        moveEngine.move(1,2);
        assertEquals(creature, board.getCreature(1,2));
        assertNull(board.getCreature(5,4));
    }


    @Test
    void isMovePossibleTrueFlyingCreature(){
        Creature creature = Creature.builder().aMoveRange(5).aCanFly(true).build();

        Board board = Board.getBoard();
        board.clearBoard();
        board.putCreature(2,2, creature);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(2,2), creature);

        Point finalPoint = new Point(5,4);

        MoveStrategyIf moveStrategyIf = new FlyMoveStrategy(board,moveEngine.getActiveCreature());

        boolean bool = moveStrategyIf.isMovePossible(finalPoint);
        assertTrue(bool);

    }

    @Test
    void isMovePossibleTrueWalkingCreature(){
        Board board = Board.getBoard();
        board.clearBoard();
        Creature creature = Creature.builder().aCanFly(false).aMoveRange(2).build();
        board.putCreature(5,5, creature);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(board.getCreatureLocation(creature).get(),creature);
//              3  4  5  6  7
//    3    //   x  x  o  x  x
//    4    //   x  o  o  o  x
//    5    //   o  o  c  o  o
//    6    //   x  o  o  o  x
//    7    //   x  x  o  x  x

        assertTrue(moveEngine.isMovePossible(new Point(5,6)));
        assertTrue(moveEngine.isMovePossible(new Point(5,4)));
        assertTrue(moveEngine.isMovePossible(new Point(4,5)));
        assertTrue(moveEngine.isMovePossible(new Point(6,5)));

        assertTrue(moveEngine.isMovePossible(new Point(6,6)));
        assertTrue(moveEngine.isMovePossible(new Point(4,4)));
        assertTrue(moveEngine.isMovePossible(new Point(6,4)));
        assertTrue(moveEngine.isMovePossible(new Point(4,6)));

        assertTrue(moveEngine.isMovePossible(new Point(5,7)));
        assertTrue(moveEngine.isMovePossible(new Point(5,3)));
        assertTrue(moveEngine.isMovePossible(new Point(3,5)));
        assertTrue(moveEngine.isMovePossible(new Point(7,5)));
    }

    @Test
    void walkingMoveTest(){
        Creature creature = Creature.builder().aMoveRange(5).aCanFly(false).build();

        Board board = Board.getBoard();
        board.clearBoard();
        board.putCreature(1,1, creature);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(3,3), creature);

        //when
        moveEngine.move(3,3);
        //then
        assertEquals(creature, board.getCreature(3,3));
        assertNull(board.getCreature(1,1));
}

    @Test
    void walkingMoveCanAvoidObstacle(){
//
//        Creature creature = Creature.builder().build();
//        Board board = Board.getBoard();
//        board.clearBoard();
//        MoveEngine moveEngine = new MoveEngine(board);
//        moveEngine.setActiveCreature(new Point(1,1), creature);
//
//        WalkMoveStrategy moveStrategyIf = new WalkMoveStrategy(board,moveEngine.getActiveCreature());
//
//
//        List <Point> paths = new LinkedList<>();
//        paths.add(new Point(1,1));
//        ObstacleFactory obstacleFactory = new ObstacleFactory();
//        Obstacle lava1 = obstacleFactory.createObstacle("lava", new Point(1, 2));
//        Obstacle lava2 =  obstacleFactory.createObstacle("lava", new Point(2,1));
//
//        board.putObstacle(lava1);
//        board.putObstacle(lava2);
//
//        List list = moveStrategyIf.countPath(new Point(1, 1), new Point(2, 3),paths);
//        List expected = new LinkedList();
//        expected.add(new Point(1,1));
//        expected.add(new Point(0,1));
//        expected.add(new Point(0,2));
//        expected.add(new Point(0,3));
//        expected.add(new Point(1,3));
//        expected.add(new Point(2,3));
//
//        assertEquals(expected,list);

    }


    @Test
    void walkingMoveWithOnlyPossibleWayThroughRock(){
/*
        //In this case creature is surrounded  by lava and can move only form 5,5 to 5,6
        Creature creature = Creature.builder().build();
        Board board = Board.getBoard();
        board.clearBoard();
        board.putCreature(5,5, creature);
        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(5,5), creature);

        ObstacleFactory obstacleFactory = new ObstacleFactory();
        ImpactMoveObstacle lava1 = obstacleFactory.createImpactMoveObstacle("rock", new Point(5, 7));
        ImpactMoveObstacle lava2 =  obstacleFactory.createImpactMoveObstacle("rock", new Point(4,6));
        ImpactMoveObstacle lava3 =  obstacleFactory.createImpactMoveObstacle("rock", new Point(4,5));
        ImpactMoveObstacle lava4 =  obstacleFactory.createImpactMoveObstacle("rock", new Point(6,6));
        ImpactMoveObstacle lava5 =  obstacleFactory.createImpactMoveObstacle("rock", new Point(6,5));
        ImpactMoveObstacle lava6 =  obstacleFactory.createImpactMoveObstacle("rock", new Point(5,4));

        board.putObstacle(lava1);
        board.putObstacle(lava2);
        board.putObstacle(lava3);
        board.putObstacle(lava4);
        board.putObstacle(lava5);
        board.putObstacle(lava6);

        moveEngine.move(5,3);

        assertEquals(creature, board.getCreature(5,4));
        assertNull(board.getCreature(5,5));
*/
    }

    @Test
    void walkingMoveWithNoPossibleWayIsMovePossibleLavaTest(){
//
//        //In this case creature is surrounded  by lava and can move only form 5,5 to 5,6
//        Creature creature = Creature.builder().aMoveRange(99).build();
//        Board board = Board.getBoard();
//        board.clearBoard();
//        MoveEngine moveEngine = new MoveEngine(board);
//        moveEngine.setActiveCreature(new Point(5,5), creature);
//
//        WalkMoveStrategy moveStrategyIf = new WalkMoveStrategy(board,moveEngine.getActiveCreature());
//        List <Point> paths = new LinkedList<>();
//        paths.add(new Point(1,1));
//        ObstacleFactory obstacleFactory = new ObstacleFactory();
//        Obstacle lava1 = obstacleFactory.createObstacle("lava", new Point(5,7));
//        Obstacle lava2 =  obstacleFactory.createObstacle("lava", new Point(4,6));
//        Obstacle lava3 = obstacleFactory.createObstacle("lava", new Point(4,5));
//        Obstacle lava4 =  obstacleFactory.createObstacle("lava", new Point(6,6));
//        Obstacle lava5 = obstacleFactory.createObstacle("lava", new Point(6,5));
//        Obstacle lava6 =  obstacleFactory.createObstacle("lava", new Point(5,4));
//
//
//        board.putObstacle(lava1);
//        board.putObstacle(lava2);
//        board.putObstacle(lava3);
//        board.putObstacle(lava4);
//        board.putObstacle(lava5);
//        board.putObstacle(lava6);
//
//
//        assertTrue(moveStrategyIf.isMovePossible(new Point(5,5),new Point(9,9)));
//
    }
}

