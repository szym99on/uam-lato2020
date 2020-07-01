package pl.psi.game.hero.artifacts;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.psi.game.artifacts.Artifact;
import pl.psi.game.artifacts.ArtifactFactory;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import static org.junit.jupiter.api.Assertions.*;
import static pl.psi.game.artifacts.Artifact.*;
import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.*;
import static pl.psi.game.spellbook.SpellBookInfoFactory.MAGIC_ARROW;

public class ArtifactTest {
    @BeforeAll
    static void initializeFactories() {
        new ArtifactsInfoFactory();
        new ArtifactFactory();
        new SpellBookInfoFactory();
    }

    @Test
    void creatureBuffArtifactShouldNotAffectHeroStats() {
        //given
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(RING_OF_LIFE);

        //when
        Artifact creatureBuffArtifact = ArtifactFactory.createArtifact(artifactInfo);

        //then
        assertFalse(creatureBuffArtifact.affectsHeroStats());
    }

    @Test
    void spellBuffArtifactShouldNotAffectHeroStats() {
        //given
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(RING_OF_CONJURING);

        //when
        Artifact spellBuffArtifact = ArtifactFactory.createArtifact(artifactInfo);

        //then
        assertFalse(spellBuffArtifact.affectsHeroStats());
    }

    @Test
    void heroStatisticArtifactShouldAffectHeroStats() {
        //given
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(ARMOR_OF_WONDER);

        //when
        Artifact heroStatisticArtifact = ArtifactFactory.createArtifact(artifactInfo);

        //then
        assertTrue(heroStatisticArtifact.affectsHeroStats());
    }

    @Test
    void artifactShouldNotReturnBuffStatisticsBasedOnInvalidKey() {
        //given
        ArtifactInfo artifactsInfo = ArtifactsInfoFactory.getArtifact(COLLAR_OF_CONJURING);

        //when
        Artifact collarOfConjuring = ArtifactFactory.createArtifact(artifactsInfo);

        //then
        try {
            collarOfConjuring.showStatisticsBuff("duration");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "This key is invalid");
        }
    }

    @Test
    void shouldReturnThatArtifactGrantNoImmunity() {
        //given
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(BOOTS_OF_POLARITY);

        //when
        Artifact bootsOfPolarity = ArtifactFactory.createArtifact(artifactInfo);

        //then
        assertEquals(DEFAULT_IMMUNITY, bootsOfPolarity.getSpellImmunityName());
    }

    @Test
    void shouldReturnThatArtifactGrantImmunity() {
        //given
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(PENDANT_OF_DISPASSION);

        //when
        Artifact bootsOfPolarity = ArtifactFactory.createArtifact(artifactInfo);

        //then
        assertEquals(MAGIC_ARROW, bootsOfPolarity.getSpellImmunityName());
    }
}
