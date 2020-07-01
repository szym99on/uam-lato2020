package pl.psi.gui;

import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.hero.HeroInfoFactory;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.hero.economyHero.EconomyHero;
import pl.psi.game.spellbook.SpellBookInfoFactory;

import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.*;
import static pl.psi.game.spellbook.SpellBookInfoFactory.*;

public class ArtifactInitializer extends AbstractInitializer {

    ArtifactInitializer()
    {
        new ArtifactsInfoFactory();
    }

//    EconomyHero getH1() {
//        EconomyHero h1 = EconomyHero.builder().aGold(100000000).aHeroInfo(HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.EDRIC)).build();
//        try {
//            //            ################################################################
////            SCENARIO 1 - HeroStatisticArtifact
////            ################################################################
////            h1.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.RAMPART).getCreatureByTier(1), 100);
////            h1.buyArtifact(ArtifactsInfoFactory.getArtifact(HELM_OF_THE_ALABASTER_UNICORN)); //+1 knowledge
////            h1.buyArtifact(ArtifactsInfoFactory.getArtifact(MAGISTERS_SANDALS)); //+2 spell power
////            h1.buyArtifact(ArtifactsInfoFactory.getArtifact(OGRES_CLUB_OF_HAVOC)); //+5 attack
////            h1.buySpell(SpellBookInfoFactory.getSpell(MAGIC_ARROW));
//
////            ################################################################
////            SCENARIO 3 - SpellBuffArtifact (SpellDurationArtifact) (+3)
////            ################################################################
////            h1.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.RAMPART).getCreatureByTier(3), 10);
////            h1.buyArtifact(ArtifactsInfoFactory.getArtifact(RING_OF_CONJURING)); //+3
////            h1.buySpell(SpellBookInfoFactory.getSpell(HASTE));
//
//
//
//        } catch (Exception aE) {
//            aE.printStackTrace();
//        }
//        return h1;
//    }
//
//    EconomyHero getH2() {
//        EconomyHero h2 = EconomyHero.builder().aGold(100000000).aHeroInfo(HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.EDRIC)).build();
//        try {
////            ################################################################
////            SCENARIO 1
////            ################################################################
//            h2.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.RAMPART).getCreatureByTier(1), 100);
//            h2.buySpell(SpellBookInfoFactory.getSpell(MAGIC_ARROW));
//
////            ################################################################
////            SCENARIO 3
////            ################################################################
////            h2.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.RAMPART).getCreatureByTier(3),10);
////            h2.buySpell(SpellBookInfoFactory.getSpell(HASTE));
//
//        } catch (Exception aE) {
//            aE.printStackTrace();
//        }
//        return h2;
//    }

    EconomyHero getH1() {
        EconomyHero h1 = EconomyHero.builder().aGold(100000000).aHeroInfo(HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.BRISSA)).build();
        try {
//            ################################################################
//            SCENARIO 2 - CreatureBuffArtifact
//            ################################################################
            h1.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.STRONGHOLD).getCreatureByTier(1), 20);
            h1.buyArtifact(ArtifactsInfoFactory.getArtifact(PENDANT_OF_LIFE)); //to LIGHTNING_BOLT spell
            h1.buyArtifact(ArtifactsInfoFactory.getArtifact(CAPE_OF_VELOCITY)); //+2 speed
            h1.buySpell(SpellBookInfoFactory.getSpell(MAGIC_ARROW));
            h1.buySpell(SpellBookInfoFactory.getSpell(LIGHTNING_BOLT));
        } catch (Exception aE) {
            aE.printStackTrace();
        }
        return h1;
    }

    EconomyHero getH2() {
        EconomyHero h2 = EconomyHero.builder().aGold(100000000).aHeroInfo(HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.BRISSA)).build();
        try {
//            ################################################################
//            SCENARIO 2
//            ################################################################
            h2.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.STRONGHOLD).getCreatureByTier(1),20);
            h2.buyArtifact(ArtifactsInfoFactory.getArtifact(RECANTERS_CLOAK)); //+20% resistance
            h2.buySpell(SpellBookInfoFactory.getSpell(MAGIC_ARROW));
            h2.buySpell(SpellBookInfoFactory.getSpell(LIGHTNING_BOLT));

        } catch (Exception aE) {
        }
        return h2;
    }


}
