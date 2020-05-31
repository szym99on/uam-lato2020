package pl.psi.game.spellbook;

import org.junit.jupiter.api.Test;
import pl.psi.game.hero.converter.Hero;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterRequest {

    /*@Test
    void SpellBookContainSpells()
    {
        SpellFactory spellFactory = new SpellFactory();
        List<Spell> spells = new ArrayList<Spell>();
        spells.add(spellFactory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW)));
        Hero hero = Hero.builder().aSpells(spells).build();
        SpellBook spellBook = new SpellBook(hero.getPower(),hero.getKnowledge()*10,spells);
        assertEquals(spellBook.getSpells(),hero.getSpells());
    }*/
}
