package pl.psi.game.spellbook;

import lombok.Builder;
import pl.psi.game.Board;
import pl.psi.game.fractions.Creature;
import pl.psi.game.fractions.CreatureAbstractFactory;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;

import java.util.Objects;

public class SummonUnits extends Spell {

    private CreatureAbstractFactory creatureAbstractFactory = new CreatureAbstractFactory();
    private Board board = new Board();
    private String name;

    @Builder
    public SummonUnits(String aName, String aDescription, int aCost, int aLevel, int aManaCost, SpellInfo.Type aType, String aDuration) {
        super(aName, aDescription, aCost, aLevel, aManaCost, aType, aDuration);
        name = aName;
    }


    @Override
    public void cast(int x, int y) {

        if(Objects.equals(name, SpellBookInfoFactory.STORM_ELEMENTAL)) {
            CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.ELEMENTAL).getCreatureByTier(1);
            Creature creature = creatureAbstractFactory.getCreature(creatureInfo);
            //UNRESOLVED PROBLEM WITH PUTTING CREATURE
            //board.putCreature(x,y, creature);
        }

    }

    @Override
    public void cast(Creature creature) {

    }

}
