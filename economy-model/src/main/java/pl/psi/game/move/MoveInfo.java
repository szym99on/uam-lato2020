package pl.psi.game.move;

public class MoveInfo {

    
    private String groundType;
    private int moveCost;
    private double diagonalMoveCost;

    public MoveInfo(
            String aGroundType,
            int aMoveCost
            ){
        moveCost = aMoveCost;
        groundType = aGroundType;
        diagonalMoveCost = moveCost * 1.41;
    }

}
