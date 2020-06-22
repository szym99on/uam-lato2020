package pl.psi.game.move;

import pl.psi.game.fractions.Creature;

import java.awt.*;

public class ReduceMoveRangeObstacle extends ImpactMoveObstacle {

    final int moveReduce;

    public ReduceMoveRangeObstacle(String aName, Point aPoint){
        super(aName, aPoint);
        moveReduce = 3;
    }


    @Override
    boolean isMovePossible() {
        return false;
    }
}
