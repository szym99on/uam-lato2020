package pl.psi.game.fractions;

public class DealDamageCounterWithIgnoreArmorStrategy implements DealDamageCounterStrategyIf{
    @Override
    public int countDamageToDeal(Creature aAttacker, Creature aDefender) {
        return 0;
    }
}
