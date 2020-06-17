package pl.psi.game.hero.artifacts;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.psi.game.artifacts.Artifact;
import pl.psi.game.artifacts.ArtifactFactory;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import pl.psi.game.spellbook.SpellFactory;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterRequest {
    @BeforeAll
    static void initializeFactories() {
        new ArtifactsInfoFactory();
        new ArtifactFactory();
    }

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
    @Test
    void ArtifactCanChangeHeroStats() {
        Artifact artifact = ArtifactFactory.createArtifact(ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.HELM_OF_THE_ALABASTER_UNICORN));
        assertEquals(artifact.affectsHeroStats(),true);
    }

    @Test
    void ArtifactCantChangeHeroStats() {
//        Artifact artifact = ArtifactFactory.createArtifact(ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.BREASTPLATE_OF_PETRIFIED_WOOD)); //breastplate is increasing hero's stats
        Artifact artifact = ArtifactFactory.createArtifact(ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.SURCOAT_OF_COUNTERPOISE));
        assertEquals(artifact.affectsHeroStats(),false);
    }
}
