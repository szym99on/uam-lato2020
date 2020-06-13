package pl.psi.game.artifacts;

import java.util.ArrayList;
import java.util.List;

import pl.psi.game.fractions.Creature;
import pl.psi.game.fractions.MagicResistance;
import pl.psi.game.fractions.MagicResistance.ImmunityType;


class CreatureImmunityArtifact extends CreatureBuffArtifact {
    private final String spellName;

    CreatureImmunityArtifact(String aSpellName) { spellName = aSpellName; }

    @Override
    void buffCreature(Creature c) {
        List<String> spells = new ArrayList<>();
        spells.add(spellName);
        MagicResistance magicResistance = new MagicResistance(0, ImmunityType.NONE, spells);
        c.setMagicResistance(magicResistance);
    }

    @Override
    public int getHealth() { return 0; }

    @Override
    public int getSpeed() { return 0; }

    @Override
    public int getMagicResistance() { return 0; }

    @Override
    public String getSpellImmunityName() {
        return spellName;
    }
}
