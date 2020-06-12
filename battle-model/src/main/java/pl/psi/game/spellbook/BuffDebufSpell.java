package pl.psi.game.spellbook;

import lombok.Builder;
import pl.psi.game.fractions.Creature;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BuffDebufSpell extends Spell implements PropertyChangeListener {

    private int expireIn;
    private final int heroPower;
    private int additionalDuration;
    private int modificationAttack;
    private int modificationArmor;
    private int modificationMoveRange;
    private Creature creature;

    @Builder
    public BuffDebufSpell (String aName, String aDescription, int aCost, int aLevel, int aManaCost, SpellInfo.Type aType, int aDuration,int aHeroPower, int aAdditionalDuration,int aModificationAttack, int aModificationArmor,int aModificationMoveRange) {
        super(aName,aDescription,aCost,aLevel,aManaCost,aType,aDuration);
        heroPower = aHeroPower;
        additionalDuration = aAdditionalDuration;
        modificationAttack = aModificationAttack;
        modificationArmor = aModificationArmor;
        modificationMoveRange = aModificationMoveRange;
    }

    @Override
    public void cast(int x, int y)
    {
        //cast(Board.getCreature(x,y));
    }

    @Override
    public void cast(Creature aCreature)
    {
        //creature.addToBuffSet(this);
        creature = aCreature;
        expireIn = heroPower + additionalDuration;
        if(modificationAttack >= 1){
//            creature.increaseAttack(attack);
        }
        else if (modificationAttack <= -1){
//            creature.decreaseAttack(-attack);
        }
        if(modificationArmor >= 1){
//            creature.increaseArmor(armor);
        }
        else if (modificationArmor <= -1){
//            creature.decreaseArmor(-armor);
        }
        if(modificationMoveRange >= 1){
//            creature.increaseMoveRange(moveRange);
        }
        else if(modificationMoveRange <= -1){
//            creature.decreaseMoveRange(-moveRange);
        }

    }

    //listen END_OF_TURN
    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent)
    {
        expireIn--;
        if(expireIn==0){
            removeSpell();
        }
    }

    public void removeSpell(){
        if(modificationAttack >= 1){
//            creature.decreaseAttack(attack);
        }
        else if (modificationAttack <= -1){
//            creature.increaseAttack(-attack);
        }
        if(modificationArmor >= 1){
//            creature.decreaseArmor(armor);
        }
        else if (modificationArmor <= -1){
//            creature.increaseArmor(-armor);
        }
        if(modificationMoveRange >= 1){
//            creature.decreaseMoveRange(moveRange);
        }
        else if (modificationMoveRange <= -1){
//            creature.increaseMoveRange(-moveRange)
        }
    }
}
