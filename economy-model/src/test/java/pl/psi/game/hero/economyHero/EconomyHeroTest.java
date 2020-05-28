package pl.psi.game.hero.economyHero;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.fractions.NecropolisInfoFactory;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.hero.economyHero.EconomyHero;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import pl.psi.game.spellbook.SpellInfo;

import static org.junit.jupiter.api.Assertions.*;

class EconomyHeroTest {

    @BeforeAll
    static void initializeFactories(){
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
    @Test
    void  buyArtifactShouldAddArtifactIfLocationEmpty() throws Exception {
        ArtifactInfo artifact = ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.COLLAR_OF_CONJURING);
        EconomyHero hero = EconomyHero.builder().aGold(2000).build();

        hero.buyArtifact(artifact);

        assertEquals(hero.getArtifact(artifact.getName()),artifact);
        assertEquals(hero.getArtifacts().size(),1);

    }



//PW
    //You have tons methods to test!
    //First of all create more than one test class like HeroEconomyGoldManagementTest, HeroEconomyArtifactInteractionTest, HeroEconomySpellIntegrationTest etc.
    // in this class make list of method e.g.
    // gold management:
    // add gold to hero
    // buy some item (correcting counting gold) -> what if stay 0, what if stay -1
    // sell some item and check gold state
    // artifacts:
    // buy some artifact (don't count gold you will have it in another test).
    // check if exists in correct location
    // buy 2 artifact to the same location - throw exception like IllegalStateException
    // buy, sell, and buy to the same location and all should looks fine
    // buy, sell and check that location is empty

    // I cannot read these tests with pleasure. You have horrible mess here. Please don't use comment too much. You can make empty implementation and user @Disable annotate.
}
