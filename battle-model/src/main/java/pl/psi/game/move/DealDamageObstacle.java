package pl.psi.game.move;

import pl.psi.game.fractions.Creature;

import java.awt.*;

class DealDamageObstacle extends ImpactCreatureObstacle {

    private final int attack;

    public DealDamageObstacle(String aName, Point aPoint) {
        super(aName, aPoint);
        attack = 1;
    }

    @Override
    public void apply(Creature creature) {
        creature.takePureDamage(attack);
    }

}
