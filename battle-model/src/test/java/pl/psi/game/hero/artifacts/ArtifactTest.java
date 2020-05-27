package pl.psi.game.hero.artifacts;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.artifacts.Artifact;
import pl.psi.game.artifacts.ArtifactFactory;
import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.hero.converter.HeroEcoBattleConverter;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.*;

public class ArtifactTest {
    @BeforeAll
    static void initializeFactories() {
        new ArtifactsInfoFactory();
        new ArtifactFactory();
    }

    @Test
    void factoryShouldCreateHeroStatisticArtifactBasedOnInfo() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(SKULL_HELMET);
        Artifact skullHelmet = ArtifactFactory.createArtifact(artifactInfo);

        assert skullHelmet != null;
        assertEquals(0, skullHelmet.getAttack());
        assertEquals(0, skullHelmet.getDefence());
        assertEquals(2, skullHelmet.getKnowledge());
        assertEquals(0, skullHelmet.getPower());
    }

    @Test
    void factoryShouldCreateSpellDurationArtifactBasedOnInfo() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(CAPE_OF_VELOCITY);
        Artifact capeOfVelocity = ArtifactFactory.createArtifact(artifactInfo);

        assert capeOfVelocity != null;
        assertEquals(2, capeOfVelocity.getSpeed());
    }

    @Test
    void artifactShouldIncreaseKnowledgeBy2Points() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(SKULL_HELMET);
        Artifact skullHelmet = ArtifactFactory.createArtifact(artifactInfo);
        Hero battleHero = Hero.builder().build();// default hero stats = 0

        try {
            assert skullHelmet != null;
            skullHelmet.apply(battleHero);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(2, battleHero.getKnowledge());
        assertEquals(0, battleHero.getAttack());
        assertEquals(0, battleHero.getDefence());
        assertEquals(0, battleHero.getPower());
    }

    @Test
    void artifactShouldIncreaseAllStatsBy1Point() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(ARMOR_OF_WONDER);
        Artifact armorOfWonders = ArtifactFactory.createArtifact(artifactInfo);
        Hero battleHero = Hero.builder().build();// default hero stats = 0

        try {
            assert armorOfWonders != null;
            armorOfWonders.apply(battleHero);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(1, battleHero.getKnowledge());
        assertEquals(1, battleHero.getAttack());
        assertEquals(1, battleHero.getDefence());
        assertEquals(1, battleHero.getPower());
    }
}
