package pl.psi.game.artifacts;

import pl.psi.game.hero.converter.Hero;

class SpellDurationArtifact extends Artifact {
    private int duration;

    SpellDurationArtifact(int aDuration){
        duration = aDuration;
    }

    @Override
    public void apply(Hero aHero) {

    }
}
