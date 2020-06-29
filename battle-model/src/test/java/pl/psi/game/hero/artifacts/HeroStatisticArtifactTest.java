package pl.psi.game.hero.artifacts;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.psi.game.artifacts.Artifact;
import pl.psi.game.artifacts.ArtifactFactory;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.spellbook.SpellBookInfoFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.*;

public class HeroStatisticArtifactTest {
    @BeforeAll
    static void initializeFactories() {
        new ArtifactsInfoFactory();
        new ArtifactFactory();
        new SpellBookInfoFactory();
    }
    @Test
    void artifactShouldIncreaseKnowledgeBy2Points() {
        //given
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(SKULL_HELMET);
        Artifact skullHelmet = ArtifactFactory.createArtifact(artifactInfo);
        Hero battleHero = Hero.builder().build();// default hero stats = 0

        //when
        try {
            skullHelmet.apply(battleHero);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //then
        assertEquals(2, battleHero.getKnowledge());
        assertEquals(0, battleHero.getAttack());
        assertEquals(0, battleHero.getDefence());
        assertEquals(0, battleHero.getPower());
    }

    @Test
    void artifactShouldIncreaseAttackBy2Points() {
        //given
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(CENTAURS_AX);
        Artifact centaursAx = ArtifactFactory.createArtifact(artifactInfo);
        Hero battleHero = Hero.builder().build();// default hero stats = 0

        //when
        try {
            centaursAx.apply(battleHero);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //then
        assertEquals(0, battleHero.getKnowledge());
        assertEquals(2, battleHero.getAttack());
        assertEquals(0, battleHero.getDefence());
        assertEquals(0, battleHero.getPower());
    }

    @Test
    void artifactShouldIncreaseDefenceBy2Points() {
        //given
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(SHIELD_OF_THE_DWARVEN_LORDS);
        Artifact shieldOfTheDwarvenLords = ArtifactFactory.createArtifact(artifactInfo);
        Hero battleHero = Hero.builder().build();// default hero stats = 0

        //then
        try {
            shieldOfTheDwarvenLords.apply(battleHero);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //then
        assertEquals(0, battleHero.getKnowledge());
        assertEquals(0, battleHero.getAttack());
        assertEquals(2, battleHero.getDefence());
        assertEquals(0, battleHero.getPower());
    }

    @Test
    void artifactShouldIncreasePowerBy2Points() {
        //given
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(MAGISTERS_SANDALS);
        Artifact magistersSandals = ArtifactFactory.createArtifact(artifactInfo);
        Hero battleHero = Hero.builder().build();// default hero stats = 0

        //when
        try {
            magistersSandals.apply(battleHero);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //then
        assertEquals(0, battleHero.getKnowledge());
        assertEquals(0, battleHero.getAttack());
        assertEquals(0, battleHero.getDefence());
        assertEquals(2, battleHero.getPower());
    }

    @Test
    void artifactShouldIncreaseAllStatsBy1Point() {
        //given
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(ARMOR_OF_WONDER);
        Artifact armorOfWonders = ArtifactFactory.createArtifact(artifactInfo);
        Hero battleHero = Hero.builder().build();// default hero stats = 0

        //when
        try {
            armorOfWonders.apply(battleHero);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //then
        assertEquals(1, battleHero.getKnowledge());
        assertEquals(1, battleHero.getAttack());
        assertEquals(1, battleHero.getDefence());
        assertEquals(1, battleHero.getPower());
    }
}
