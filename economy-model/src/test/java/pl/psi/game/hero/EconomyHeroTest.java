package pl.psi.game.hero;

import org.junit.jupiter.api.Test;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.spellbook.SpellBookInfoFactory;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EconomyHeroTest {


    @Test
    //TODO: you should has CreatureInfo not Creature and map, not list (CreatureInfo + amount) or some wrapper list (wrapper means another object with int amount and CreatureInfo creature)
    void buyCreature(){
        List<Creature> creatures = new ArrayList<Creature>();
        Hero hero = EconomyHero.builder().creatures(creatures).build();
        Creature creature = CreatureInfoFactory.getCreature(CreatureInfoFactory.CREATURE_NAME);
        int creatureCost = creature.getCost();
        int currentGold = hero.getGold();
        hero.buyCreature(creature);
        assertEquals(hero.getGold(), currentGold - creatureCost);
    }




    @Test
    void addGoldShouldAddGold() {
        List<Creature> creatures = new ArrayList<Creature>();
        Hero hero = EconomyHero.builder().creatures(creatures).build();
        int howMuch = 50;
        int moneyBefore = hero.getGold();
        hero.addGold(howMuch);
        //TODO 2050 will be better than moneyBefore + howMuch
        assertEquals(hero.getGold(), moneyBefore + howMuch);
    }

    @Test
    void sellCreatureShouldReturn75PercentOfOriginalPrice() {
        List<Creature> creatures = new ArrayList<Creature>();
        Creature creature = CreatureInfoFactory.getCreature(CratureInfoFactory.SKELETON);
        creatures.add(creature);
        Hero hero = EconomyHero.builder().creatures(creatures).build();
        int moneyBefore = hero.getGold();
        int costOfCreature = creature.getCost();
        hero.sellCreature(creature);
        //TODO as above use concrete values not calculating in assertions
        assertEquals(hero.getGold(), moneyBefore + (0.75 * costOfCreature));

    }

    @Test
    void sellArtifactShouldReturn75PercentOfOriginalPrice() {
        List<Creature> creatures = new ArrayList<Creature>();
        Hero hero = EconomyHero.builder().creatures(creatures).build();
        Artifact artifact = ArtifactsInfoFactoryFactory.getArtifact(ArtifactsInfoFactory.ARTIFACT_NAME);
        int moneyBefore = hero.getGold();
        hero.sellArtifact(artifact);
        assertEquals(hero.getGold(), moneyBefore + 0.75 * artifact.getCost());

    }

    @Test
    void sellSpellShouldReturn75PercentOfOriginalPrice() {
        List<Creature> creatures = new ArrayList<Creature>();
        Hero hero = EconomyHero.builder().creatures(creatures).build();
        Spell spell = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.SPELL_NAME);
        int moneyBefore = hero.getGold();
        hero.sellSpell(spell);
        assertEquals(hero.getGold(), moneyBefore + 0.75 * spell.getCost());
    }

    @Test
    //TODO spellInfo not spell
    void successBuySpell() {
        List<Creature> creatures = new ArrayList<Creature>();
        Hero hero = EconomyHero.builder().creatures(creatures).build();
        Spell spell = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.SPELL_NAME);
        int moneyBefore = hero.getGold();
        hero.buySpell(spell);
        //TODO as above
        assertEquals(hero.getGold(), moneyBefore - spell.getCost());
        //TODO ?! why you test creature list after buy spell? o.0
        assertEquals(hero.getCreatures().size() + 1, hero.getCreatures().size());

    }

    @Test
    //TODO test is not too good... you check only that you have some artifact but nothing else. If you buy artifact you should check what if slot is already used etc.
    void successBuyArtifact(){
        List<Creature> creatures = new ArrayList<Creature>();
        Hero hero = EconomyHero.builder().creatures(creatures).build();
        List<Artifact> artifactsBefore = hero.getArtifacts();
        int moneyBefore = hero.getGold();
        Artifact artifact = ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.HEAD);
        hero.buyArtifact(artifact);
        assertEquals(hero.getGold(), moneyBefore - artifact.getCost());
        assertEquals(artifactsBefore.size()+1, hero.getArtifacts().size());
    }

    //metody, które jeszcze trzeba przetestować:
    //
//    generateCreaturesAvailableToBuy()
//    generateSpellsAvailableToBuy()
//    buyCharacterSpecialSkill()
//    freezeShop()
//    generateShops()


}