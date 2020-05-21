package pl.psi.game.move;

import org.junit.jupiter.api.Disabled;
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
    @Disabled
    //TODO helping methods like putSmth, setActiveCreature should has package access!
    //putSmth zamienione na put, setActiveCreature???
    void isAnythingOnWayWalk(){

//        Creature c1 = Creature.builder().type(walking).aMoveRange(5).build();
//        Creature c2 = Creature.build();
//
//        Board board = new Board();
//        board.putCreature(1, 1, c1);
//        board.putCreature(1, 3, c2);
//        board.put(new Point(3, 1), new Obstacle());
//
//        MoveEngine moveEngine = new MoveEngine(board);
//        moveEngine.setActiveCreature(new Point(1,1), c1);
//
//        assertFalse(moveEngine.isMovePossible(1, 5));
//        assertFalse(moveEngine.isMovePossible(5,1));

    }

    @Test
    @Disabled
    //TODO: looks fine, but type fly is not exists yet. I suggest strategy pattern and move responsibility for moving here
    void isAnythingOnWayFly(){

//        Creature c1 = Creature.builder().type(fly).aMoveRange(5).build();
//        Creature c2 = Creature.build();
//
//        Board board = new Board();
//        board.putCreature(1,1, c1);
//        board.putCreature(1, 3, c2);
//        board.put(3, 1);
//
//        MoveEngine moveEngine = new MoveEngine(board);
//        moveEngine.setActiveCreature(new Point(1,1), c1);
//
//        assertTrue(moveEngine.isMovePossible(1, 5));
//        assertTrue(moveEngine.isMovePossible(5,1));

    }

    @Test
    @Disabled
    //TODO: use assertEquals instead assertFalse/assertTrue.
    //TODO: tests with specific numbers is better that generic like that.
    //chodzi o specyficzne hp?
    void hurtingFieldWalk(){
//
//        Creature c = Creature.builder().aMaxHp(100).type(walking).aMoveRange(5).build();
//
//        Board board = new Board();
//        board.putCreature(1,1, c);
//        board.putLava(1, 2);
//
//        MoveEngine moveEngine = new MoveEngine(board);
//        moveEngine.setActiveCreature(new Point(1,1), c);
//        moveEngine.move(1,3);
//
//        // assertFalse(hp == c.getCurrentHp());
//        assertEquals(90, c.getCurrentHp());

    }

    @Test
    @Disabled
    void hurtingFieldFly(){

//        Creature c = Creature.builder().maxHp(100).type(fly).aMoveRange(5).build();
//
//        Board board = new Board();
//        board.putCreature(1,1, c);
//        board.putLava(1, 2);
//
//        int hp = c.getCurrentHp();
//
//        MoveEngine moveEngine = new MoveEngine(board);
//        moveEngine.setActiveCreature(new Point(1,1), c);
//        moveEngine.move(1,3);
//
//        assertEquals(c.getMaxHp(), c.getCurrentHp());

    }


    @Test
    @Disabled
    //TODO: howManyFieldsWalked - useless method. HowManyMoveStay - can be usefull
    void calculatedDistanceIsTrue(){
//        Creature c1 = Creature.builder().type(fly).aMoveRange(5).build();
//
//        Board board = new Board();
//        board.putCreature(1,1, c1);
//
//        MoveEngine moveEngine = new MoveEngine(board);
//        moveEngine.setActiveCreature(new Point(1,1),c1);
//        moveEngine.move(1,3);
//
//        assertTrue(moveEngine.howManyFieldsWalked() == 2);
    }

    @Test
    @Disabled
    //TODO: creature don't know who is her owner. We don't want to change that!
    //TODO: isFieldOnCreatureBack??? Is it usefull? o.0 Creature can move in front and back without any specific rules.
    void pointIsBackOfCreature(){
//        Creature c1 = Creature.builder().owner(Player1).aMoveRange(5).build();
//        Creature c2 = Creature.builder().owner(Player2).aMoveRange(5).build();
//
//
//        Board board = new Board();
//        board.putCreature(5,5, c1);
//        board.putCreature(6,5, c2);
//
//        MoveEngine moveEngine = new MoveEngine(board);
//        moveEngine.setActiveCreature(Point(5,5), c1);
//        assertTrue(moveEngine.isFieldOnCreatureBack(Point(4,5)) == true);
//
//        moveEngine.setActiveCreature(Point(6,5), c2);
//        assertTrue(moveEngine.isFieldOnCreatureBack(Point(7,5)) == true);

    }


}