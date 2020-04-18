import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveEngineTest {

    // Creature moveCreature (newLocation)
    // Boolean isMovePossible(Point)

    @Test
    void moveShouldBePossible(){
        Creature c = Creature.builder().aMoveRange(1).build();
        Board board = new Board();
        board.putCreature(1,1, c);

        MoveEngine moveEngine = new MoveEngine(board);

        assertTrue(moveEngine.isMovePossible(1,2));
        assertTrue(moveEngine.isMovePossible(2,1));
        assertTrue(moveEngine.isMovePossible(0,1));
        assertTrue(moveEngine.isMovePossible(1,0));

    }

}