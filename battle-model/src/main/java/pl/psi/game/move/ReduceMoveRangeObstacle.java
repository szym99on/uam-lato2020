package pl.psi.game.move;

import pl.psi.game.fractions.Creature;

import java.awt.*;

public class ReduceMoveRangeObstacle extends ImpactMoveObstacle {

    private final int moveReduce;
    private final int weight;

    public ReduceMoveRangeObstacle(String aName, Point aPoint){
        super(aName, aPoint);
        moveReduce = 3;
        weight = 2;
    }


    @Override
    public boolean isMovePossible() {
        return true;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    int getMoveReduce(){
        return moveReduce;
    }
}
