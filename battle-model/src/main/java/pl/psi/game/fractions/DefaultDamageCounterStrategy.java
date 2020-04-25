package pl.psi.game.fractions;

import java.util.Random;

public class DefaultDamageCounterStrategy implements DealDamageCounterStrategyIf{

    private final Creature creature;
    private final static Random random = new Random();

    public DefaultDamageCounterStrategy(Creature aCreature) {
        creature = aCreature;

    }

    @Override
    public int countDamageToDeal(Creature aDefender) {
        int rand = random.nextInt(creature.getAttack().upperEndpoint() - creature.getAttack().lowerEndpoint() + 1);
        int damageToDeal = creature.getAttack().lowerEndpoint()+rand;

        if (damageToDeal - aDefender.getArmor() <= 0) {
            damageToDeal = 1;
        }
        else
        {
            damageToDeal = damageToDeal - aDefender.getArmor();
        }
        return damageToDeal;
    }
}
