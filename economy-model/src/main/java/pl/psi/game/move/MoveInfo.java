package pl.psi.game.move;

import lombok.Builder;

public class MoveInfo {

    private final boolean canFly;

    public enum AirMagic{
        BASIC,
        ADVANCE,
        EXPERT
    }

    public enum Pathfinding{
        BASIC,
        ADVANCE,
        EXPERT
    }

    @Builder
    public MoveInfo(boolean aCanFly){
        canFly = aCanFly;
    }
}
