package pl.psi.game.artifacts;

import pl.psi.game.fractions.Creature;

class CreatureMagicResistanceArtifact extends CreatureBuffArtifact {
    private final int magicResistance;

    CreatureMagicResistanceArtifact(int aMagicResistance){
        magicResistance = aMagicResistance;
    }

    @Override
    void buffCreature(Creature c) {
//        c.increaseMagicResistance(magicResistance);
    }

    @Override
    public int getHealth() { return 0; }

    @Override
    public int getSpeed() { return 0; }
}
