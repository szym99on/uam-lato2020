package pl.psi.game.move;

import lombok.Builder;

public class ObstacleInfo {

    private final String obstacleType;
    private final int obstacleAttack;
    private final int obastacleReduceMoveRange;
    private final boolean obstacleIsEndingMove;
    public enum Type{
        LAVA,
        MARSH,
        RIVER
    }
    public enum ObstacleClass{
        LAVA("lava", 10, 0, false),
        MARSH("marsh", 0, 3, false),
        RIVER("river", 0, 0, true);
        final String type;
        final int attack;
        final int reduceMoveRange;
        final boolean isEndingMove;
        private ObstacleClass(String aType, int aAttack, int aReduceMoveRange, boolean aIsEndingMove){
            type = aType;
            attack = aAttack;
            reduceMoveRange = aReduceMoveRange;
            isEndingMove = aIsEndingMove;
        }
    }


    @Builder
    public ObstacleInfo(ObstacleClass aObstacleClass){
        obstacleType = aObstacleClass.type;
        obstacleAttack = aObstacleClass.attack;
        obastacleReduceMoveRange = aObstacleClass.reduceMoveRange;
        obstacleIsEndingMove = aObstacleClass.isEndingMove;
    }

    public String getType(){
        return obstacleType;
    }


    public int getObstacleAttack() {
        return obstacleAttack;
    }

    public int getObastacleReduceMoveRange() {
        return obastacleReduceMoveRange;
    }

    public boolean isObstacleIsEndingMove() {
        return obstacleIsEndingMove;
    }

}

