package pl.psi.game.move;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveInfoTest {
    private static String NOT_IMPORTANT;

    @Test
    void pathFindingReduceBasic(){
        MoveInfo moveInfo = new MoveInfo(NOT_IMPORTANT,125, MoveInfoFactory.Pathfinding.BASIC);
        assertEquals(moveInfo.getMoveCost(),100);
    }

    @Test
    void pathFindingReduceAdvance(){
        MoveInfo moveInfo = new MoveInfo(NOT_IMPORTANT,125, MoveInfoFactory.Pathfinding.ADVANCE);
        assertEquals(moveInfo.getMoveCost(),100);
    }

    @Test
    void pathFindingReduceExpert(){
        MoveInfo moveInfo = new MoveInfo(NOT_IMPORTANT,125, MoveInfoFactory.Pathfinding.EXPERT);
        assertEquals(moveInfo.getMoveCost(),100);
    }

    @Test
    void pathFindingReduceAdvanceSwampShouldBe125(){
        MoveInfo moveInfo = new MoveInfo(NOT_IMPORTANT,175, MoveInfoFactory.Pathfinding.ADVANCE);
        assertEquals(moveInfo.getMoveCost(),125);
    }
}
