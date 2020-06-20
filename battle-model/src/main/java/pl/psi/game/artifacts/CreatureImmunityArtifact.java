package pl.psi.game.artifacts;

import pl.psi.game.fractions.Creature;


class CreatureImmunityArtifact extends CreatureBuffArtifact {
    private final String spellName;

    CreatureImmunityArtifact(String aSpellName) { spellName = aSpellName; }

    @Override
    void buffCreature(Creature c) {
        c.getMagicResistance().addImmunitySpell(spellName);
    }

    @Override
    public int getHealth() { return 0; }

    @Override
    public int getSpeed() { return 0; }

    @Override
    public int getMagicResistance() { return 0; }

    @Override
    public String getSpellImmunityName() {
        return null;
    }
}