package pl.psi.game.hero;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.fractions.NecropolisInfoFactory;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.spellbook.SpellBookInfoFactory;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class EconomyHeroTest {


   //@Test
   //TODO: you should has CreatureInfo not Creature and map, not list (CreatureInfo + amount) or some wrapper list (wrapper means another object with int amount and CreatureInfo creature)
  // void buyCreatureShouldTakeMoney (){
  //    CreatureInfo creature = CreatureInfoFactory.getCreature(CreatureInfoFactory.SKELETON);
  //    Map<CreatureInfo, Integer> creatures = new TreeMap<>();
  //    creatures.put(creature.getName(),creature.getCost());
  //    EconomyHero hero = EconomyHero.builder().creatures(creature).build();
  //    int creatureCost = creatures.getValue();
  //    int currentMoney = 1000;
  //    hero.buyCreature(creature);
  //    assertEquals(hero.getGold(), 950);
  // }
    @Test
    void addGoldShouldAddGold() {
        EconomyHero hero = EconomyHero.builder().gold(2000).build();
        int howMuch = 50;
        hero.addGold(howMuch);
        assertEquals(hero.getGold(), 2050);
    }
//
//    @Test
//    void sellCreatureShouldReturn75PercentOfOriginalPrice() {
//        List<CreatureInfo> creatures = new ArrayList<CreatureInfo>();
//        CreatureInfo creature = NecropolisInfoFactory.getCreature(NecropolisInfoFactory.SKELETON);
//        creatures.add(creature);
//        EconomyHero hero = EconomyHero.builder().gold(2000).creatures(creatures).build();
//        //(cost of Skeleton is 60)
//        hero.sellCreature(creature);
//        //TODO as above use concrete values not calculating in assertions
//        assertEquals(hero.getGold(), 2045);
//
//    }
//
//    @Test
//    void sellArtifactShouldReturn75PercentOfOriginalPrice() {
//        List<Creature> creatures = new ArrayList<Creature>();
//        Hero hero = EconomyHero.builder().creatures(creatures).build();
//        Artifact artifact = ArtifactsInfoFactoryFactory.getArtifact(ArtifactsInfoFactory.ARTIFACT_NAME);
//        int moneyBefore = hero.getGold();
//        hero.sellArtifact(artifact);
//        assertEquals(hero.getGold(), moneyBefore + 0.75 * artifact.getCost());
//
//    }
//
//    @Test
//    void sellSpellShouldReturn75PercentOfOriginalPrice() {
//        List<Creature> creatures = new ArrayList<Creature>();
//        Hero hero = EconomyHero.builder().creatures(creatures).build();
//        Spell spell = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.SPELL_NAME);
//        int moneyBefore = hero.getGold();
//        hero.sellSpell(spell);
//        assertEquals(hero.getGold(), moneyBefore + 0.75 * spell.getCost());
//    }
//
//    @Test
//
//    void successBuySpell() {
//        List<SpellInfo> spells = new ArrayList<SpellInfo>();
//        Hero hero = EconomyHero.builder().creatures().build();
//        hero.setWallet(10);
//        SpellInfo spell = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGIC_ARROW);
//        buySpell(hero, spell);
//        assertEquals(hero.getGold()-spell.getCost, 9);
//        assertEquals(hero.spells.size() +1, 1);
//
//    }
//
    @Test
    //TODO test is not too good... you check only that you have some artifact but nothing else. If you buy artifact you should check what if slot is already used etc.
    //TODO corrected by PW
    @Disabled
    void successBuyArtifact(){
//        EconomyHero hero = EconomyHero.builder().build();
//        List<ArtifactInfo> artifactsBefore = hero.getArtifacts();
//        int moneyBefore = hero.getGold();
//        ArtifactInfo artifact = ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.HELM_OF_THE_ALABASTER_UNICORN);
//        hero.buyArtifact(artifact);
//        assertEquals(hero.getGold(), moneyBefore - artifact.getCost());
//        assertEquals(artifactsBefore.size()+1, hero.getArtifacts().size());
    }

    //metody, które jeszcze trzeba przetestować:
    //
//    generateCreaturesAvailableToBuy()
//    generateSpellsAvailableToBuy()
//    buyCharacterSpecialSkill()
//    freezeShop()
//    generateShops()


}