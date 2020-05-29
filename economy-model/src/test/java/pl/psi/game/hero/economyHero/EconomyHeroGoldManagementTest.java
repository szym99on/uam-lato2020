package pl.psi.game.hero.economyHero;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.fractions.NecropolisInfoFactory;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import pl.psi.game.spellbook.SpellInfo;

import static org.junit.jupiter.api.Assertions.*;

public class EconomyHeroGoldManagementTest {

    @BeforeAll
    static void initializeFactories() {
        new SpellBookInfoFactory();
        new ArtifactsInfoFactory();
        new FractionsInfoAbstractFactory();
    }

    @Test
    void increaseGoldShouldAddGold() {
        EconomyHero hero = EconomyHero.builder().aGold(2000).build();
        int howMuch = 50;

        hero.increaseGold(howMuch);

        assertEquals(2050, hero.getGold());
    }

    @Test
    void decreaseGoldShouldRemoveGold() throws Exception {
        EconomyHero hero = EconomyHero.builder().aGold(2000).build();
        int howMuch = 50;

        hero.decreaseGold(howMuch);

        assertEquals(1950, hero.getGold());
    }

    @Test
    void decreaseGoldShouldNotRemoveGoldWhenItsNotEnoughGold() {

        EconomyHero hero = EconomyHero.builder().aGold(50).build();
        assertThrows(Exception.class, () -> {

            int howMuch = 100;
            hero.decreaseGold(howMuch);

        });
        assertEquals(50, hero.getGold());
    }

    @Test
    void decreaseGoldShouldNotAddGoldWhenItsNegative() {
        EconomyHero hero = EconomyHero.builder().aGold(2000).build();
        assertThrows(Exception.class, () -> {

            int howMuch = -100;
            hero.decreaseGold(howMuch);

        });
        assertEquals(2000, hero.getGold());
    }

    //buying 1 item

    @Test
    void buySpellShouldTakeGoldAndAddSpell() throws Exception {
        SpellInfo spell = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW);
        EconomyHero hero = EconomyHero.builder().aGold(3000).build();

        hero.buySpell(spell);

