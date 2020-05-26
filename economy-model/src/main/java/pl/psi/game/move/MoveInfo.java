package pl.psi.game.move;

public class MoveInfo {

    
    private String groundType;
    private int moveCost;
    private int diagonalMoveCost;

    public String getGroundType() {
        return groundType;
    }

    public int getMoveCost() {
        return moveCost;
    }

    public int getDiagonalMoveCost() {
        return diagonalMoveCost;
    }

    public MoveInfo(
            String aGroundType,
            int aMoveCost
            ){
        moveCost = aMoveCost;
        groundType = aGroundType;
        diagonalMoveCost = (int)(moveCost * 1.41);
    }

}
