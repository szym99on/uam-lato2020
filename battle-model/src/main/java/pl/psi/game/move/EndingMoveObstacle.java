package pl.psi.game.move;

import pl.psi.game.fractions.Creature;

import java.awt.*;

class EndingMoveObstacle extends Obstacle {

    private Point point;

    public EndingMoveObstacle(String aName, Point aPoint) {
        super(aName, aPoint);
        point = aPoint;
    }

    @Override
    public Point apply(Creature aCreature) {
        return point;
    }


    @Override
    public Obstacle getObstacle() {
        return null;
    }
}
