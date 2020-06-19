package pl.psi.game.spellbook;

import lombok.Builder;
import pl.psi.game.Board;
import pl.psi.game.fractions.Creature;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BuffDebufSpell extends Spell {

    private int modificationAttack;
    private int modificationArmor;
    private int modificationMoveRange;
    private Creature creature;

    @Builder
    public BuffDebufSpell (String aName, String aDescription, int aCost, int aLevel, int aManaCost, SpellInfo.Type aType, int aDuration,int aModificationAttack, int aModificationArmor,int aModificationMoveRange) {
        super(aName,aDescription,aCost,aLevel,aManaCost,aType,aDuration);
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
    public void cast(int x, int y)
    {
        cast(Board.getBoard().getCreature(x,y));
    }

    @Override
    public void cast(Creature aCreature)
    {
        //creature.addToBuffSet(this);
        creature = aCreature;
        if(modificationAttack >= 1){
            creature.increaseAttack(modificationAttack);
        }
        else if (modificationAttack <= -1){
            creature.decreaseAttack(-modificationAttack);
        }
        if(modificationArmor >= 1){
            creature.increaseArmor(modificationArmor);
        }
        else if (modificationArmor <= -1){
            creature.decreaseArmor(-modificationArmor);
        }
        if(modificationMoveRange >= 1){
            creature.increaseMoveRange(modificationMoveRange);
        }
        else if(modificationMoveRange <= -1){
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
        }
    }

    public void removeSpell(){
        if(modificationAttack >= 1){
            creature.decreaseAttack(modificationAttack);
        }
        else if (modificationAttack <= -1){
            creature.increaseAttack(-modificationAttack);
        }
        if(modificationArmor >= 1){
            creature.decreaseArmor(modificationArmor);
        }
        else if (modificationArmor <= -1){
            creature.increaseArmor(-modificationArmor);
        }
        if(modificationMoveRange >= 1){
            creature.decreaseMoveRange(modificationMoveRange);
        }
        else if (modificationMoveRange <= -1){
            creature.increaseMoveRange(-modificationMoveRange);
        }
//        creature.removeFromBuffSet(this);
    }
}
