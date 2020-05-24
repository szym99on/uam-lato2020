package pl.psi.game.hero;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;
import pl.psi.game.fractions.NecropolisInfoFactory;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.skills.SkillInfo;
import pl.psi.game.skills.SkillInfoFactory;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import pl.psi.game.spellbook.SpellInfo;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EconomyHeroTest {

    @BeforeAll
    static void initializeFactories(){
        new SpellBookInfoFactory();
        new ArtifactsInfoFactory();
        new FractionsInfoAbstractFactory();
    }


   @Test
   void buyCreatureShouldTakeGoldAndAddCreature () throws Exception {
        FractionsInfoAbstractFactory necropolisFactory =  FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS);
      CreatureInfo creature = necropolisFactory.getCreature(NecropolisInfoFactory.SKELETON_WARRIOR);
      EconomyHero hero = EconomyHero.builder().aGold(1000).build();

      hero.buyCreature(creature);

      assertEquals(hero.getGold(), 930);
      assertTrue(hero.getCreatures().contains(creature));
      assertEquals(hero.getCreatures().size(), 1);
   }




    @Test
    void increaseGoldShouldAddGold() {
        EconomyHero hero = EconomyHero.builder().aGold(2000).build();
        int howMuch = 50;

        hero.increaseGold(howMuch);

        assertEquals(hero.getGold(), 2050);
    }

    @Test
    void decreaseGoldShouldRemoveGold(){
        EconomyHero hero = EconomyHero.builder().aGold(2000).build();
        int howMuch = 50;

        hero.decreaseGold(howMuch);

        assertEquals(hero.getGold(),1950);
    }

    @Test
    void sellSkeletonWarriorShouldReturn75PercentOfOriginalPrice() throws Exception {
        FractionsInfoAbstractFactory necropolisFactory =  FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS);
        CreatureInfo creature = necropolisFactory.getCreature(NecropolisInfoFactory.SKELETON_WARRIOR);
        EconomyHero hero = EconomyHero.builder().aGold(2000).build();
        hero.addCreature(creature);

        hero.sellCreature(creature);

        assertEquals(hero.getGold(), 2052);
        assertFalse(hero.getCreatures().contains(creature));
        assertEquals(hero.getCreatures().size(), 0);
    }

    @Test
    void sellDreadKnightShouldReturn75PercentOfOriginalPrice() throws Exception {
        FractionsInfoAbstractFactory necropolisFactory =  FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS);
        CreatureInfo creature = necropolisFactory.getCreature(NecropolisInfoFactory.DREAD_KNIGHT);
        EconomyHero hero = EconomyHero.builder().aGold(2000).build();
        hero.addCreature(creature);

        hero.sellCreature(creature);

        assertEquals(hero.getGold(), 3125);
        assertFalse(hero.getCreatures().contains(creature));
        assertEquals(hero.getCreatures().size(), 0);

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
    void sellSpellShouldReturn75PercentOfOriginalPriceAndRemoveSpell() throws Exception {
        SpellInfo spell = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW);
        EconomyHero hero = EconomyHero.builder().aGold(2000).build();
        hero.addSpell(spell);

        hero.sellSpell(spell);

        assertEquals(hero.getGold(), 2075);
        assertFalse(hero.getSpells().contains(spell));
        assertEquals(hero.getSpells().size(),0);
    }

    @Test
    void buySpellShouldTakeGoldAndAddSpell() {
        SpellInfo spell = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW);
        EconomyHero hero = EconomyHero.builder().aGold(3000).build();

        hero.buySpell(spell);

        assertEquals(hero.getGold(), 2900);
        assertTrue(hero.getSpells().contains(spell));
        assertEquals(hero.getSpells().size(), 1);

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
