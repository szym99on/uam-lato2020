package pl.psi.game.move;

import pl.psi.game.fractions.Creature;

import java.awt.*;

public class ReduceMoveRangeObstacle extends Obstacle {

    public ReduceMoveRangeObstacle(String aName, Point aPoint) {
        super(aName, aPoint);
    }

    @Override
    public Point apply(Creature aCreature) {
        aCreature.decreaseMoveRange(-3);
        return null;
    }

}
