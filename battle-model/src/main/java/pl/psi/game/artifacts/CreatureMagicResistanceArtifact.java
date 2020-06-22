package pl.psi.game.artifacts;

import pl.psi.game.fractions.Creature;

class CreatureMagicResistanceArtifact extends CreatureBuffArtifact {
    private final int magicResistance;

    CreatureMagicResistanceArtifact(int aMagicResistance){
        magicResistance = aMagicResistance;
    }

    @Override
    void buffCreature(Creature c) {
        c.getMagicResistance().addAllSpellsResistancePercentage(magicResistance);
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
