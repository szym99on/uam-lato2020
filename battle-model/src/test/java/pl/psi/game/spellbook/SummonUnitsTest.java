package pl.psi.game.spellbook;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Test;
import pl.psi.game.Board;
import pl.psi.game.fractions.Creature;
import pl.psi.game.fractions.CreatureAbstractFactory;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SummonUnitsTest {

    private CreatureAbstractFactory creatureAbstractFactory = new CreatureAbstractFactory();
    private Board board = new Board();

    @Test
     void shouldCreateStormElementalAndPutHimOnTheBoard() {
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.ELEMENTAL).getCreatureByTier(1);
        Creature creature = creatureAbstractFactory.getCreature(creatureInfo);
        board.putCreature(1,1, creature);
        assertEquals(creature, board.getCreature(1,1));
    }
    @Test
    void shouldCreateIceElementalAndPutHimOnTheBoard() {
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.ELEMENTAL).getCreatureByTier(2);
        Creature creature = creatureAbstractFactory.getCreature(creatureInfo);
        board.putCreature(1,1, creature);
        assertEquals(creature, board.getCreature(1,1));
    }

    @Test
    void shouldCreateEnergyElementalAndPutHimOnTheBoard() {
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.ELEMENTAL).getCreatureByTier(3);
        Creature creature = creatureAbstractFactory.getCreature(creatureInfo);
        board.putCreature(1,1, creature);
        assertEquals(creature, board.getCreature(1,1));
    }

    @Test
    void shouldCreateMagmaElementalAndPutHimOnTheBoard() {
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.ELEMENTAL).getCreatureByTier(4);
        Creature creature = creatureAbstractFactory.getCreature(creatureInfo);
        board.putCreature(1,1, creature);
        assertEquals(creature, board.getCreature(1,1));
    }
}
