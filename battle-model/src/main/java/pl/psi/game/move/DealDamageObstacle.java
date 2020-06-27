package pl.psi.game.move;

import pl.psi.game.fractions.Creature;

import java.awt.*;

class DealDamageObstacle extends ImpactCreatureObstacle {

    private final int attack;
    private final int weight;

    public DealDamageObstacle(String aName, Point aPoint) {
        super(aName, aPoint);
        attack = 1;
        weight = 1;
    }

    @Override
    public void apply(Creature creature) {
        if (!creature.isCanFly()) {
            creature.takePureDamage(attack);
        }
    }

    @Override
    public int getWeight() {
        return weight;
    }
}
