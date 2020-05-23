package pl.psi.game.artifacts;

import pl.psi.game.hero.artifacts.ArtifactInfo;

public class ArtifactFactory {
    public static Artifact createFromInfo(ArtifactInfo aArtifactInfo) {

        return null;
    }

    //PW you should return concrete class not Artifact. For example:
    // SKULL_HELMET should return Artifact for heroes (more specific HeroAttributesArtifact)
    // BOOTS_OF_POLARITY should return Artifact for creature ( more specific MagicResistanceForCreatureArtifact)
    public static Artifact createArtifact(ArtifactInfo artifactInfo){
//        return Artifact.builder().aName(artifactInfo.getName()).aLocation(artifactInfo.getLocation()).build();
        return null;
    }
}
