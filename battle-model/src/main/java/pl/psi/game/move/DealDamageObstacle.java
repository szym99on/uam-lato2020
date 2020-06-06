package pl.psi.game.move;

import pl.psi.game.fractions.Creature;
import pl.psi.game.move.Obstacle;

class DealDamageObstacle extends Obstacle {

    @Override
    public void apply(Creature aCreature) {

        // dealDamage bierze przciwnika i od niego ile damga
        aCreature.dealDamage();

    }
}
