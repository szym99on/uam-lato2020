package pl.psi.game.artifacts;

import pl.psi.game.fractions.Creature;
import pl.psi.game.fractions.MagicResistance;

import static pl.psi.game.fractions.MagicResistance.ImmunityType.*;

class CreatureMagicResistanceArtifact extends CreatureBuffArtifact {
    private final int magicResistance;

    CreatureMagicResistanceArtifact(int aMagicResistance){
        magicResistance = aMagicResistance;
    }

    @Override
    void buffCreature(Creature c) {
        MagicResistance magicResistanceToGive = new MagicResistance(magicResistance, NONE);
        c.setMagicResistance(magicResistanceToGive);
    }

    @Override
    public int getMagicResistance() { return magicResistance; }

    @Override
    public int getHealth() { return 0; }

    @Override
    public int getSpeed() { return 0; }
}
