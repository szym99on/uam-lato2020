package pl.psi.game.fractions;

import java.util.Random;

public class DealDamageCounterDoubleToWaterElementalStrategy implements DealDamageCounterStrategyIf{

    private final static Random random = new Random();

    @Override
    public int countDamageToDeal(Creature aAttacker, Creature aDefender) {
        int rand = random.nextInt(aAttacker.getAttack().upperEndpoint() - aAttacker.getAttack().lowerEndpoint() + 1);
        int damageToDeal = aAttacker.getAttack().lowerEndpoint()+rand;

        if (damageToDeal - aDefender.getArmor() <= 0) {
            damageToDeal = 1;
        }
        else
        {
            damageToDeal = damageToDeal - aDefender.getArmor();
        }
        if (aDefender.getName().equals("Ice elemental")) {
        	return damageToDeal * 2;
        }
        return damageToDeal;
    }
}
