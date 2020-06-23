package pl.psi.game.move;

import pl.psi.game.fractions.Creature;

import java.awt.*;

class EndingMoveObstacle extends ImpactMoveObstacle {


    public EndingMoveObstacle(String aName, Point aPoint) {
        super(aName, aPoint);
    }

    @Override
    boolean isMovePossible() {
        return false;
    }
}
