package pl.psi.game.hero.shops;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import pl.psi.game.spellbook.SpellInfo;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class shopsManagementTest {


    @BeforeAll
    static void initializeFactories() {

        new FractionsInfoAbstractFactory();
        new ArtifactsInfoFactory();
        new SpellBookInfoFactory();
    }


    @Test
    void generateItemsAvailableToBuyShouldAdd10SpellsToShop() {

        SpellShop spellShop  = new SpellShop();
        spellShop.generateItemsAvailableToBuy();
        List<SpellInfo> spellsAvailableToBuy = spellShop.getSpellsAvailableToBuy();

        assertEquals(10, spellsAvailableToBuy.size());

    }

    @Test
    void generateSpellsAvailableToBuyShouldAdd2SpellsOfEachTier() {

        SpellShop spellShop = new SpellShop();
        spellShop.generateItemsAvailableToBuy();
        List<SpellInfo> spellsAvailableToBuy = spellShop.getSpellsAvailableToBuy();

        long firstTierSpellsCount = spellsAvailableToBuy.stream().filter(spell -> spell.getLevel() == 1).count();
        long secondTierSpellsCount = spellsAvailableToBuy.stream().filter(spell -> spell.getLevel() == 2).count();
        long thirdTierSpellsCount = spellsAvailableToBuy.stream().filter(spell -> spell.getLevel() == 3).count();
        long fourthTierSpellsCount = spellsAvailableToBuy.stream().filter(spell -> spell.getLevel() == 4).count();
        long fifthTierSpellCount = spellsAvailableToBuy.stream().filter(spell -> spell.getLevel() == 5).count();


        assertEquals(firstTierSpellsCount, 2);
        assertEquals(secondTierSpellsCount, 2);
        assertEquals(thirdTierSpellsCount, 2);
        assertEquals(fourthTierSpellsCount, 2);
        assertEquals(fifthTierSpellCount, 2);

    }


    @Test
    void generateItemsAvailableToBuyShouldGenerateArtifactsInRange2To12(){

        ArtifactsShop artifactsShop = new ArtifactsShop();
        artifactsShop.generateItemsAvailableToBuy();
        List<ArtifactInfo> artifactsAvailableToBuy = artifactsShop.getArtifactsAvailableToBuy();
        assertTrue(2<=artifactsAvailableToBuy.size() && artifactsAvailableToBuy.size()<=12);
    }


    @Test
    @Disabled
    void endOfRoundShouldGenerateShopWithItems() {

        ArtifactsShop artifactsShop = new ArtifactsShop();
        CreaturesShop creaturesShop = new CreaturesShop();
        SpellShop spellShop = new SpellShop();

       /* artifactsShop.generateArtifactsAvailableToBuy();
        assertEquals(3, artifactsShop.size()); //how many items is in the shop

        creaturesShop.generateCreaturesAvailableToBuy();
        assertEquals(3, creaturesShop.size()); //how many items is in the shop

//        spellShop.generateSpellsAvailableToBuy();
        assertEquals(3, spellShop.size()); //how many items is in the shop*/

    }
}
