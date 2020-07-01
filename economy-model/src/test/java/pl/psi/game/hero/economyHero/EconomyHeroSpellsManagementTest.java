package pl.psi.game.hero.economyHero;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import pl.psi.game.spellbook.SpellInfo;

import static org.junit.jupiter.api.Assertions.*;

public class EconomyHeroSpellsManagementTest {

    @BeforeAll
    static void initializeFactories(){
        new SpellBookInfoFactory();
    }

    @Test
    void buyMagicArrowShouldTakeGoldAndAddSpell() throws IllegalStateException {
        SpellInfo spellInfo = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW);
        EconomyHero hero = EconomyHero.builder().aGold(3000).build();

        hero.buySpell(spellInfo);

        assertEquals(hero.getGold(), 2940);
        assertTrue(hero.getSpells().contains(spellInfo));
        assertEquals(hero.getSpells().size(), 1);
    }

    @Test
    void buyLightningBoltShouldTakeGoldAndAddSpell() throws IllegalStateException {
        SpellInfo spellInfo = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.LIGHTNING_BOLT);
        EconomyHero hero = EconomyHero.builder().aGold(100).build();

        hero.buySpell(spellInfo);

        assertEquals(hero.getGold(),0);
        assertTrue(hero.getSpells().contains(spellInfo));
        assertEquals(hero.getSpells().size(),1);
    }

    @Test
    void buyStormElementalShouldTakeGoldAndAddSpell() throws IllegalStateException {
        SpellInfo spellInfo = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.STORM_ELEMENTAL);
        EconomyHero hero = EconomyHero.builder().aGold(700).build();

        hero.buySpell(spellInfo);

        assertEquals(hero.getGold(),0);
        assertTrue(hero.getSpells().contains(spellInfo));
        assertEquals(hero.getSpells().size(),1);
    }

    @Test
    void buyTwoSpellsShouldTakeGoldAndAddTwoSpells() throws IllegalStateException {
        SpellInfo spell_one = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.HASTE);
        SpellInfo spell_two = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW);
        EconomyHero hero = EconomyHero.builder().aGold(500).build();

        hero.buySpell(spell_one);
        hero.buySpell(spell_two);

        assertEquals(hero.getGold(),140);
        assertTrue(hero.getSpells().contains(spell_one));
        assertTrue(hero.getSpells().contains(spell_two));
        assertEquals(hero.getSpells().size(),2);
    }

    @Test
    void buyTwoSpellsShouldTakeGoldAndAddSpellForTwoSpells() throws IllegalStateException {
        SpellInfo spell_one = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.STORM_ELEMENTAL);
        SpellInfo spell_two = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.LIGHTNING_BOLT);
        EconomyHero hero = EconomyHero.builder().aGold(1000).build();

        hero.buySpell(spell_one);
        hero.buySpell(spell_two);

        assertEquals(hero.getGold(),200);
        assertTrue(hero.getSpells().contains(spell_one));
        assertTrue(hero.getSpells().contains(spell_two));
        assertEquals(hero.getSpells().size(),2);
    }

    @Test
    void sellSpellShouldReturn75PercentOfOriginalPriceAndRemoveSpell_1() throws IllegalStateException {
        SpellInfo spell = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW);
        EconomyHero hero = EconomyHero.builder().aGold(2000).build();
        hero.addSpell(spell);

        hero.sellSpell(spell);

        assertEquals(hero.getGold(), 2045);
        assertFalse(hero.getSpells().contains(spell));
        assertEquals(hero.getSpells().size(),0);
    }

    @Disabled
    @Test
    void sellSpellShouldReturn75PercentOfOriginalPriceAndRemoveSpell_2() throws IllegalStateException {
        SpellInfo spell = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.HASTE);
        EconomyHero hero = EconomyHero.builder().aGold(2000).build();
        hero.addSpell(spell);

        hero.sellSpell(spell);

        assertEquals(hero.getGold(), 2075); //wait for change spell costs
        assertFalse(hero.getSpells().contains(spell));
        assertEquals(hero.getSpells().size(),0);
    }

    @Disabled
    @Test
    void sellSpellShouldReturn75PercentOfOriginalPriceAndRemoveSpellForMoreThanOneSpell_1() throws IllegalStateException{

        SpellInfo spell_one = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.HASTE);
        SpellInfo spell_two = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW);
        EconomyHero hero = EconomyHero.builder().aGold(2000).build();

        hero.addSpell(spell_one);
        hero.addSpell(spell_two);

        assertEquals(hero.getSpells().size(),2);

        hero.sellSpell(spell_one);
        hero.sellSpell(spell_two);

        assertEquals(hero.getGold(), 2075); //wait for change spell costs
        assertFalse(hero.getSpells().contains(spell_one));
        assertFalse(hero.getSpells().contains(spell_two));
        assertEquals(hero.getSpells().size(),0);
    }




}
