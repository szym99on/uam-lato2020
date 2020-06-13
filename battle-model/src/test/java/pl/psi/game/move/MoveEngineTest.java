package pl.psi.game.move;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.Board;
import pl.psi.game.fractions.Creature;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalDouble;

import static org.junit.jupiter.api.Assertions.*;

class MoveEngineTest {


    @Test
    void walkingMoveTest(){

        Creature creature = Creature.builder().build();
        Board board = Board.getBoard();
        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(1,1), creature);

        WalkMoveStrategy moveStrategyIf = new WalkMoveStrategy(board,moveEngine.getActiveCreature());
        List <Point> paths = new LinkedList<>();
        paths.add(new Point(1,1));

        List list = moveStrategyIf.countPath(new Point(1, 1), new Point(2, 3),paths);
        List expected = new LinkedList();
        expected.add(new Point(1,1));
        expected.add(new Point(1,2));
        expected.add(new Point(1,3));
        expected.add(new Point(2,3));
        assertEquals(expected,list);
    }



    @Test
    void walkingMoveWithSomeObstacleOnBestPathTest(){

        Creature creature = Creature.builder().build();
        Board board = Board.getBoard();
        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(1,1), creature);

        WalkMoveStrategy moveStrategyIf = new WalkMoveStrategy(board,moveEngine.getActiveCreature());
        List <Point> paths = new LinkedList<>();
        paths.add(new Point(1,1));
        ObstacleFactory obstacleFactory = new ObstacleFactory();
        Obstacle lava1 = obstacleFactory.createObstacle("lava", new Point(1, 2));
        Obstacle lava2 =  obstacleFactory.createObstacle("lava", new Point(2,1));

        board.putObstacle(lava1);
        board.putObstacle(lava2);

        List list = moveStrategyIf.countPath(new Point(1, 1), new Point(2, 3),paths);
        List expected = new LinkedList();
        expected.add(new Point(1,1));
        expected.add(new Point(0,1));
        expected.add(new Point(0,2));
        expected.add(new Point(0,3));
        expected.add(new Point(1,3));
        expected.add(new Point(2,3));

        assertEquals(expected,list);

    }


    @Test
    void walkingMoveWithOnlyPossibleWayThroughLava(){

        //In this case creature is surrounded  by lava and can move only form 5,5 to 5,6
        Creature creature = Creature.builder().build();
        Board board = Board.getBoard();
        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(5,5), creature);

        WalkMoveStrategy moveStrategyIf = new WalkMoveStrategy(board,moveEngine.getActiveCreature());
        List <Point> paths = new LinkedList<>();
        paths.add(new Point(5,5));
        ObstacleFactory obstacleFactory = new ObstacleFactory();
        Obstacle lava1 = obstacleFactory.createObstacle("lava", new Point(5,7));
        Obstacle lava2 =  obstacleFactory.createObstacle("lava", new Point(4,6));
        Obstacle lava3 = obstacleFactory.createObstacle("lava", new Point(4,5));
        Obstacle lava4 =  obstacleFactory.createObstacle("lava", new Point(6,6));
        Obstacle lava5 = obstacleFactory.createObstacle("lava", new Point(6,5));
        Obstacle lava6 =  obstacleFactory.createObstacle("lava", new Point(5,4));


        board.putObstacle(lava1);
        board.putObstacle(lava2);
        board.putObstacle(lava3);
        board.putObstacle(lava4);
        board.putObstacle(lava5);
        board.putObstacle(lava6);


        List list = moveStrategyIf.countPath(new Point(5, 5), new Point(5, 9),paths);
        List expected = new LinkedList();
            expected.add(new Point(5,5));
            expected.add(new Point(5,6));
            expected.add(new Point(5,7));
            expected.add(new Point(5,8));
            expected.add(new Point(5,9));


            assertEquals(expected,list);

    }


    @Test
    void walkingMoveWithNoPossibleWayIsMovePossibleLavaTest(){

        //In this case creature is surrounded  by lava and can move only form 5,5 to 5,6
        Creature creature = Creature.builder().aMoveRange(99).build();
        Board board = Board.getBoard();
        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(new Point(5,5), creature);

        WalkMoveStrategy moveStrategyIf = new WalkMoveStrategy(board,moveEngine.getActiveCreature());
        List <Point> paths = new LinkedList<>();
        paths.add(new Point(1,1));
        ObstacleFactory obstacleFactory = new ObstacleFactory();
        Obstacle lava1 = obstacleFactory.createObstacle("lava", new Point(5,7));
        Obstacle lava2 =  obstacleFactory.createObstacle("lava", new Point(4,6));
        Obstacle lava3 = obstacleFactory.createObstacle("lava", new Point(4,5));
        Obstacle lava4 =  obstacleFactory.createObstacle("lava", new Point(6,6));
        Obstacle lava5 = obstacleFactory.createObstacle("lava", new Point(6,5));
        Obstacle lava6 =  obstacleFactory.createObstacle("lava", new Point(5,4));

        board.clearBoard();

        board.putObstacle(lava1);
        board.putObstacle(lava2);
        board.putObstacle(lava3);
        board.putObstacle(lava4);
        board.putObstacle(lava5);
        board.putObstacle(lava6);


        assertTrue(moveStrategyIf.isMovePossible(new Point(5,5),new Point(9,9)));

    }


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
        assertTrue(moveEngine.isMovePossible(new Point(1,2)));
        assertTrue(moveEngine.isMovePossible(new Point(1,0)));
        assertTrue(moveEngine.isMovePossible(new Point(0,1)));
        assertTrue(moveEngine.isMovePossible(new Point(2,1)));
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
        assertFalse(moveEngine.isMovePossible(new Point(1,3)));
        assertFalse(moveEngine.isMovePossible(new Point(3,1)));
    }




    @Test
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

        boolean bool = moveStrategyIf.isMovePossible( new Point(2, 2), finalPoint);
        assertTrue(bool);

    }

    @Test
    void walkingCreatureShouldCanMove(){
        Board board = Board.getBoard();
        Creature creature = Creature.builder().aMoveRange(2).build();
        board.putCreature(8,4, creature);

        MoveEngine moveEngine = new MoveEngine(board);
        moveEngine.setActiveCreature(board.getCreatureLocation(creature).get(),creature);

        assertTrue(moveEngine.isMovePossible(new Point(8,5)));
        assertFalse(moveEngine.isMovePossible(new Point(8,7)));
        assertTrue(moveEngine.isMovePossible(new Point(7,4)));
        assertFalse(moveEngine.isMovePossible(new Point(5,4)));

    }



}

