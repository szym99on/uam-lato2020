package pl.psi.gui;

import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.hero.HeroInfoFactory;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.hero.economyHero.EconomyHero;
import pl.psi.game.spellbook.SpellBookInfoFactory;

import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.CAPE_OF_VELOCITY;
import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.RING_OF_LIFE;

public class SpellInitializer extends AbstractInitializer{
    EconomyHero getH1() {
        EconomyHero h1 = EconomyHero.builder().aGold(100000000).aHeroInfo(HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.EDRIC)).build();
        try {

            h1.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(1),1);
            h1.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(1),1);
            h1.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(7),1);
            h1.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(7),1);

//            h1.buySpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW));
//            h1.buySpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.LIGHTNING_BOLT));
//            h1.buySpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.DESTROY_UNDEAD));
//            h1.buySpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.FIRE_BALL));
            h1.buySpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.METEOR_SHOWER));
            h1.buySpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.IMPLOSION));
//            h1.buySpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.HASTE));
//            h1.buySpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.AIR_SHIELD));
//            h1.buySpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.BLOODLUST));
//            h1.buySpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.FIRE_SHIELD));
//            h1.buySpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.SLOW));
//            h1.buySpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.STONESKIN));
            h1.buySpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.WEAKNESS));
            h1.buySpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.PRAYER));
//            h1.buySpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.STORM_ELEMENTAL));
//            h1.buySpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.ENERGY_ELEMENTAL));
            h1.buySpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGMA_ELEMENTAL));
            h1.buySpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.ICE_ELEMENTAL));
        } catch (Exception aE) {
            aE.printStackTrace();
        }

        return h1;
    }

    EconomyHero getH2() {
        EconomyHero h2 = EconomyHero.builder().aGold(100000000).aHeroInfo(HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.ALAMAR)).build();
        try {

            h2.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(1),1);
            h2.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(1),1);
            h2.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(7),1);
            h2.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(7),1);
            h2.buySpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.ICE_ELEMENTAL));
            h2.buySpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.ENERGY_ELEMENTAL));
            h2.buySpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.PRAYER));
            h2.buySpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.METEOR_SHOWER));
//            h2.buySpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.BLOODLUST));

        } catch (Exception aE) {
            aE.printStackTrace();
        }
        return h2;
    }
}
