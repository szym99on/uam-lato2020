package pl.psi.game.move;

import java.awt.*;

class EndingMoveObstacle extends ImpactMoveObstacle {

    public EndingMoveObstacle(String aName, Point aPoint) {
        super(aName, aPoint);
    }

    @Override
    public boolean isPassable() {
        return false;
    }

}
