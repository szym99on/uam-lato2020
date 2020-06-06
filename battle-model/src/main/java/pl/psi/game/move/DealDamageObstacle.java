package pl.psi.game.move;

import pl.psi.game.fractions.Creature;
import pl.psi.game.move.Obstacle;

class DealDamageObstacle extends Obstacle {

    private final int attack;

    public DealDamageObstacle(String aName) {
        super(aName);
        attack = 1;
    }

    @Override
    public void apply(Creature aCreature) {

        aCreature.dealDamageObs(attack);

    }
}
