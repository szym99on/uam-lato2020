package pl.psi.game.move;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MoveInfoFactoryTest {
    private static final MoveInfoFactory factory = new MoveInfoFactory();
    private static final ArrayList<MoveInfo> moveList = factory.getMoveList();

    @Test
    void diagonalMoveOnDirtCosts141(){
       MoveInfo dirt = moveList.get(0);

       assertEquals(dirt.getDiagonalMoveCost(),141);
    }

    @Test
    void straightMoveOnSandCosts150(){
        MoveInfo sand = moveList.get(8);

        assertEquals(sand.getMoveCost(),150);
    }


}
