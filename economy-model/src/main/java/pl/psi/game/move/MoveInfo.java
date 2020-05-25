package pl.psi.game.move;

import lombok.Builder;

public class MoveInfo {


    private final boolean onlyFly;
    private final String type;

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
    public MoveInfo(boolean aOnlyFly,String aType){
        onlyFly = aOnlyFly;
        type = aType;
    }
}
