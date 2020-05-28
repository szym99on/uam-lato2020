package pl.psi.game.hero.economyHero;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.shops.ArtifactsShop;
import pl.psi.game.shops.CreaturesShop;
import pl.psi.game.shops.SpellShop;
import pl.psi.game.spellbook.SpellBookInfoFactory;

import static org.junit.jupiter.api.Assertions.*;

class EconomyHeroTest {

    @BeforeAll
    static void initializeFactories() {
        new SpellBookInfoFactory();
        new ArtifactsInfoFactory();
        new FractionsInfoAbstractFactory();
    }


    @Test
    void buyArtifactShouldNotAddArtifactIfSlotAlreadyTaken() throws Exception {

        assertThrows(Exception.class, () -> {
            ArtifactInfo artifact = ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.CAPE_OF_CONJURING);
            EconomyHero hero = EconomyHero.builder().aGold(2000).build();

            hero.buyArtifact(artifact);
            hero.buyArtifact(artifact);
        });
    }


    //initial sketch test generateShops()



    @Test
    @Disabled
    void endOfRoundShouldGenerateShopWithItems() {

        ArtifactsShop artifactsShop = new ArtifactsShop();
        CreaturesShop creaturesShop = new CreaturesShop();
        SpellShop spellShop = new SpellShop();

       /* artifactsShop.add(generateArtifactsAvailableToBuy());
        assertEquals(3, artifactsShop.size()); //how many items is in the shop

        creaturesShop.add(generateCreaturesAvailableToBuy());
        assertEquals(3, creaturesShop.size()); //how many items is in the shop

        spellShop.add(generateSpellsAvailableToBuy());
        assertEquals(3, spellShop.size()); //how many items is in the shop*/

    }
}


//PW
//You have tons methods to test!
//First of all create more than one test class like HeroEconomyGoldManagementTest, HeroEconomyArtifactInteractionTest, HeroEconomySpellIntegrationTest etc.
// in this class make list of method e.g.
// gold management: - done KM
// add gold to hero  - done KM
// buy some item (correcting counting gold) -> what if stay 0, what if stay -1 - done KM
// sell some item and check gold state - done KM
// artifacts:
// buy some artifact (don't count gold you will have it in another test).
// check if exists in correct location
// buy 2 artifact to the same location - throw exception like IllegalStateException
// buy, sell, and buy to the same location and all should looks fine
// buy, sell and check that location is empty

// I cannot read these tests with pleasure. You have horrible mess here. Please don't use comment too much. You can make
// empty implementation and user @Disable annotate.

