package pl.psi.game.hero.artifacts;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.artifacts.Artifact;
import pl.psi.game.artifacts.ArtifactFactory;
import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.spellbook.Spell;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import pl.psi.game.spellbook.SpellFactory;
import pl.psi.game.spellbook.SpellInfo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pl.psi.game.artifacts.Artifact.*;
import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.*;
import static pl.psi.game.spellbook.SpellBookInfoFactory.*;

public class ArtifactTest {
    @BeforeAll
    static void initializeFactories() {
        new ArtifactsInfoFactory();
        new ArtifactFactory();
        new SpellBookInfoFactory();
    }

//  ArtifactFactory tests

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

//  CreatureHealthArtifact test

    @Test
    void artifactShouldIncreaseHealthBy2Points() {
        //given
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(RING_OF_LIFE);
        Artifact ringOfLife = ArtifactFactory.createArtifact(artifactInfo);

        List<Creature> creatures = new ArrayList<>();
        Creature creature = Creature.builder().aMaxHp(10).build();
        creatures.add(creature);
        Hero battleHero = Hero.builder().aCreatures(creatures).build();

        //when
        try {
            ringOfLife.apply(battleHero);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //then
        assertEquals(12, battleHero.getCreatures().get(0).getMaxHp());
    }


//  CreatureImmunityArtifact test

    @Test
    void artifactShouldGrantImmunityToSpellToCreature() {
        //given
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(PENDANT_OF_LIFE);
        Artifact pendantOfDispassion = ArtifactFactory.createArtifact(artifactInfo);

        List<Creature> creatures = new ArrayList<>();
        Creature creature = Creature.builder().aMaxHp(10).build();
        creatures.add(creature);
        Hero battleHero = Hero.builder().aCreatures(creatures).build();

        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.LIGHTNING_BOLT));

        //when
        try {
            pendantOfDispassion.apply(battleHero);
        } catch (Exception e) {
            e.printStackTrace();
        }
        spell.cast(creature);

        //then
        assertTrue(creature.getMagicResistance().isImmuneToSpell(LIGHTNING_BOLT));
        assertEquals(10, creature.getCurrentHp());
    }


//  CreatureMagicResistanceArtifact tests

    @Test
    void artifactShouldIncreaseMagicResistanceBy15Percent() {
        //given
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(BOOTS_OF_POLARITY);
        Artifact bootsOfPolarity = ArtifactFactory.createArtifact(artifactInfo);

        List<Creature> creatures = new ArrayList<>();
        Creature creature1 = Creature.builder().aMaxHp(1000).build();
        Creature creature2 = Creature.builder().aMaxHp(1000).build();
        creatures.add(creature1);
        Hero battleHero = Hero.builder().aCreatures(creatures).build();

        //when
        try {
            bootsOfPolarity.apply(battleHero);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.LIGHTNING_BOLT));
        spell.cast(creature1);
        spell.cast(creature2);

        //then
        assertEquals(15, creature1.getMagicResistance().getAllSpellsResistancePercentage());
        assertEquals(971, creature1.getCurrentHp());
        assertEquals(965, creature2.getCurrentHp());
    }


//  CreatureSpeedArtifact tests

    @Test
    void artifactShouldIncreaseMoveRangeBy2Points() {
        //given
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(CAPE_OF_VELOCITY);
        Artifact capeOfVelocity = ArtifactFactory.createArtifact(artifactInfo);

        List<Creature> creatures = new ArrayList<>();
        Creature creature = Creature.builder().aMoveRange(2).build();
        creatures.add(creature);
        Hero battleHero = Hero.builder().aCreatures(creatures).build();

        //when
        try {
            capeOfVelocity.apply(battleHero);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //then
        assertEquals(4, battleHero.getCreatures().get(0).getMoveRange());
    }


//  HeroStatisticArtifact tests

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


//  SpellDurationArtifact tests

    @Test
    void artifactShouldIncreaseSpellDurationBy2() {
        //given
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(RING_OF_CONJURING);
        Artifact ringOfConjuring = ArtifactFactory.createArtifact(artifactInfo);

        SpellInfo spellInfo = SpellBookInfoFactory.getSpell(HASTE);
        Hero battleHero = Hero.builder().build();
        battleHero.getSpellBook().createSpell(spellInfo);

        //when
        try {
            ringOfConjuring.apply(battleHero);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //then
        assertEquals(3, battleHero.getSpellBook().getSpells().get(0).getDuration());
    }

//  AffectsHeroStats test

    @Test
    void creatureBuffArtifactShouldNotAffectHeroStats() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(RING_OF_LIFE);
        Artifact creatureBuffArtifact = ArtifactFactory.createArtifact(artifactInfo);

        assertFalse(creatureBuffArtifact.affectsHeroStats());
    }

    @Test
    void spellBuffArtifactShouldNotAffectHeroStats() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(RING_OF_CONJURING);
        Artifact spellBuffArtifact = ArtifactFactory.createArtifact(artifactInfo);

        assertFalse(spellBuffArtifact.affectsHeroStats());
    }

    @Test
    void heroStatisticArtifactShouldAffectHeroStats() {
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(ARMOR_OF_WONDER);
        Artifact heroStatisticArtifact = ArtifactFactory.createArtifact(artifactInfo);

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
}
