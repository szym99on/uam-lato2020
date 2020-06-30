package pl.psi.game.artifacts;

import pl.psi.game.fractions.Creature;

class CreatureMagicResistanceArtifact extends CreatureBuffArtifact {
    private final int magicResistance;

    CreatureMagicResistanceArtifact(int aMagicResistance){
        magicResistance = aMagicResistance;
        statisticsBuffs.replace(CREATURE_MAGIC_RESISTANCE, magicResistance);
    }

    @Override
    void buffCreature(Creature c) {
        c.getMagicResistance().addAllSpellsResistancePercentage(magicResistance);
    }
}
