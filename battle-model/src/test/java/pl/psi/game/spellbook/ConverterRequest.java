package pl.psi.game.spellbook;

import org.junit.jupiter.api.Test;
import pl.psi.game.hero.converter.Hero;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterRequest {

    /*@Test
    void SpellBookNeedSetManaMethod() {
        Hero hero = Hero.builder().build();
        hero.increaseKnowledge(1);
        hero.setMana();
        //in hero --- spellBook.setMana(knowledge*10);
    }*/
    /*@Test
    void SpellBookNeedIncreaseDurationMethod() {
        Hero hero = Hero.builder().build();
        hero.increaseDuration(1);
        //in hero --- spellBook.increaseDuration(aAmount);
    }*/
    /*@Test
    void SpellBookNeedAddSpellsMethod() {
        Hero hero = Hero.builder().build();
        List<Spell> spells = new ArrayList<>();
        SpellFactory spellFactory = new SpellFactory();
        spells.add(spellFactory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW)));
        spells.add(spellFactory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.HASTE)));
        hero.addSpells(spells);
        //in hero --- spellBook.addSpells(aSpells);
    }*/

    //for convert test not important
    /*@Test
    void SpellBookNeedOverrideEqual()
    {
        SpellInfo spellInfo = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW);
        SpellFactory spellFactory = new SpellFactory();
        Spell spell1 = spellFactory.createSpell(spellInfo);
        Spell spell2 = spellFactory.createSpell(spellInfo);
        Hero hero = Hero.builder().build();
        List<Spell> spells = new ArrayList<>();
        spells.add(spell2);
        hero.addSpells(spells);
        assertEquals(spell1,hero.getSpellBook().getSpells().get(0));
    }*/
}
