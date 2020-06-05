package pl.psi.gui;

import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.hero.HeroInfoFactory;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.hero.economyHero.EconomyHero;
import pl.psi.game.spellbook.SpellBookInfoFactory;

import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.*;
import static pl.psi.game.spellbook.SpellBookInfoFactory.*;

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
//            SCENARIO 1 - no artifacts equipped by hero
//            ################################################################
            h1.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(3));

//            ################################################################
//            SCENARIO 2 - hero has MAGIC_ARROW
//            ################################################################
//            h1.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(3));
//            h1.buySpell(SpellBookInfoFactory.getSpell(MAGIC_ARROW));
        } catch (Exception aE) {
            aE.printStackTrace();
        }
        return h1;
    }

    EconomyHero getH2() {
        EconomyHero h2 = EconomyHero.builder().aGold(100000000).aHeroInfo(HeroInfoFactory.getHeroInfoByName(HeroInfoFactory.ALAMAR)).build();
        try {
//            ################################################################
//            SCENARIO 1 - CreatureSpeedArtifact, CreatureHealthArtifact, HeroStatisticArtifact
//            ################################################################
            h2.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(3));
            h2.buyArtifact(ArtifactsInfoFactory.getArtifact(CAPE_OF_VELOCITY)); // +2 moveRange
            h2.buyArtifact(ArtifactsInfoFactory.getArtifact(RING_OF_LIFE)); // +2 Health
//            h2.buyArtifact(ArtifactsInfoFactory.getArtifact(OGRES_CLUB_OF_HAVOC)); (waiting for implemention of heroAttack -> creatureAttack)

//            ################################################################
//            SCENARIO 2 - hero has MAGIC_ARROW and CreatureMagicResistanceArtifact
//            ################################################################
//            h2.buyCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(3));
//            h2.buyArtifact(ArtifactsInfoFactory.getArtifact(SURCOAT_OF_COUNTERPOISE));
//            h2.buySpell(SpellBookInfoFactory.getSpell(MAGIC_ARROW));


        } catch (Exception aE) {
        }
        return h2;
    }
}
