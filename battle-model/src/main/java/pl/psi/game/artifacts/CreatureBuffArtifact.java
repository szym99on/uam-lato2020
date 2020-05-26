package pl.psi.game.artifacts;

import pl.psi.game.hero.converter.Hero;

abstract class CreatureBuffArtifact extends Artifact {

    @Override
    public void apply(Hero aHero) {

    }

    @Override
    public int getAttack() { return 0; }

    @Override
    public int getDefence() { return 0; }

    @Override
    public int getPower() { return 0; }

    @Override
    public int getKnowledge() { return 0; }

}
