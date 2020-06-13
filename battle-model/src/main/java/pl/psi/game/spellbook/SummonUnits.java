package pl.psi.game.spellbook;

import lombok.Builder;
import pl.psi.game.Board;
import pl.psi.game.fractions.Creature;
import pl.psi.game.fractions.CreatureAbstractFactory;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;

import java.util.Objects;

public class SummonUnits extends Spell {

    private final static String STORM_ELEMENTAL = "Storm Elemental";
    private final static String ENERGY_ELEMENTAL = "Energy Elemental";
    private final static String MAGMA_ELEMENTAL = "Magma Elemental";
    private final static String ICE_ELEMENTAL = "Ice Elemental";
    private CreatureAbstractFactory creatureAbstractFactory = new CreatureAbstractFactory();
    private Board board = Board.getBoard();
    private String name;

    @Builder
    public SummonUnits(String aName, String aDescription, int aCost, int aLevel, int aManaCost, SpellInfo.Type aType, int aDuration) {
        super(aName, aDescription, aCost, aLevel, aManaCost, aType, aDuration);
        name = aName;
    }


    @Override
    public void cast(int x, int y) {

        if (name.equals(SpellBookInfoFactory.STORM_ELEMENTAL)){
            CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.ELEMENTAL).getCreature(STORM_ELEMENTAL);
            Creature creature = creatureAbstractFactory.getCreature(creatureInfo);
            board.putCreature(x,y, creature);
        }
        if (name.equals(SpellBookInfoFactory.MAGMA_ELEMENTAL)){
            CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.ELEMENTAL).getCreature(MAGMA_ELEMENTAL);
            Creature creature = creatureAbstractFactory.getCreature(creatureInfo);
            board.putCreature(x,y, creature);
        }
        if (name.equals(SpellBookInfoFactory.ENERGY_ELEMENTAL)){
            CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.ELEMENTAL).getCreature(ENERGY_ELEMENTAL);
            Creature creature = creatureAbstractFactory.getCreature(creatureInfo);
            board.putCreature(x,y, creature);
        }
        if (name.equals(SpellBookInfoFactory.ICE_ELEMENTAL)){
            CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.ELEMENTAL).getCreature(ICE_ELEMENTAL);
            Creature creature = creatureAbstractFactory.getCreature(creatureInfo);
            board.putCreature(x,y, creature);
        }

    }

    @Override
    public void cast(Creature creature) {

    }

}
