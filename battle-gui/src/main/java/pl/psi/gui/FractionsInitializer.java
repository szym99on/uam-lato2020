package pl.psi.gui;

import pl.psi.game.fractions.CreatureAbstractFactory;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.hero.HeroInfoFactory;
import pl.psi.game.hero.economyHero.EconomyHero;

public class FractionsInitializer extends AbstractInitializer {
    @Override
    EconomyHero getH1() {
        EconomyHero h1 = EconomyHero.builder().aGold(1000).aHeroInfo(HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.SHIVA)).build();
        try {
            h1.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.STRONGHOLD).getCreatureByTier(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return h1;
    }

    @Override
    EconomyHero getH2() {
        EconomyHero h2 = EconomyHero.builder().aGold(1000).aHeroInfo(HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.CRAG_HACK)).build();
        try {
            h2.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.STRONGHOLD).getCreatureByTier(2));
            h2.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.STRONGHOLD).getCreatureByTier(3));
            h2.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.STRONGHOLD).getCreatureByTier(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return h2;
    }
}
