package pl.psi.game.artifacts;

import pl.psi.game.hero.artifacts.ArtifactInfo;

public class ArtifactFactory {
    public Artifact createArtifact(ArtifactInfo artifactInfo){
        return Artifact.builder().aName(artifactInfo.getName()).aLocation(artifactInfo.getLocation()).build();
    }
}
