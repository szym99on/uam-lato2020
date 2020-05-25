package pl.psi.game.artifacts;

import pl.psi.game.hero.converter.Hero;

class SpellBuffArtifact extends Artifact {
    private int duration;

    SpellBuffArtifact(int aDuration){
        duration = aDuration;
    }

    @Override
    public void apply(Hero aHero) {

    }
}
