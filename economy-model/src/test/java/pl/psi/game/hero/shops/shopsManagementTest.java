package pl.psi.game.hero.shops;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import pl.psi.game.spellbook.SpellInfo;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class shopsManagementTest {


    @BeforeAll
    static void initializeFactories() {

        new FractionsInfoAbstractFactory();
        new ArtifactsInfoFactory();
        new SpellBookInfoFactory();
    }

    //initial sketch test generateShops()

    @Test
    void generateSpellsAvailableToBuyShouldAdd8Spells() {

        SpellShop spellShop = new SpellShop();
        spellShop.generateSpellsAvailableToBuy();
        List<SpellInfo> spellsAvailableToBuy = spellShop.getSpellsAvailableToBuy();

        assertEquals(spellsAvailableToBuy.size(),8);

    }

    @Test
    void generateSpellsAvailableToBuyShouldAdd2SpellsOfEachTier() {

        SpellShop spellShop = new SpellShop();
        spellShop.generateSpellsAvailableToBuy();
        List<SpellInfo> spellsAvailableToBuy = spellShop.getSpellsAvailableToBuy();

        long firstTierSpellsCount = spellsAvailableToBuy.stream().filter(spell -> spell.getTier() == 1).count();
        long secondTierSpellsCount = spellsAvailableToBuy.stream().filter(spell -> spell.getTier() == 2).count();
        long thirdTierSpellsCount = spellsAvailableToBuy.stream().filter(spell -> spell.getTier() == 3).count();
        long fourthTierSpellsCount = spellsAvailableToBuy.stream().filter(spell -> spell.getTier() == 4).count();


        assertEquals(firstTierSpellsCount, 2);
        assertEquals(secondTierSpellsCount, 2);
        assertEquals(thirdTierSpellsCount, 2);
        assertEquals(fourthTierSpellsCount, 2);

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
