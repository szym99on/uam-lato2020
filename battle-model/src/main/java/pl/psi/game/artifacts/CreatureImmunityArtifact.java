package pl.psi.game.artifacts;

import pl.psi.game.fractions.Creature;
import pl.psi.game.fractions.MagicResistance;
import pl.psi.game.fractions.MagicResistance.*;


class CreatureImmunityArtifact extends CreatureBuffArtifact {
    private final ImmunityType immunityType;

    CreatureImmunityArtifact(ImmunityType aImmunityType) { immunityType = aImmunityType; }

    @Override
    void buffCreature(Creature c) {
        MagicResistance magicResistance = new MagicResistance(0, immunityType);
        c.setMagicResistance(magicResistance);
    }

    @Override
    public int getHealth() { return 0; }

    @Override
    public int getSpeed() { return 0; }

    @Override
    public int getMagicResistance() { return 0; }
}
