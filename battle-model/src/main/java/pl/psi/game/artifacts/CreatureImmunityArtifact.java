package pl.psi.game.artifacts;

import pl.psi.game.fractions.Creature;

class CreatureImmunityArtifact extends CreatureBuffArtifact {
    @Override
    void buffCreature(Creature c) {

    }

    @Override
    public int getHealth() { return 0; }

    @Override
    public int getSpeed() { return 0; }
}
