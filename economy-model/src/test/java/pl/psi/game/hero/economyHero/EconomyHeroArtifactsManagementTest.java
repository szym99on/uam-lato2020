package pl.psi.game.hero.economyHero;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.spellbook.SpellBookInfoFactory;

import static org.junit.jupiter.api.Assertions.*;

public class EconomyHeroArtifactsManagementTest {



    @BeforeAll
    static void initializeFactories(){
        new ArtifactsInfoFactory();
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


    @Test
    void shouldReturnArtifactByLocation() throws Exception {
        EconomyHero hero = EconomyHero.builder().aGold(3000).build();
        ArtifactInfo artifact = ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.CAPE_OF_CONJURING);
        hero.buyArtifact(artifact);

        assertEquals(artifact, hero.getArtifactByLocation(ArtifactInfo.Location.SHOULDERS));
    }



}
