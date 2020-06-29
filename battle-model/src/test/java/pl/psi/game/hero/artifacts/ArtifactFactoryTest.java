package pl.psi.game.hero.artifacts;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.psi.game.artifacts.Artifact;
import pl.psi.game.artifacts.ArtifactFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.psi.game.artifacts.Artifact.*;
import static pl.psi.game.artifacts.Artifact.SPELL_DURATION;
import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.*;
import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.COLLAR_OF_CONJURING;
import static pl.psi.game.spellbook.SpellBookInfoFactory.LIGHTNING_BOLT;

public class ArtifactFactoryTest {
    private final static String INVALID_INFO = "Invalid Artifact";
    @BeforeAll
    static void initializeFactories() {
        new ArtifactsInfoFactory();
        new ArtifactFactory();
    }

    @Test
    void factoryShouldCreateCreatureHealthArtifact() {
        //given
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(RING_OF_LIFE);

        //when
        Artifact ringOfLife = ArtifactFactory.createArtifact(artifactInfo);

        //then
        assertEquals(2, ringOfLife.showStatisticsBuff(CREATURE_HEALTH));
    }

    @Test
    void factoryShouldNotCreateArtifactBasedOnInvalidINFO() {
        //given
        ArtifactInfo artifactInfo = ArtifactInfo.builder().aName(INVALID_INFO).build();

        //when
        try {
            Artifact artifact = ArtifactFactory.createArtifact(artifactInfo);
        } catch (Exception e) {
        //then
            assertEquals(e.getMessage(), "Incorrect ArtifactInfo");
        }
    }

    @Test
    void factoryShouldCreateCreatureImmunityArtifact() {
        //given
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(PENDANT_OF_LIFE);

        //when
        Artifact pendantOfLife = ArtifactFactory.createArtifact(artifactInfo);

        //then
        assertEquals(LIGHTNING_BOLT, pendantOfLife.getSpellImmunityName());
    }

    @Test
    void factoryShouldCreateCreatureMagicResistanceArtifact() {
        //given
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(BOOTS_OF_POLARITY);

        //when
        Artifact bootsOfPolarity = ArtifactFactory.createArtifact(artifactInfo);

        //then
        assertEquals(15, bootsOfPolarity.showStatisticsBuff(CREATURE_MAGIC_RESISTANCE));
    }

    @Test
    void factoryShouldCreateCreatureSpeedArtifactBasedOnInfo() {
        //given
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(CAPE_OF_VELOCITY);

        //when
        Artifact capeOfVelocity = ArtifactFactory.createArtifact(artifactInfo);
        //then
        assertEquals(2, capeOfVelocity.showStatisticsBuff(CREATURE_SPEED));
    }

    @Test
    void factoryShouldCreateHeroStatisticArtifactBasedOnInfo() {
        //given
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(OGRES_CLUB_OF_HAVOC);

        //when
        Artifact artifact = ArtifactFactory.createArtifact(artifactInfo);

        //then
        assertEquals(5, artifact.showStatisticsBuff(HERO_ATTACK));
        assertEquals(0, artifact.showStatisticsBuff(HERO_DEFENCE));
        assertEquals(0, artifact.showStatisticsBuff(HERO_POWER));
        assertEquals(0, artifact.showStatisticsBuff(HERO_KNOWLEDGE));
    }

    @Test
    void factoryShouldCreateSpellDurationArtifact() {
        //given
        ArtifactInfo artifactsInfo = ArtifactsInfoFactory.getArtifact(COLLAR_OF_CONJURING);

        //when
        Artifact collarOfConjuring = ArtifactFactory.createArtifact(artifactsInfo);

        //then
        assertEquals(1, collarOfConjuring.showStatisticsBuff(SPELL_DURATION));
    }
}
