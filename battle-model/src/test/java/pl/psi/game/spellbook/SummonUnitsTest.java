package pl.psi.game.spellbook;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.Board;
import pl.psi.game.fractions.Creature;
import pl.psi.game.fractions.CreatureAbstractFactory;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SummonUnitsTest {

    @BeforeAll
    static void initializeSpellBookInfoFactory(){
        new SpellBookInfoFactory();
    }

    @BeforeAll
    static void initializeFractionsInfoAbstractFactory(){
        new FractionsInfoAbstractFactory();
    }

    private final static String STORM_ELEMENTAL = "Storm Elemental";
    private final static String ENERGY_ELEMENTAL = "Energy Elemental";
    private final static String MAGMA_ELEMENTAL = "Magma Elemental";
    private final static String ICE_ELEMENTAL = "Ice Elemental";

    private CreatureAbstractFactory creatureAbstractFactory = new CreatureAbstractFactory();
    private Board board = Board.getBoard();

    SpellFactory factory = new SpellFactory();
    Spell summonUnits = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.STORM_ELEMENTAL));
    @Test
     void shouldCreateStormElementalAndPutHimOnTheBoard() {
        board.clearBoard();
        Spell summonUnits = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.STORM_ELEMENTAL));
        summonUnits.cast( 1, 1);
        Creature creature = board.getCreature(1,1);
        assertEquals(board.isTileEmpty(1,1), false);
        assertEquals(STORM_ELEMENTAL, creature.getName());

    }
    @Test
    void shouldCreateIceElementalAndPutHimOnTheBoard() {
        board.clearBoard();
        Spell summonUnits = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.ICE_ELEMENTAL));
        summonUnits.cast(1, 1);
        Creature creature = board.getCreature(1,1);
        assertEquals(board.isTileEmpty(1,1), false);
        assertEquals(ICE_ELEMENTAL, creature.getName());
    }

    @Test
    void shouldCreateEnergyElementalAndPutHimOnTheBoard() {
        board.clearBoard();
        Spell summonUnits = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.ENERGY_ELEMENTAL));
        summonUnits.cast( 1, 1);
        Creature creature = board.getCreature(1,1);
        assertEquals(board.isTileEmpty(1,1), false);
        assertEquals(ENERGY_ELEMENTAL, creature.getName());
    }

    @Test
    void shouldCreateMagmaElementalAndPutHimOnTheBoard() {
        board.clearBoard();
        Spell summonUnits = factory.createSpell(SpellBookInfoFactory.getSpell(SpellBookInfoFactory.MAGMA_ELEMENTAL));
        summonUnits.cast( 1, 1);
        Creature creature = board.getCreature(1,1);
        assertEquals(board.isTileEmpty(1,1), false);
        assertEquals(MAGMA_ELEMENTAL, creature.getName());
    }
}
