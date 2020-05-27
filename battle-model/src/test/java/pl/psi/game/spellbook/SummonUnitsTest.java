package pl.psi.game.spellbook;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.Board;
import pl.psi.game.fractions.Creature;
import pl.psi.game.fractions.CreatureAbstractFactory;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SummonUnitsTest {

    private final static String STORM_ELEMENTAL = "Summon storm elemental";
    private final static String ENERGY_ELEMENTAL = "Summon energy elemental";
    private final static String MAGMA_ELEMENTAL = "Summon magma elemental";
    private final static String ICE_ELEMENTAL = "Summon ice elemental";

    private CreatureAbstractFactory creatureAbstractFactory = new CreatureAbstractFactory();
    private Board board = new Board();

//    SpellInfo spellInfo = SpellBookInfoFactory.getSpell(STORM_ELEMENTAL);
//    SpellFactory factory = new SpellFactory();
//    SummonUnits summonUnits = (SummonUnits) factory.createSpell(spellInfo);

    @Test
     void shouldCreateStormElementalAndPutHimOnTheBoard() {
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.ELEMENTAL).getCreatureByTier(1);
        Creature creature = creatureAbstractFactory.getCreature(creatureInfo);
        //summonUnits.summonElemental(STORM_ELEMENTAL, 1, 1, 1);
        board.putCreature(1, 1 , creature);
        assertEquals(creature, board.getCreature(1,1));
    }
//    @Test
//    void shouldCreateIceElementalAndPutHimOnTheBoard() {
//        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.ELEMENTAL).getCreatureByTier(2);
//        Creature creature = creatureAbstractFactory.getCreature(creatureInfo);
//        summonUnits.summonElemental(ICE_ELEMENTAL, 1, 1, 1);
//        assertEquals(creature, board.getCreature(1,1));
//    }
//
//    @Test
//    void shouldCreateEnergyElementalAndPutHimOnTheBoard() {
//        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.ELEMENTAL).getCreatureByTier(3);
//        Creature creature = creatureAbstractFactory.getCreature(creatureInfo);
//        summonUnits.summonElemental(ENERGY_ELEMENTAL, 1, 1, 1);
//        assertEquals(creature, board.getCreature(1,1));
//    }
//
//    @Test
//    @Disabled
//    void shouldCreateMagmaElementalAndPutHimOnTheBoard() {
//        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.ELEMENTAL).getCreatureByTier(4);
//        Creature creature = creatureAbstractFactory.getCreature(creatureInfo);
//
//        summonUnits.summonElemental(MAGMA_ELEMENTAL, 1, 1, 1);
//        assertEquals(creature, board.getCreature(1,1));
//    }
}
