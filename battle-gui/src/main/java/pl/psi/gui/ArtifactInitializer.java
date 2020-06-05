package pl.psi.gui;

import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.hero.HeroInfoFactory;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.hero.economyHero.EconomyHero;

public class ArtifactInitializer extends AbstractInitializer {
    // gui is not refreshing, something is wrong and after some rounds the whole thing looks like a mess
    // movement needs to fix their stuff
    // air units can move but stuff above makes it impossible to check anything
    // units can't move directly to their right or left nor can they move directly above or underneath their position
    // welp, we have to wait ¯\_(ツ)_/¯


    EconomyHero getH1() {
        EconomyHero h1 = EconomyHero.builder().aGold(100000000).aHeroInfo(HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.EDRIC)).build();
        try {
//            ################################################################
//            SCENARIO 1
//            ################################################################
            h1.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(7));
            h1.buyArtifact(ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.BOOTS_OF_POLARITY));
        } catch (Exception aE) {
            aE.printStackTrace();
        }
        return h1;
    }

    EconomyHero getH2() {
        EconomyHero h2 = EconomyHero.builder().aGold(100000000).aHeroInfo(HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.ALAMAR)).build();
        try {
//            ################################################################
//            SCENARIO 1
//            ################################################################
            h2.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.RAMPART).getCreatureByTier(7));
        } catch (Exception aE) {
        }
        return h2;
    }
}
