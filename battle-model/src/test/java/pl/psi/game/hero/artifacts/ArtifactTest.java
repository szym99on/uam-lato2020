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
import pl.psi.game.spellbook.Spell;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import pl.psi.game.spellbook.SpellFactory;
import pl.psi.game.spellbook.SpellInfo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pl.psi.game.fractions.MagicResistance.ImmunityType.NONE;
import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.*;
import static pl.psi.game.spellbook.SpellBookInfoFactory.*;

public class ArtifactTest {
    @BeforeAll
    static void initializeFactories() {
        new ArtifactsInfoFactory();
        new ArtifactFactory();
        new SpellBookInfoFactory();
        new SpellFactory();
    }

//    ArtifactFactory tests

    @Test
    void factoryShouldCreateCreatureHealthArtifact() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(RING_OF_LIFE);
        Artifact ringOfLife = ArtifactFactory.createArtifact(artifactInfo);

        assertEquals(2, ringOfLife.getHealth());
    }

    @Test
    void factoryShouldCreateCreatureImmunityArtifact() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(PENDANT_OF_LIFE);
        Artifact pendantOfLife = ArtifactFactory.createArtifact(artifactInfo);

        assertEquals(LIGHTNING_BOLT, pendantOfLife.getSpellImmunityName());
    }

    @Test
    void factoryShouldCreateCreatureMagicResistanceArtifact() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(BOOTS_OF_POLARITY);
        Artifact bootsOfPolarity = ArtifactFactory.createArtifact(artifactInfo);

        assertEquals(15, bootsOfPolarity.getMagicResistance());
    }

    @Test
    void factoryShouldCreateCreatureSpeedArtifactBasedOnInfo() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(CAPE_OF_VELOCITY);
        Artifact capeOfVelocity = ArtifactFactory.createArtifact(artifactInfo);

        assertEquals(2, capeOfVelocity.getSpeed());
    }

    @Test
    void factoryShouldCreateHeroStatisticArtifactBasedOnInfo() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(SKULL_HELMET);
        Artifact skullHelmet = ArtifactFactory.createArtifact(artifactInfo);

        assertEquals(0, skullHelmet.getAttack());
        assertEquals(0, skullHelmet.getDefence());
        assertEquals(2, skullHelmet.getKnowledge());
        assertEquals(0, skullHelmet.getPower());
    }

    @Test
    void factoryShouldCreateSpellDurationArtifact() {
        ArtifactInfo artifactsInfo = ArtifactsInfoFactory.getArtifact(COLLAR_OF_CONJURING);
        Artifact collarOfConjuring = ArtifactFactory.createArtifact(artifactsInfo);

        assertEquals(1, collarOfConjuring.getDuration());
    }

    @Disabled // waiting for implementation of cast prevention by spells
    @Test
    void factoryShouldCreateSpellPreventCastingArtifact() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(RECANTERS_CLOAK);
        Artifact recantersCloak = ArtifactFactory.createArtifact(artifactInfo);

    }


//    AffectsHeroStats test

    @Test
    void creatureBuffArtifactShouldReturnFalse() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(RING_OF_LIFE);
        Artifact creatureBuffArtifact = ArtifactFactory.createArtifact(artifactInfo);

        assertFalse(creatureBuffArtifact.affectsHeroStats());
    }

    @Test
    void spellBuffArtifactShouldReturnFalse() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(RING_OF_CONJURING);
        Artifact spellBuffArtifact = ArtifactFactory.createArtifact(artifactInfo);

        assertFalse(spellBuffArtifact.affectsHeroStats());
    }

    @Test
    void heroStatisticArtifactShouldReturnTrue() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(ARMOR_OF_WONDER);
        Artifact heroStatisticArtifact = ArtifactFactory.createArtifact(artifactInfo);

        assertTrue(heroStatisticArtifact.affectsHeroStats());
    }


