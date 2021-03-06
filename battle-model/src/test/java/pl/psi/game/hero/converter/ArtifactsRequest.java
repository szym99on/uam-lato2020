package pl.psi.game.hero.converter;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.HeroInfo;
import pl.psi.game.hero.HeroInfoFactory;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.hero.economyHero.EconomyHero;
import pl.psi.game.spellbook.Spell;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import pl.psi.game.spellbook.SpellFactory;
import pl.psi.game.spellbook.SpellInfo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArtifactsRequest {

    @Test
    void shouldIncreaseAttack(){
        Hero hero = Hero.builder().build();//(0,0,0,0) brak konwersji z economy
        hero.increaseAttack(5);
        assertEquals(5, hero.getAttack());
    }
    @Test
    void shouldIncreaseDefence(){
        Hero hero = Hero.builder().build();
        hero.increaseDefence(5);
        assertEquals(5, hero.getDefence());
    }
    @Test
    void shouldIncreaseSpellPower(){
        Hero hero = Hero.builder().build();
        hero.increasePower(5);
        assertEquals(5, hero.getPower());
    }
    @Test
    void shouldIncreaseKnowledge(){
        Hero hero = Hero.builder().build();
        hero.increaseKnowledge(5);
        assertEquals(5, hero.getKnowledge());
    }

    EconomyHero prepareEconomyHeroWithKnowledgeCreaturesAndSpellsToConvert(){
        Creature creature = Creature.builder().aMaxHp(10).build();
        List <Creature> creatures = new ArrayList<>();
        creatures.add(creature);
        SpellInfo spellInfo = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.FIRE_BALL);
        SpellFactory factory = new SpellFactory();
        Spell spell = factory.createSpell(spellInfo);
        List <Spell> spells = new ArrayList<>();
        spells.add(spell);
        EconomyHero heroToConvert = null; //= EconomyHero.builder().aKnowledge(2).aCreatures(creatures).aSpells(spell).build();
        return heroToConvert;
    }

    @Disabled
    @Test
    void shouldApplyArtifactsEffectsOnConversion(){
        EconomyHero ecoHero = prepareEconomyHeroWithKnowledgeCreaturesAndSpellsToConvert();
        ArtifactInfo artifactAffectingStats = ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.SKULL_HELMET);
        ArtifactInfo artifactAffectingSpells = ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.CAPE_OF_CONJURING);
        ArtifactInfo artifactAffectingCreatures = ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.RING_OF_VITALITY);
//        ecoHero.equip(artifactAffectingStats);
//        ecoHero.equip(artifactAffectingSpells);
//        ecoHero.equip(artifactAffectingCreatures);

        HeroEcoBattleConverter converter = new HeroEcoBattleConverter();
//        Hero battleHero = converter.convertEconomyHeroToBattleHero(EcoHero);

//        assertEquals(4,battleHero.getKnowledge());
//        assertEquals(7,battleHero.getSpells().equals(spell).getDuration());
//        assertEquals(11,battleHero.getCreatures().equals(creature).getMaxHP());

    }

    @Disabled
    @Test
    void shouldReturnHerosSpellsList() {// get spells now from spellbook
        SpellInfo info1 = SpellBookInfoFactory.getSpellsByLevel(1).get(0);
        SpellInfo info2 = SpellBookInfoFactory.getSpellsByLevel(2).get(0);
        SpellFactory factory = new SpellFactory();
        Spell s1 = factory.createSpell(info1);
        Spell s2 = factory.createSpell(info2);
        List<Spell> spells = new ArrayList<>();
        spells.add(s1);
        spells.add(s2);

        Hero hero = Hero.builder().build();
        hero.getSpellBook().createSpell(info1);
        hero.getSpellBook().createSpell(info2);

        List< Spell > expected = new ArrayList<>();
        expected.add(s1);
        expected.add(s2);

        assertEquals(expected, hero.getSpellBook().getSpells());
    }

    @Disabled
    @Test
    void shouldReturnHerosCreaturesList() {
        Creature c1 = Creature.builder().aName("Skeleton").build();
        Creature c2 = Creature.builder().aName("Zombie").build();
        List<Creature> creatures = new ArrayList<>();
        creatures.add(c1);
        creatures.add(c2);

        Hero hero = Hero.builder().aCreatures(creatures).build();

        List<Creature> expected = new ArrayList<>();
        expected.add(c1);
        expected.add(c2);

        assertEquals(expected, hero.getCreatures());
    }


}
