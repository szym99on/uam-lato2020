package pl.psi.game.artifacts;

import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.converter.Hero;

public class ArtifactForCreature extends Artifact {
    public ArtifactForCreature(String aName, ArtifactInfo.Location aLocation) {
        super(aName, aLocation);
    }

    @Override
    public void apply(Hero aHero) {

    }
}
