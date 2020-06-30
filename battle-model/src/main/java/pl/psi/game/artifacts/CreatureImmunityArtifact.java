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
    public String getSpellImmunityName() { return spellName; }
}