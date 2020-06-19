package pl.psi.game.fractions;

import org.junit.jupiter.api.Test;
import pl.psi.game.hero.converter.Hero;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterRequest {
    @Test
    void FractionInfoTypes()
    {
        FractionsInfoAbstractFactory.Fractions fraction = FractionsInfoAbstractFactory.Fractions.NECROPOLIS;
    }
    @Test
    void FractionEconomyFactoryGetByType()
    {
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(1);
    }
    @Test
    void BattleFraction()
    {
        CreatureAbstractFactory creatureAbstractFactory = new CreatureAbstractFactory();
    }
    @Test
    void CreateBattleCreatureFromFactory()
    {
        CreatureAbstractFactory creatureAbstractFactory = new CreatureAbstractFactory();
        Creature creature = creatureAbstractFactory.getCreature(FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(1));
    }
    /*@Test
    void CreatureAbstractFactoryMethodGetCreatureShouldBeStatic()
    {
        CreatureAbstractFactory.getCreature();
    }*/
    /*@Test
    void CreatureNeedOverrideEqual()
    {
        CreatureAbstractFactory creatureAbstractFactory = new CreatureAbstractFactory();
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.NECROPOLIS).getCreatureByTier(1);
        Creature creature1 = creatureAbstractFactory.getCreature(creatureInfo);
        Creature creature2 = creatureAbstractFactory.getCreature(creatureInfo);
        List<Creature> creatures = new ArrayList<>();
        creatures.add(creature2);
        Hero hero = Hero.builder().aCreatures(creatures).build();
        assertEquals(creature1,hero.getCreatures().get(0));
    }*/
}
