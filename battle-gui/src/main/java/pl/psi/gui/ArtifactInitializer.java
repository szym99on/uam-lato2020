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
        ArtifactsInfoFactory artifactsInfoFactory = new ArtifactsInfoFactory();
    }

    EconomyHero getH1() {
        EconomyHero h1 = EconomyHero.builder().aGold(100000000).aHeroInfo(HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.EDRIC)).build();
        try {
//            ################################################################
//            SCENARIO 1 - no artifacts equipped by hero
//            ################################################################
//            h1.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(7));

//            ################################################################
//            SCENARIO 2 - hero has MAGIC_ARROW spell
//            ################################################################
//            h1.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.RAMPART).getCreatureByTier(7));
//            h1.buySpell(SpellBookInfoFactory.getSpell(MAGIC_ARROW));

//            ################################################################
//            SCENARIO 3 - hero has LIGHTNING_BOLT spell
//            ################################################################
//            h1.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.STRONGHOLD).getCreatureByTier(7));
//            h1.buySpell(SpellBookInfoFactory.getSpell(LIGHTNING_BOLT));
//            h1.buySpell(SpellBookInfoFactory.getSpell(HASTE));

//            ################################################################
//            SCENARIO 4 - hero has HASTE~~ spell
//            ################################################################
            h1.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.RAMPART).getCreatureByTier(3));
            h1.buySpell(SpellBookInfoFactory.getSpell(HASTE));
        } catch (Exception aE) {
            aE.printStackTrace();
        }
        return h1;
    }

    EconomyHero getH2() {
        EconomyHero h2 = EconomyHero.builder().aGold(100000000).aHeroInfo(HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.EDRIC)).build();
        try {
//            ################################################################
//            SCENARIO 1 - CreatureSpeedArtifact, CreatureHealthArtifact
//            ################################################################
//            h2.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(7));
//            h2.buyArtifact(ArtifactsInfoFactory.getArtifact(CAPE_OF_VELOCITY)); // +2 moveRange
//            h2.buyArtifact(ArtifactsInfoFactory.getArtifact(RING_OF_LIFE)); // +2 Health

//            ################################################################
//            SCENARIO 2 - hero has MAGIC_ARROW spell and CreatureMagicResistanceArtifact (20%)
//            ################################################################
//            h2.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.RAMPART).getCreatureByTier(7));
//            h2.buyArtifact(ArtifactsInfoFactory.getArtifact(RECANTERS_CLOAK));
//            h2.buySpell(SpellBookInfoFactory.getSpell(MAGIC_ARROW));

//            ################################################################
//            SCENARIO 3 - hero has CreatureImmunityArtifact and LIGHTNING_BOLT spell
//            ################################################################
//            h2.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.STRONGHOLD).getCreatureByTier(7));
//            h2.buyArtifact(ArtifactsInfoFactory.getArtifact(PENDANT_OF_LIFE));
//            h2.buySpell(SpellBookInfoFactory.getSpell(LIGHTNING_BOLT));

//            ################################################################
//            SCENARIO 4 - hero has SpellDurationArtifact (+3) AND HASTE spell
//            ################################################################
            h2.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.RAMPART).getCreatureByTier(3));
            h2.buyArtifact(ArtifactsInfoFactory.getArtifact(RING_OF_CONJURING));
            h2.buySpell(SpellBookInfoFactory.getSpell(HASTE));
        } catch (Exception aE) {
        }
        return h2;
    }
}
