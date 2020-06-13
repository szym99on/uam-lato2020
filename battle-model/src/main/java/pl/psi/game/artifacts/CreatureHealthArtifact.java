package pl.psi.game.artifacts;

import pl.psi.game.fractions.Creature;

class CreatureHealthArtifact extends CreatureBuffArtifact{
    private final int health;

    CreatureHealthArtifact(int aHealth){ health = aHealth; }

    @Override
    void buffCreature(Creature c) {
        c.increaseHP(health);
    }

    @Override
    public int getHealth() { return health; }

    @Override
    public int getSpeed() { return 0; }

    @Override
    public int getMagicResistance() { return 0; }

    @Override
    public String getSpellImmunityName() { return "NONE"; }
}
