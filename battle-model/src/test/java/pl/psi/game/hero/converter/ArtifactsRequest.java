package pl.psi.game.hero.converter;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.Creature;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.spellbook.Spell;
import pl.psi.game.spellbook.SpellBookInfoFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArtifactsRequest {

    @Disabled
    @Test
    void shouldIncreaseKnowledge(){
//        Hero hero = Hero.builder().aKnowledge(1).build();

//        hero.increaseKnowledge(5);

//        assertEquals(6, hero.getKnowledge());
    }


    @Disabled
    @Test
    void shouldReturnHerosPrimarySkills(){
//        Hero hero = Hero.builder().aAttack(3).aDefence(4).aSpellPower(2).aKnowledge(5).build();

//        assertEquals(3, hero.getAttack());
//        assertEquals(4, hero.getDefence());
//        assertEquals(2, hero.getSpellPower());
//        assertEquals(5, hero.getKnowledge());
    }

    @Disabled
    @Test
    void shouldReturnHerosSpellsList() {
//        Spell s1 = Spell.builder().aTier(1).build();
//        Spell s2 = Spell.builder().aTier(2).build();
        List<Spell> spells = new ArrayList<>();
//        spells.add(s1);
//        spells.add(s2);

//        Hero hero = new Hero(spells);


        List< Spell > expected = new ArrayList<>();
//        expected.add(s1);
//        expected.add(s2);

//        assertEquals(expected, hero.getSpells());
    }

    @Disabled
    @Test
    void shouldReturnHerosCreaturesList() {
        Creature c1 = Creature.builder().aName("Skeleton").build();
        Creature c2 = Creature.builder().aName("Zombie").build();
        List<Creature> creatures = new ArrayList<>();
        creatures.add(c1);
        creatures.add(c2);

        Hero hero = new Hero(creatures);

        List<Creature> expected = new ArrayList<>();
        expected.add(c1);
        expected.add(c2);

        assertEquals(expected, hero.getCreatures());
    }


}