//    CreatureHealthArtifact test

    @Test
    void artifactShouldIncreaseHealthBy2Points() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(RING_OF_LIFE);
        Artifact ringOfLife = ArtifactFactory.createArtifact(artifactInfo);
        List<Creature> creatures = new ArrayList<>();
        Creature creature = Creature.builder().aMaxHp(10).build();
        creatures.add(creature);
        Hero battleHero = Hero.builder().aCreatures(creatures).build();

        try {
            ringOfLife.apply(battleHero);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(12, battleHero.getCreatures().get(0).getMaxHp());
        assertEquals(12, battleHero.getCreatures().get(0).getCurrentHp());
    }


//    CreatureImmunityArtifact test

    @Disabled // waiting for dealing spell damage
    @Test
    void artifactShouldGrantImmunityToCreature() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(PENDANT_OF_DISPASSION);
        Artifact pendantOfDispassion = ArtifactFactory.createArtifact(artifactInfo);
        List<Creature> creatures = new ArrayList<>();
        Creature creature = Creature.builder().aMaxHp(10).build();
        creatures.add(creature);
        Hero battleHero = Hero.builder().aCreatures(creatures).build();

        try {
            pendantOfDispassion.apply(battleHero);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        assert creature has immunity

    }


//    CreatureMagicResistanceArtifact tests

    @Test
    void artifactShouldIncreaseMagicResistanceBy15Percent() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(BOOTS_OF_POLARITY);
        Artifact bootsOfPolarity = ArtifactFactory.createArtifact(artifactInfo);
        List<Creature> creatures = new ArrayList<>();
        Creature creature = Creature.builder().build();
        creatures.add(creature);
        Hero battleHero = Hero.builder().aCreatures(creatures).build();

        try {
            bootsOfPolarity.apply(battleHero);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(15, battleHero.getCreatures().get(0).getMagicResistance().getAllSpellsResistancePercentage());
    }


//    CreatureSpeedArtifact tests

    @Test
    void artifactShouldIncreaseMoveRangeBy2Points() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(CAPE_OF_VELOCITY);
        Artifact capeOfVelocity = ArtifactFactory.createArtifact(artifactInfo);
        List<Creature> creatures = new ArrayList<>();
        Creature creature = Creature.builder().aMoveRange(2).build();
        creatures.add(creature);
        Hero battleHero = Hero.builder().aCreatures(creatures).build();

        try {
            capeOfVelocity.apply(battleHero);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(4, battleHero.getCreatures().get(0).getMoveRange());
    }


//    HeroStatisticArtifact tests

    @Test
    void artifactShouldIncreaseKnowledgeBy2Points() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(SKULL_HELMET);
        Artifact skullHelmet = ArtifactFactory.createArtifact(artifactInfo);
        Hero battleHero = Hero.builder().build();// default hero stats = 0

        try {
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
    void artifactShouldIncreaseAttackBy2Points() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(CENTAURS_AX);
        Artifact centaursAx = ArtifactFactory.createArtifact(artifactInfo);
        Hero battleHero = Hero.builder().build();// default hero stats = 0

        try {
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
    void artifactShouldIncreaseDefenceBy2Points() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(SHIELD_OF_THE_DWARVEN_LORDS);
        Artifact shieldOfTheDwarvenLords = ArtifactFactory.createArtifact(artifactInfo);
        Hero battleHero = Hero.builder().build();// default hero stats = 0

        try {
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

        try {
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
            armorOfWonders.apply(battleHero);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(1, battleHero.getKnowledge());
        assertEquals(1, battleHero.getAttack());
        assertEquals(1, battleHero.getDefence());
        assertEquals(1, battleHero.getPower());
    }


//    SpellDurationArtifact tests

    @Disabled // waiting for increaseDuration implementation by spells
    @Test
    void artifactShouldIncreaseSpellDurationBy2() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(RING_OF_CONJURING);
        Artifact ringOfConjuring = ArtifactFactory.createArtifact(artifactInfo);
        SpellInfo spellInfo = SpellBookInfoFactory.getSpell(HASTE);
        Hero battleHero = Hero.builder().build();
        battleHero.getSpellBook().createSpell(spellInfo);

        try {
            ringOfConjuring.apply(battleHero);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(3, battleHero.getSpellBook().getSpells().get(0).getDuration());
    }

}
