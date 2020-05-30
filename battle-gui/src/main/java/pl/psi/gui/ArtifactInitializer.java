package pl.psi.gui;

import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.hero.HeroInfoFactory;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.hero.economyHero.EconomyHero;

public class ArtifactInitializer extends AbstractInitializer {

    EconomyHero getH1() {
        EconomyHero h1 = EconomyHero.builder().aGold(100000000).aHeroInfo(HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.EDRIC)).build();
        try {
            h1.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(1));
            h1.buyArtifact(ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.BOOTS_OF_POLARITY));
        } catch (Exception aE) {
            aE.printStackTrace();
        }
        return h1;
    }

    EconomyHero getH2() {
        EconomyHero h2 = EconomyHero.builder().aGold(100000000).aHeroInfo(HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.ALAMAR)).build();
        try {
            h2.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.RAMPART).getCreatureByTier(1));
        } catch (Exception aE) {
        }
        return h2;
    }
}
