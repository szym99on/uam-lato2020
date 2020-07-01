package pl.psi.game.spellbook;

import lombok.Builder;
import pl.psi.game.Board;
import pl.psi.game.GameEngine;
import pl.psi.game.fractions.Creature;

import java.beans.PropertyChangeEvent;

public class SpecialBuffDebufSpell extends Spell {
    private Creature creature;

    @Builder
    public SpecialBuffDebufSpell (String aName, String aDescription, int aCost, int aLevel, int aManaCost, SpellInfo.Type aType, SpellInfo.Target aTarget, int aDuration) {
        super(aName,aDescription,aCost,aLevel,aManaCost,aType,aDuration,aTarget);
    }

    @Override
    public void increaseDuration (int aAdditionalDuration){
        if(aAdditionalDuration >= 0)
        {
            duration = duration + aAdditionalDuration;
        }
        else throw new IllegalArgumentException("You can't increase by a negative value");
    }

    @Override
    public Object clone()
    {
        return new SpecialBuffDebufSpell(this.getName(),this.getDescription(),this.getCost(),this.getLevel(),this.getManaCost(),this.getType(),this.getTarget(),this.getDuration());
    }

    @Override
    public boolean needObserver(){
        return true;
    }


    @Override
    public void cast(int x, int y)
    {
        cast(Board.getBoard().getCreature(x,y));
    }

    @Override
    public void cast(Creature aCreature) {
        creature = aCreature;
        switch (getName()){
            case SpellBookInfoFactory.ANTY_MAGIC:
                    SpellBookInfoFactory.getSpellsByLevel(1).forEach(s -> creature.getMagicResistance().addImmunitySpell(s.getName()));
                    SpellBookInfoFactory.getSpellsByLevel(2).forEach(s -> creature.getMagicResistance().addImmunitySpell(s.getName()));
                    SpellBookInfoFactory.getSpellsByLevel(3).forEach(s -> creature.getMagicResistance().addImmunitySpell(s.getName()));
                break;
        }


    }

    //listen END_OF_TURN
    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent)
    {
        duration--;
        if(duration==0){
            removeSpell();
            ((GameEngine) propertyChangeEvent.getNewValue()).removeObserver(GameEngine.END_OF_TURN,this);
        }
    }

    public void removeSpell(){
        switch (getName()){
            case SpellBookInfoFactory.ANTY_MAGIC:
                SpellBookInfoFactory.getSpellsByLevel(1).forEach(s -> creature.getMagicResistance().removeImmunitySpell(s.getName()));
                SpellBookInfoFactory.getSpellsByLevel(2).forEach(s -> creature.getMagicResistance().removeImmunitySpell(s.getName()));
                SpellBookInfoFactory.getSpellsByLevel(3).forEach(s -> creature.getMagicResistance().removeImmunitySpell(s.getName()));
                break;
        }

    }
}
