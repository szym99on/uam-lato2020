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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.*;

public class ArtifactTest {
    @BeforeAll
    static void initializeFactories() {
        new ArtifactsInfoFactory();
        new ArtifactFactory();
    }

//    ArtifactFactory tests

    @Test
    void factoryShouldCreateCreatureHealthArtifact(){
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(RING_OF_LIFE);
        Artifact ringOfLife = ArtifactFactory.createArtifact(artifactInfo);

        assert ringOfLife != null;
        assertEquals(2, ringOfLife.getHealth());
    }

    @Disabled
    @Test
    void factoryShouldCreateCreatureImmunityArtifact(){
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(PENDANT_OF_LIFE);
        Artifact pendantOfLife = ArtifactFactory.createArtifact(artifactInfo);

        assert pendantOfLife != null;
        // could be assertEquals(DEATH_RIPPLE, pendantOfLife.getSpell()); -depends on implementation of immunity
    }

    @Test
    void factoryShouldCreateCreatureMagicResistanceArtifact(){
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(BOOTS_OF_POLARITY);
        Artifact bootsOfPolarity = ArtifactFactory.createArtifact(artifactInfo);

        assert bootsOfPolarity != null;
        assertEquals(15, bootsOfPolarity.getMagicResistance());
    }

    @Test
    void factoryShouldCreateCreatureSpeedArtifactBasedOnInfo() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(CAPE_OF_VELOCITY);
        Artifact capeOfVelocity = ArtifactFactory.createArtifact(artifactInfo);

        assert capeOfVelocity != null;
        assertEquals(2, capeOfVelocity.getSpeed());
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
    void factoryShouldCreateSpellDurationArtifact(){
        ArtifactInfo artifactsInfo = ArtifactsInfoFactory.getArtifact(COLLAR_OF_CONJURING);
        Artifact collarOfConjuring = ArtifactFactory.createArtifact(artifactsInfo);

        assert collarOfConjuring != null;
        assertEquals(1, collarOfConjuring.getDuration());
    }

    @Disabled
    @Test
    void factoryShouldCreateSpellPreventCastingArtifact(){
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(RECANTERS_CLOAK);
        Artifact recantersCloak = ArtifactFactory.createArtifact(artifactInfo);

        assert recantersCloak != null;
    }



//    CreatureHealthArtifact test

    @Disabled // waiting for increaseHP() implementation by fractions
    @Test
    void artifactShouldIncreaseHealthBy2Points(){
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(RING_OF_LIFE);
        Artifact ringOfLife = ArtifactFactory.createArtifact(artifactInfo);
        List<Creature> creatures = new ArrayList<>();
        Creature creature = Creature.builder().aMaxHp(10).build();
        creatures.add(creature);
        Hero battleHero = Hero.builder().aCreatures(creatures).build();

        try{
            assert ringOfLife != null;
            ringOfLife.apply(battleHero);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(12, battleHero.getCreatures().get(0).getMaxHp());
        assertEquals(12, battleHero.getCreatures().get(0).getCurrentHp());
    }



//    CreatureImmunityArtifact test

    @Disabled // waiting for immunity implementation by fractions/spells
    @Test
    void artifactShouldGrantImmunityToCreature(){
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(PENDANT_OF_DISPASSION);
        Artifact pendantOfDispassion = ArtifactFactory.createArtifact(artifactInfo);
        List<Creature> creatures = new ArrayList<>();
        Creature creature = Creature.builder().aMaxHp(10).build();
        creatures.add(creature);
        Hero battleHero = Hero.builder().aCreatures(creatures).build();

        try{
            assert pendantOfDispassion != null;
            pendantOfDispassion.apply(battleHero);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        assert creature has immunity

    }



//    CreatureMagicResistanceArtifact tests

    @Disabled // waiting for magic resistance implementation by fractions
    @Test
    void artifactShouldIncreaseMagicResistanceBy15Percent(){
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(BOOTS_OF_POLARITY);
        Artifact bootsOfPolarity = ArtifactFactory.createArtifact(artifactInfo);
        List<Creature> creatures = new ArrayList<>();
//        Creature creature = Creature.builder().aMagicResistance(0).build();
//        creatures.add(creature);
//        Hero battleHero = Hero.builder().aCreatures(creatures).build();
//
//        try {
//            assert bootsOfPolarity != null;
//            bootsOfPolarity.apply(battleHero);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        assertEquals(15, battleHero.getCreatures().get(0).getMagicResistance());
    }



//    HeroStatisticArtifact tests

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
    void artifactShouldIncreaseAttackBy2Points(){
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(CENTAURS_AX);
        Artifact centaursAx = ArtifactFactory.createArtifact(artifactInfo);
        Hero battleHero = Hero.builder().build();// default hero stats = 0

        try{
            assert centaursAx != null;
            centaursAx.apply(battleHero);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(0, battleHero.getKnowledge());
        assertEquals(2, battleHero.getAttack());
        assertEquals(0, battleHero.getDefence());
        assertEquals(0, battleHero.getPower());
    }

    @Test
    void artifactShouldIncreaseDefenceBy2Points(){
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(SHIELD_OF_THE_DWARVEN_LORDS);
        Artifact shieldOfTheDwarvenLords = ArtifactFactory.createArtifact(artifactInfo);
        Hero battleHero = Hero.builder().build();// default hero stats = 0

        try{
            assert shieldOfTheDwarvenLords != null;
            shieldOfTheDwarvenLords.apply(battleHero);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(0, battleHero.getKnowledge());
        assertEquals(0, battleHero.getAttack());
        assertEquals(2, battleHero.getDefence());
        assertEquals(0, battleHero.getPower());
    }

    @Test
    void artifactShouldIncreasePowerBy2Points() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(MAGISTERS_SANDALS);
        Artifact magistersSandals = ArtifactFactory.createArtifact(artifactInfo);
        Hero battleHero = Hero.builder().build();// default hero stats = 0

        try{
            assert magistersSandals != null;
            magistersSandals.apply(battleHero);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(0, battleHero.getKnowledge());
        assertEquals(0, battleHero.getAttack());
        assertEquals(0, battleHero.getDefence());
        assertEquals(2, battleHero.getPower());
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
