package pl.psi.game.hero.artifact;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.psi.game.hero.artifacts.ArtifactInfo.Location.*;
import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.*;

public class ArtifactInfoTest {
    @BeforeAll
    static void initializeFactories(){
        new ArtifactsInfoFactory();
    }

    @Test
    void shouldFindAppropriateArtifactByName(){
        assertEquals(HELM_OF_THE_ALABASTER_UNICORN,getArtifact(HELM_OF_THE_ALABASTER_UNICORN).getName());
        assertEquals(1000,getArtifact(HELM_OF_THE_ALABASTER_UNICORN).getCost());
        assertEquals(HEAD, getArtifact(HELM_OF_THE_ALABASTER_UNICORN).getLocation());

        assertEquals(SKULL_HELMET,getArtifact(SKULL_HELMET).getName());
        assertEquals(3000,getArtifact(SKULL_HELMET).getCost());
        assertEquals(HEAD, getArtifact(SKULL_HELMET).getLocation());

        assertEquals(BLACKSHARD_OF_THE_DEAD_KNIGHT,getArtifact(BLACKSHARD_OF_THE_DEAD_KNIGHT).getName());
        assertEquals(3000,getArtifact(BLACKSHARD_OF_THE_DEAD_KNIGHT).getCost());
        assertEquals(RIGHT_HAND, getArtifact(BLACKSHARD_OF_THE_DEAD_KNIGHT).getLocation());

        assertEquals(RING_OF_VITALITY,getArtifact(RING_OF_VITALITY).getName());
        assertEquals(5000,getArtifact(RING_OF_VITALITY).getCost());
        assertEquals(FINGERS, getArtifact(RING_OF_VITALITY).getLocation());

        assertEquals(GUARDIANS_BOOTS,getArtifact(GUARDIANS_BOOTS).getName());
        assertEquals(3000,getArtifact(GUARDIANS_BOOTS).getCost());
        assertEquals(FEET, getArtifact(GUARDIANS_BOOTS).getLocation());
    }
}
