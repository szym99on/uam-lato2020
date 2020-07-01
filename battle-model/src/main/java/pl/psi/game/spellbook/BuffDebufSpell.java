package pl.psi.game.spellbook;

import lombok.Builder;
import pl.psi.game.Board;
import pl.psi.game.GameEngine;
import pl.psi.game.fractions.Creature;

import java.beans.PropertyChangeEvent;

public class BuffDebufSpell extends Spell {

    private final static int NEUTRAL_VALUE_0 = 0;

    private int modificationAttack;
    private int modificationArmor;
    private int modificationMoveRange;
    private Creature creature;

    @Builder
    public BuffDebufSpell (String aName, String aDescription, int aCost, int aLevel, int aManaCost, SpellInfo.Type aType, SpellInfo.Target aTarget, int aDuration, int aModificationAttack, int aModificationArmor, int aModificationMoveRange) {
        super(aName,aDescription,aCost,aLevel,aManaCost,aType,aDuration,aTarget);
        modificationAttack = aModificationAttack;
        modificationArmor = aModificationArmor;
        modificationMoveRange = aModificationMoveRange;
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
        return new BuffDebufSpell(this.getName(),this.getDescription(),this.getCost(),this.getLevel(),this.getManaCost(),this.getType(),this.getTarget(),this.getDuration(),this.modificationAttack,this.modificationArmor,this.modificationMoveRange);
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
    public void cast(Creature aCreature)
    {
        //creature.addToBuffSet(this);
        creature = aCreature;
        if(modificationAttack > NEUTRAL_VALUE_0){
            creature.increaseAttack(modificationAttack);
        }
        else if (modificationAttack < NEUTRAL_VALUE_0){
            creature.decreaseAttack(-modificationAttack);
        }
        if(modificationArmor > NEUTRAL_VALUE_0){
            creature.increaseArmor(modificationArmor);
        }
        else if (modificationArmor < NEUTRAL_VALUE_0){
            creature.decreaseArmor(-modificationArmor);
        }
        if(modificationMoveRange > NEUTRAL_VALUE_0){
            creature.increaseMoveRange(modificationMoveRange);
        }
        else if(modificationMoveRange < NEUTRAL_VALUE_0){
            creature.decreaseMoveRange(-modificationMoveRange);
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
        if(modificationAttack > NEUTRAL_VALUE_0){
            creature.decreaseAttack(modificationAttack);
        }
        else if (modificationAttack < NEUTRAL_VALUE_0){
            creature.increaseAttack(-modificationAttack);
        }
        if(modificationArmor > NEUTRAL_VALUE_0){
            creature.decreaseArmor(modificationArmor);
        }
        else if (modificationArmor < NEUTRAL_VALUE_0){
            creature.increaseArmor(-modificationArmor);
        }
        if(modificationMoveRange > NEUTRAL_VALUE_0){
            creature.decreaseMoveRange(modificationMoveRange);
        }
        else if (modificationMoveRange < NEUTRAL_VALUE_0){
            creature.increaseMoveRange(-modificationMoveRange);
        }
//        creature.removeFromBuffSet(this);
    }
}
