package pl.psi.game.spellbook;

import lombok.Builder;
import pl.psi.game.Board;
import pl.psi.game.fractions.Creature;
import pl.psi.game.fractions.CreatureAbstractFactory;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.fractions.FractionsInfoAbstractFactory;

public class SummonUnits extends Spell {

    private CreatureAbstractFactory creatureAbstractFactory = new CreatureAbstractFactory();
    private Board board = new Board();


    public SummonUnits(String aName, String aDescription, int aCost, int aLevel, int aManaCost, SpellInfo.Type aType, String aDuration) {
        super(aName, aDescription, aCost, aLevel, aManaCost, aType, aDuration);
    }
    @Override
    public void cast(String aCreatureName, int x, int y, int tier){
        CreatureInfo creatureInfo = FractionsInfoAbstractFactory.getFactory(FractionsInfoAbstractFactory.Fractions.ELEMENTAL).getCreature(aCreatureName);
        Creature creature = creatureAbstractFactory.getCreature(creatureInfo);
        board.putCreature(x,y, creature);
    }


}
