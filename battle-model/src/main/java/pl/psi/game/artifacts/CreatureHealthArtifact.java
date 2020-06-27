package pl.psi.game.artifacts;

import pl.psi.game.fractions.Creature;

class CreatureHealthArtifact extends CreatureBuffArtifact{
    private final int health;

    CreatureHealthArtifact(int aHealth){
        health = aHealth;
        statisticsBuffs.replace(CREATURE_HEALTH, health);
    }

    @Override
    void buffCreature(Creature c) {
        c.increaseHP(health);
    }

    @Override
    public String getSpellImmunityName() { return "NONE"; }
}
