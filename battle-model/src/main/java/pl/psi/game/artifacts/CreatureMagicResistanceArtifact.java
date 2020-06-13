package pl.psi.game.artifacts;

import static pl.psi.game.fractions.MagicResistance.ImmunityType.NONE;

import java.util.ArrayList;

import pl.psi.game.fractions.Creature;
import pl.psi.game.fractions.MagicResistance;

class CreatureMagicResistanceArtifact extends CreatureBuffArtifact {
    private final int magicResistance;

    CreatureMagicResistanceArtifact(int aMagicResistance){
        magicResistance = aMagicResistance;
    }

    @Override
    void buffCreature(Creature c) {
        MagicResistance magicResistanceToGive = new MagicResistance(magicResistance, NONE, new ArrayList<>());
        c.setMagicResistance(magicResistanceToGive);
    }

    @Override
    public int getMagicResistance() { return magicResistance; }

    @Override
    public int getHealth() { return 0; }

    @Override
    public int getSpeed() { return 0; }

    @Override
    public String getSpellImmunityName() { return "NONE"; }
}
