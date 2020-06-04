package pl.psi.game.move;

import pl.psi.game.fractions.Creature;

public class DealDamageObstacle extends Obstacle{

    public DealDamageObstacle(String aType, int aAttack, int aReduceMoveRange, boolean aIsEndingMove) {
        super(aType, aAttack, aReduceMoveRange, aIsEndingMove);
    }

    @Override
    public void apply(Creature aCreature) {
        aCreature.dealDamage(1);
    }
}
