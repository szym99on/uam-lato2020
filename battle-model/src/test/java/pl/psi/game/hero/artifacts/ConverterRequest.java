package pl.psi.game.hero.artifacts;

import org.junit.jupiter.api.Test;
import pl.psi.game.artifacts.Artifact;
import pl.psi.game.artifacts.ArtifactFactory;
import pl.psi.game.hero.converter.Hero;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterRequest {
    @Test
    void GetArtifactInfoFromFactory()
    {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.HELM_OF_THE_ALABASTER_UNICORN);
    }
    @Test
    void ApplyArtifactOnHero() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.HELM_OF_THE_ALABASTER_UNICORN);
        Hero hero = Hero.builder().build();
        Artifact artifact = ArtifactFactory.createArtifact(artifactInfo);
        artifact.apply(hero);
        assertEquals(hero.getKnowledge(),1);
    }
}
