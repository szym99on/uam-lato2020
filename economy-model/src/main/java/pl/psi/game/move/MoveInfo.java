package pl.psi.game.move;

public class MoveInfo {

    private final Pathfinding airMagic;
    private final AirMagic pathFinding;

    public enum AirMagic {
        BASIC,
        ADVANCE,
        EXPERT
    }

    public enum Pathfinding {
        BASIC,
        ADVANCE,
        EXPERT
    }

    MoveInfo(Pathfinding aAirMagic,AirMagic aPathFinding){
        airMagic = aAirMagic;
        pathFinding = aPathFinding;
    }
}
