package pl.psi.game.move;

import java.awt.*;

class EndingMoveObstacle extends ImpactMoveObstacle {

    private final int weight;

    public EndingMoveObstacle(String aName, Point aPoint) {
        super(aName, aPoint);
        weight = Integer.MAX_VALUE;
    }

    @Override
    boolean isMovePossible() {
        return false;
    }

    @Override
    public int getWeight() {
        return weight;
    }
}