        assertEquals(2999, hero.getGold());
        assertTrue(hero.getSpells().contains(spell));
        assertEquals(hero.getSpells().size(), 1);

    }

    @Test
    void buyCreatureShouldTakeGoldAndAddCreature() throws Exception {

        FractionsInfoAbstractFactory necropolisFactory = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS);
        CreatureInfo creature = necropolisFactory.getCreature(NecropolisInfoFactory.SKELETON_WARRIOR);
        EconomyHero hero = EconomyHero.builder().aGold(1000).build();

        hero.buyCreature(creature);

        assertEquals(hero.getGold(), 930);
        assertTrue(hero.getCreatures().contains(creature));
        assertEquals(hero.getCreatures().size(), 1);
    }

    @Test
    void buyArtifactShouldTakeGoldAndAddArtifact() throws Exception {
        ArtifactInfo artifact = ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.COLLAR_OF_CONJURING);
        EconomyHero hero = EconomyHero.builder().aGold(2000).build();

        hero.buyArtifact(artifact);
        assertEquals(1500, hero.getGold());
        assertEquals(hero.getArtifact(artifact.getName()), artifact);
        assertEquals(hero.getArtifacts().size(), 1);

    }

    //buy more than 1 item

    @Test
    void buyFewItemsShouldTakeGoldAndAddItems() throws Exception {
        EconomyHero hero = EconomyHero.builder().aGold(5000).build();
        ArtifactInfo artifact = ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.ARMOR_OF_WONDER);
        SpellInfo spell = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW);
        FractionsInfoAbstractFactory necropolisFactory = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS);
        CreatureInfo creature = necropolisFactory.getCreature(NecropolisInfoFactory.POWER_LICH);

        hero.buyArtifact(artifact);
        hero.buySpell(spell);
        hero.buyCreature(creature);
        assertEquals(399,hero.getGold());
        /*assertTrue(hero.getSpells().contains(spell));
        assertEquals(hero.getSpells().size(), 1);
        assertTrue(hero.getCreatures().contains(creature));
        assertEquals(hero.getCreatures().size(), 1);
        assertEquals(hero.getArtifact(artifact.getName()), artifact);
        assertEquals(hero.getArtifacts().size(), 1);*/
    }
    @Test
    void buyFewItemsShouldTakeGoldOnlyForItemsHeroCanAfford() throws Exception{
        EconomyHero hero = EconomyHero.builder().aGold(6000).build();
        ArtifactInfo artifact = ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.ARMOR_OF_WONDER);
        FractionsInfoAbstractFactory necropolisFactory = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS);
        CreatureInfo creature = necropolisFactory.getCreature(NecropolisInfoFactory.DREAD_KNIGHT);
        CreatureInfo creature2 = necropolisFactory.getCreature(NecropolisInfoFactory.POWER_LICH);
        hero.buyArtifact(artifact);
        hero.buyCreature(creature);
        assertThrows(Exception.class, () -> {


            hero.buyCreature(creature2);

        });

        assertEquals(500, hero.getGold());

    }

    //selling items
    @Test
    void sellSkeletonWarriorShouldReturn75PercentOfOriginalPrice() throws Exception {
        FractionsInfoAbstractFactory necropolisFactory =  FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS);
        CreatureInfo creature = necropolisFactory.getCreature(NecropolisInfoFactory.SKELETON_WARRIOR);
        EconomyHero hero = EconomyHero.builder().aGold(2000).build();
        hero.addCreature(creature);

        hero.sellCreature(creature);

        assertEquals(hero.getGold(), 2052);
        assertFalse(hero.getCreatures().contains(creature));
        assertEquals(hero.getCreatures().size(), 0);
    }
    @Test
    void sellDreadKnightShouldReturn75PercentOfOriginalPrice() throws Exception {
        FractionsInfoAbstractFactory necropolisFactory =  FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS);
        CreatureInfo creature = necropolisFactory.getCreature(NecropolisInfoFactory.DREAD_KNIGHT);
        EconomyHero hero = EconomyHero.builder().aGold(2000).build();
        hero.addCreature(creature);

        hero.sellCreature(creature);

        assertEquals(hero.getGold(), 3125);
        assertFalse(hero.getCreatures().contains(creature));
        assertEquals(hero.getCreatures().size(), 0);

    }
    @Test
    void sellArtifactShouldReturn75PercentOfOriginalPriceAndRemoveArtifact() throws Exception {
        ArtifactInfo artifact = ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.HELM_OF_THE_ALABASTER_UNICORN);
        EconomyHero hero = EconomyHero.builder().aGold(2000).build();
        hero.addArtifact(artifact);


        hero.sellArtifact(artifact);


        assertEquals(hero.getGold(), 2750);
        assertFalse(hero.getArtifacts().contains(artifact));
        assertEquals(hero.getArtifacts().size(), 0);

    }
    @Test
    void sellSpellShouldReturn75PercentOfOriginalPriceAndRemoveSpell() throws Exception {
        SpellInfo spell = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW);
        EconomyHero hero = EconomyHero.builder().aGold(2000).build();
        hero.addSpell(spell);

        hero.sellSpell(spell);

        assertEquals(hero.getGold(), 2000);
        assertFalse(hero.getSpells().contains(spell));
        assertEquals(hero.getSpells().size(),0);
    }



    @Test
    void sellMoreThanOneItemShouldReturnEach75PercentOfOriginalPriceAmdRemoveItem() throws Exception{
        FractionsInfoAbstractFactory necropolisFactory =  FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS);
        CreatureInfo creature = necropolisFactory.getCreature(NecropolisInfoFactory.DREAD_KNIGHT);
        SpellInfo spell = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW);
        ArtifactInfo artifact = ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.HELM_OF_THE_ALABASTER_UNICORN);
        EconomyHero hero = EconomyHero.builder().aGold(100).build();

        hero.addSpell(spell);
        hero.addArtifact(artifact);
        hero.addCreature(creature);

        hero.sellArtifact(artifact);
        hero.sellCreature(creature);
        hero.sellSpell(spell);

        assertEquals(1975, hero.getGold());

       /* assertFalse(hero.getCreatures().contains(creature));
        assertEquals(hero.getCreatures().size(), 0);
        assertFalse(hero.getArtifacts().contains(artifact));
        assertEquals(hero.getArtifacts().size(), 0);
        assertFalse(hero.getSpells().contains(spell));
        assertEquals(hero.getSpells().size(),0);*/

    }

    //end of round

    @Test
    @Disabled
    void endTheRoundShouldAddGoldToHero(){
        EconomyHero hero = EconomyHero.builder().aGold(100).build();
        //endRound(hero,1); //hero end the first round(?)
        //end 1 Round should add 500 gold (?)
        assertEquals(600,hero.getGold());


    }


}
