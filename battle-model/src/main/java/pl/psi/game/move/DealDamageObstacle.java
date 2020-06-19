package pl.psi.game.move;

import pl.psi.game.fractions.Creature;

import java.awt.*;

class DealDamageObstacle extends Obstacle {

    private final int attack;

    public DealDamageObstacle(String aName, Point aPoint) {
        super(aName, aPoint);
        attack = 1;
    }

    @Override
    public Point apply(Creature creature) {
        creature.dealDamageObs(attack);
        return null;
    }

    @Override
    public boolean isObstacle() {
        return true;
    }
}
