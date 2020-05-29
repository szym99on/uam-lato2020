package pl.psi.game.fractions;

import org.junit.jupiter.api.Test;

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
}
