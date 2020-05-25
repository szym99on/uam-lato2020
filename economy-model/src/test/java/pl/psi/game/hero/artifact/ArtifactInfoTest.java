package pl.psi.game.hero.artifact;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.HELM_OF_THE_ALABASTER_UNICORN;
import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.getArtifact;

public class ArtifactInfoTest {
    @BeforeAll
    static void initializeFactories(){
        new ArtifactsInfoFactory();
    }

    @Test
    void shouldFindAppropriateArtifactByName(){
        assertEquals(HELM_OF_THE_ALABASTER_UNICORN,getArtifact(HELM_OF_THE_ALABASTER_UNICORN).getName());
        assertEquals(1000,getArtifact(HELM_OF_THE_ALABASTER_UNICORN).getCost());

    }
}
