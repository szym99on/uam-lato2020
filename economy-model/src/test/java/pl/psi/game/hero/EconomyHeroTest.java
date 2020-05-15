package pl.psi.game.hero;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.spellbook.SpellBookInfoFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EconomyHeroTest {


//    @Test
//    //TODO: you should has CreatureInfo not Creature and map, not list (CreatureInfo + amount) or some wrapper list (wrapper means another object with int amount and CreatureInfo creature)
//    void buyCreature(){
//        List<Creature> creatures = new ArrayList<Creature>();
//        Hero hero = EconomyHero.builder().creatures(creatures).build();
//        Creature creature = CreatureInfoFactory.getCreature(CreatureInfoFactory.CREATURE_NAME);
//        int creatureCost = creature.getCost();
//        int currentGold = hero.getGold();
//        hero.buyCreature(creature);
//        assertEquals(hero.getGold(), currentGold - creatureCost);
//    }
//
//
//
//
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
//        List<Creature> creatures = new ArrayList<Creature>();
//        Creature creature = CreatureInfoFactorgit y.getCreature(CratureInfoFactory.SKELETON);
//        creatures.add(creature);
//        Hero hero = EconomyHero.builder().creatures(creatures).build();
//        int moneyBefore = hero.getGold();
//        int costOfCreature = creature.getCost();
//        hero.sellCreature(creature);
//        //TODO as above use concrete values not calculating in assertions
//        assertEquals(hero.getGold(), moneyBefore + (0.75 * costOfCreature));
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
    void buyArtifactShouldNotAddArtifactIfLocationNotEmpty(){

        //DON'T KNOW HOW TO ADD SINGLE ARTIFACT IN BUILDER
        // I just created a list of artifacts and then added it to builder
        List<ArtifactInfo> artifacts = new ArrayList<ArtifactInfo>();
        ArtifactInfo artifactHelmet = ArtifactsInfoFactory.getArtifact("Collar of Conjurin");
        artifacts.add(artifactHelmet);
        EconomyHero hero = EconomyHero.builder().artifacts(artifacts).build();

        //hero state before adding artifact
        List<ArtifactInfo> artifactsBefore = hero.getArtifacts();
        int moneyBefore = hero.getGold();
    //wait for artifacts group to give us getter of artifact location
    //  List<ArtifactInfo.Location> artifactsLocationsBefore = hero.getArtifactsLocations();

        //create artifact to add
        ArtifactInfo artifactToAdd = ArtifactsInfoFactory.getArtifact("Collar of Conjurin");
        hero.buyArtifact(artifactToAdd);

        assertEquals(moneyBefore, hero.getGold() );
        assertEquals(artifactsBefore.size(), hero.getArtifacts().size());
        assertNotEquals(hero.getArtifact("Hellstorm Helmet"), artifactToAdd);
}@Test

    void  buyArtifactShouldAddArtifactIfLocationEmpty(){
        //DON'T KNOW HOW TO ADD SINGLE ARTIFACT IN BUILDER
        // I just created a list of artifacts and then added it to builder
        List<ArtifactInfo> artifacts = new ArrayList<ArtifactInfo>();
        ArtifactInfo artifactHelmet = ArtifactsInfoFactory.getArtifact("Collar of Conjurin");
        artifacts.add(artifactHelmet);
        EconomyHero hero = EconomyHero.builder().artifacts(artifacts).build();

        //hero state before adding artifact
        List<ArtifactInfo> artifactsBefore = hero.getArtifacts();
        int moneyBefore = hero.getGold();
        //wait for artifacts group to give us getter of artifact location
        //  List<ArtifactInfo.Location> artifactsLocationsBefore = hero.getArtifactsLocations();

        //create artifact to add
        ArtifactInfo artifactToAdd = ArtifactsInfoFactory.getArtifact("Buckler of the Gnoll King");
        hero.buyArtifact(artifactToAdd);

        assertEquals(moneyBefore - artifactToAdd.getCost(),hero.getGold());
        assertEquals(artifactsBefore.size()+1, hero.getArtifacts().size());
        assertEquals(hero.getArtifact("Buckler of the Gnoll King"), artifactToAdd);
    }



    //metody, które jeszcze trzeba przetestować:
    //
//    generateCreaturesAvailableToBuy()
//    generateSpellsAvailableToBuy()
//    buyCharacterSpecialSkill()
//    freezeShop()
//    generateShops()


}