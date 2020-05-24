package pl.psi.game.artifacts;

import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.converter.Hero;

public class ArtifactForHero extends Artifact{
    public ArtifactForHero(String aName, ArtifactInfo.Location aLocation) { super(aName, aLocation); }

    @Override
    public void apply(Hero aHero) {

    }
}
