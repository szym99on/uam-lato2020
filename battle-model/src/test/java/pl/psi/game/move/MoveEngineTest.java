package pl.psi.game.move;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.Board;
import pl.psi.game.fractions.Creature;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoveEngineTest {

    @Test
    @Disabled
    // to juz jest sprawdzane w testach od EndingMoveObstacle :D
    void moveshouldBeNotPossible(){

        ObstacleFactory obstacleFactory = new ObstacleFactory();

        //    0 1 2 3 4 5
        //  0 x R x x x x
        //  1 R C R x x x
        //  2 x R x x x x
        //  3 x x x x x x
        //  4 x x x x x x

        EndingMoveObstacle e1 = (EndingMoveObstacle) obstacleFactory.createImpactMoveObstacle("rock", new Point(1,2));
        EndingMoveObstacle e2 = (EndingMoveObstacle) obstacleFactory.createImpactMoveObstacle("rock", new Point(1,0));
        EndingMoveObstacle e3 = (EndingMoveObstacle) obstacleFactory.createImpactMoveObstacle("rock", new Point(0,1));
        EndingMoveObstacle e4 = (EndingMoveObstacle) obstacleFactory.createImpactMoveObstacle("rock", new Point(2,1));


        Creature c = Creature.builder().aMoveRange(1).build();
        Board board = Board.getBoard();
        board.clearBoard();
        board.putCreature(1,1, c);
        board.putObstacle(e1);
        board.putObstacle(e2);
        board.putObstacle(e3);
        board.putObstacle(e4);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(1,1),c);

        moveEngine.move(1,3);
        assertEquals(c, board.getCreature(1,1));
        assertNull(board.getCreature(1,3));

    }

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

        List<Point> path = moveEngine.getMovePath(new Point(5, 4));

        assertTrue(path.contains(new Point(3,2)));
        assertTrue(path.contains(new Point(3,3)));
        assertTrue(path.contains(new Point(4,3)));
        assertTrue(path.contains(new Point(4,4)));
        assertTrue(path.contains(new Point(5,4)));

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

        List<Point> path = moveEngine.getMovePath(new Point(1, 2));

        assertTrue(path.contains(new Point(4,4)));
        assertTrue(path.contains(new Point(3,4)));
        assertTrue(path.contains(new Point(3,3)));
        assertTrue(path.contains(new Point(2,3)));
        assertTrue(path.contains(new Point(2,2)));
        assertTrue(path.contains(new Point(1,2)));

        moveEngine.move(1,2);
        assertEquals(creature, board.getCreature(1,2));
        assertNull(board.getCreature(5,4));
    }

    @Test
    void walkFrom2_2To5_4(){
        Creature creature = Creature.builder().aMoveRange(99).aCanFly(false).build();

        Board board = Board.getBoard();
        board.clearBoard();
        board.putCreature(2,2, creature);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(2,2), creature);

        List<Point> path = moveEngine.getMovePath(new Point(5, 4));

        assertTrue(path.contains(new Point(3,2)));
        assertTrue(path.contains(new Point(3,3)));
        assertTrue(path.contains(new Point(4,3)));
        assertTrue(path.contains(new Point(4,4)));
        assertTrue(path.contains(new Point(5,4)));


        moveEngine.move(5,4);
        assertEquals(creature, board.getCreature(5,4));
        assertNull(board.getCreature(2,2));

    }


    @Test
    void walkFrom5_4To1_2(){
        Creature creature = Creature.builder().aMoveRange(99).aCanFly(false).build();

        Board board = Board.getBoard();
        board.clearBoard();
        //Board.getBoard();
        board.putCreature(5,4, creature);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(5,4), creature);


        List<Point> path = moveEngine.getMovePath(new Point(1, 2));

        assertTrue(path.contains(new Point(4,4)));
        assertTrue(path.contains(new Point(3,4)));
        assertTrue(path.contains(new Point(3,3)));
        assertTrue(path.contains(new Point(2,3)));
        assertTrue(path.contains(new Point(2,2)));
        assertTrue(path.contains(new Point(1,2)));


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
        moveEngine.setActiveCreature(new Point(1,1), creature);

        //when
        moveEngine.move(3,3);
        //then
        assertEquals(creature, board.getCreature(3,3));
        assertNull(board.getCreature(1,1));
}

    @Test
    void getWalkPath(){
        Creature creature = Creature.builder().aMoveRange(6).aCanFly(false).build();

        Board board = Board.getBoard();
        board.clearBoard();
        board.putCreature(1,1, creature);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(1,1), creature);

        List<Point> path = moveEngine.getMovePath(new Point(3, 3));

        assertTrue(path.contains(new Point(1,2)));
        assertTrue(path.contains(new Point(2,2)));
        assertTrue(path.contains(new Point(2,3)));
        assertTrue(path.contains(new Point(2,3)));

    }

    @Test
    void getFlyPath(){
        Creature creature = Creature.builder().aMoveRange(6).aCanFly(true).build();

        Board board = Board.getBoard();
        board.clearBoard();
        board.putCreature(1,1, creature);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(1,1), creature);

        List<Point> path = moveEngine.getMovePath(new Point(3, 3));

        assertTrue(path.contains(new Point(1,2)));
        assertTrue(path.contains(new Point(2,2)));
        assertTrue(path.contains(new Point(2,3)));
        assertTrue(path.contains(new Point(2,3)));

    }

    @Test
    void walkingMoveCanAvoidObstacle(){
        Creature creature = Creature.builder().aMoveRange(6).aCanFly(false).build();
        ObstacleFactory obstacleFactory = new ObstacleFactory();

        EndingMoveObstacle e1 = (EndingMoveObstacle) obstacleFactory.createImpactMoveObstacle("rock", new Point(1,3));

        Board board = Board.getBoard();
        board.clearBoard();
        board.putCreature(1,1, creature);
        board.putObstacle(e1);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(1,1), creature);

        List<Point> path = moveEngine.getMovePath(new Point(1, 4));

        assertTrue(path.contains(new Point(1,2)));
        assertTrue(path.contains(new Point(0,2)));
        assertTrue(path.contains(new Point(0,3)));
        assertTrue(path.contains(new Point(0,4)));
        assertTrue(path.contains(new Point(1,4)));
    }

    @Test
    void walkingMoveCanAvoidObstacle2(){
        // C - creature, R - Rock (Is not possible to walk through this), E - Creature want move to this point
        //    0 1 2 3 4
        //  0 C x x x x
        //  1 x R x x x
        //  2 x R x x x
        //  3 R x x x x
        //  4 E x x x x

        Creature creature = Creature.builder().aMoveRange(99).aCanFly(false).build();
        ObstacleFactory obstacleFactory = new ObstacleFactory();

        EndingMoveObstacle e2 = (EndingMoveObstacle) obstacleFactory.createImpactMoveObstacle("rock", new Point(1,1));
        EndingMoveObstacle e3 = (EndingMoveObstacle) obstacleFactory.createImpactMoveObstacle("rock", new Point(1,2));
        EndingMoveObstacle e4 = (EndingMoveObstacle) obstacleFactory.createImpactMoveObstacle("rock", new Point(0,3));

        Board board = Board.getBoard();
        board.clearBoard();
        board.putCreature(0,0, creature);
        board.putObstacle(e2);
        board.putObstacle(e3);
        board.putObstacle(e4);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(0,0), creature);

        List<Point> path = moveEngine.getMovePath(new Point(0, 4));

        assertTrue(path.contains(new Point(1,0)));
        assertTrue(path.contains(new Point(2,0)));
        assertTrue(path.contains(new Point(2,1)));
        assertTrue(path.contains(new Point(2,2)));
        assertTrue(path.contains(new Point(2,3)));
        assertTrue(path.contains(new Point(1,3)));
        assertTrue(path.contains(new Point(1,4)));
        assertTrue(path.contains(new Point(0,4)));
    }

    @Test
    void walkingMoveHaventPossiblePathsAndCanMove(){

        // C - creature, R - Rock (Is not possible to walk through this), E - Creature want move to this point
        //    0 1 2 3 4
        //  0 C x R x x
        //  1 x R x x x
        //  2 x R x x x
        //  3 R x x x x
        //  4 E x x x x

        Creature creature = Creature.builder().aMoveRange(8).aCanFly(false).build();
        ObstacleFactory obstacleFactory = new ObstacleFactory();

        EndingMoveObstacle e1 = (EndingMoveObstacle) obstacleFactory.createImpactMoveObstacle("rock", new Point(0,2));
        EndingMoveObstacle e2 = (EndingMoveObstacle) obstacleFactory.createImpactMoveObstacle("rock", new Point(1,1));
        EndingMoveObstacle e3 = (EndingMoveObstacle) obstacleFactory.createImpactMoveObstacle("rock", new Point(2,1));
        EndingMoveObstacle e4 = (EndingMoveObstacle) obstacleFactory.createImpactMoveObstacle("rock", new Point(1,3));

        Board board = Board.getBoard();
        board.clearBoard();
        board.putCreature(0,0, creature);
        board.putObstacle(e1);
        board.putObstacle(e2);
        board.putObstacle(e3);
        board.putObstacle(e4);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(0,0), creature);


        assertFalse(moveEngine.isMovePossible(new Point(0, 4)));
    }

    @Test
    void walkingMoveHaventPossiblePathsAndCanNotMove(){
        // C - creature, R - Rock (Is not possible to walk through this), E - Creature want move to this point
        //    0 1 2 3 4
        //  0 C R x x x
        //  1 R x x x x
        //  2 x x x x x
        //  3 x x x x x
        //  4 E x x x x


        Creature creature = Creature.builder().aMoveRange(8).aCanFly(false).build();
        ObstacleFactory obstacleFactory = new ObstacleFactory();

        EndingMoveObstacle e1 = (EndingMoveObstacle) obstacleFactory.createImpactMoveObstacle("rock", new Point(0,1));
        EndingMoveObstacle e2 = (EndingMoveObstacle) obstacleFactory.createImpactMoveObstacle("rock", new Point(1,0));
//        EndingMoveObstacle e3 = (EndingMoveObstacle) obstacleFactory.createImpactMoveObstacle("rock", new Point(1,0));
///        EndingMoveObstacle e4 = (EndingMoveObstacle) obstacleFactory.createImpactMoveObstacle("rock", new Point(1,3));

        Board board = Board.getBoard();
        board.clearBoard();
        board.putCreature(0,0, creature);
        board.putObstacle(e1);
        board.putObstacle(e2);
//        board.putObstacle(e3);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(0,0), creature);

        assertFalse(moveEngine.isMovePossible(new Point(0, 4)));
    }


}

