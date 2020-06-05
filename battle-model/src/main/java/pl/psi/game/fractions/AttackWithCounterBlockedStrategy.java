package pl.psi.game.fractions;

public class AttackWithCounterBlockedStrategy implements AttackStrategyIf {
    protected Creature creature;

    public AttackWithCounterBlockedStrategy(Creature aCreature) {
        creature = aCreature;
    }

    @Override
    public void attack(Creature aDefender) {
        creature.dealDamage(aDefender);
    }
}
