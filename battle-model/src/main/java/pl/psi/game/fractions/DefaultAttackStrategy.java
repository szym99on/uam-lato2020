package pl.psi.game.fractions;

public class DefaultAttackStrategy implements AttackStrategyIf {
    protected Creature creature;

    public DefaultAttackStrategy(Creature aCreature) {
        creature = aCreature;
    }

    @Override
    public void attack(Creature aDefender) {
        creature.dealDamage(aDefender);
        if (aDefender.isCanCounterAttacked()) {
            aDefender.counterAttack(creature);
        }
    }
}
