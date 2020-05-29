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
            int aMoveCost,
            MoveInfoFactory.Pathfinding pathfinding
            ){
        moveCost = aMoveCost;
        groundType = aGroundType;
        pathFindingReduce(pathfinding);
        diagonalMoveCost = (int)(moveCost * 1.41);
    }

    private void pathFindingReduce(MoveInfoFactory.Pathfinding pathfinding){
        int reduceValue;
        switch (pathfinding.name()){
            case "BASIC":
                reduceValue = 25;
                break;
            case "ADVANCE":
                reduceValue = 50;
                break;
            case "EXPERT":
                reduceValue = 75;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + pathfinding.name());
        }


        if(moveCost - reduceValue < 100){
            moveCost = 100;
        }
        else {
            moveCost -= reduceValue;
        }
    }
}
