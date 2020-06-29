package pl.psi.game.hero.artifacts;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.psi.game.artifacts.Artifact;
import pl.psi.game.artifacts.ArtifactFactory;
import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.spellbook.Spell;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import pl.psi.game.spellbook.SpellFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.*;
import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.CAPE_OF_VELOCITY;
import static pl.psi.game.spellbook.SpellBookInfoFactory.LIGHTNING_BOLT;

public class CreatureBuffArtifactTest {
    @BeforeAll
    static void initializeFactories() {
        new ArtifactsInfoFactory();
        new ArtifactFactory();
        new SpellBookInfoFactory();
    }
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
}
