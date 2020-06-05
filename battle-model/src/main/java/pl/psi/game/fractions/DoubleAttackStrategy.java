package pl.psi.game.fractions;

public class DoubleAttackStrategy implements AttackStrategyIf {
    protected Creature creature;

    public DoubleAttackStrategy(Creature aCreature) {
        creature = aCreature;
    }

    @Override
    public void attack(Creature defender) {
        singleAttack(defender);
        singleAttack(defender);
    }

    private void singleAttack(Creature defender) {
        creature.dealDamage(defender);
        if (defender.isCanCounterAttacked()) {
            defender.counterAttack(creature);
        }
    }
}
