package pl.psi.game.fractions;

import com.google.common.collect.Range;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.psi.game.move.GuiTileIf;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@Getter
public class Creature implements GuiTileIf, PropertyChangeListener {

    private int maxHp;
    private final Range<Integer> attack;
    private final int armor;
    private final String name;
    @Setter private int currentHp;
    @Setter private boolean canCounterAttacked;
    private int moveRange;
    private boolean canFly;

    public int getMoveRange() {
        return moveRange;
    }

    public boolean isCanFly() {
        return canFly;
    }

    private int amount;
    private DealDamageCounterStrategyIf dealDamageCounterStrategy;
    @Setter private MagicResistance magicResistance;
    
    @Builder
    public Creature(int aMaxHp, Range<Integer> aAttack, int aArmor, String aName, int aMoveRange, boolean aCanFly) {
        maxHp = aMaxHp;
        attack = aAttack;
        currentHp = maxHp;
        armor = aArmor;
        canCounterAttacked = true;
        name = aName;
        moveRange = aMoveRange;
        canFly = aCanFly;
        amount = 10;
        dealDamageCounterStrategy = new DefaultDamageCounterStrategy();
        magicResistance = new MagicResistance(0, MagicResistance.ImmunityType.NONE);
    }

    public Creature(int aMaxHp, Range<Integer> aAttack, int aArmor) {
        maxHp = aMaxHp;
        attack = aAttack;
        currentHp = maxHp;
        armor = aArmor;
        canCounterAttacked = true;
        name = "";
        moveRange = 0;
        canFly = false;
        magicResistance = new MagicResistance(0, MagicResistance.ImmunityType.NONE);
    }

    public void attack(Creature aDefender) {
        dealDamage(aDefender);
        if (aDefender.canCounterAttacked) {
            aDefender.counterAttack(this);
        }
    }

    @Override
    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(System.lineSeparator());
        sb.append(currentHp);
        sb.append("/");
        sb.append(maxHp);
        return sb.toString();
    }

    private void counterAttack(Creature aDefender) {
        dealDamage(aDefender);
        canCounterAttacked = false;
    }

    void dealDamage(Creature aDefender) {
        int damageToDeal = dealDamageCounterStrategy.countDamageToDeal(this, aDefender);
        aDefender.currentHp = aDefender.currentHp - damageToDeal;
    }

    public boolean canShoot(){
        return false;
    }

    @Override
    public boolean isCreature() {
        return true;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        canCounterAttacked = true;
    }

    public void setDealDamageCountStrategy(DealDamageCounterStrategyIf aDealDamageCounterStrategyIf) {
        dealDamageCounterStrategy = aDealDamageCounterStrategyIf;
    }
    
    public void heal(int hp) {
    	currentHp += hp;
    	if (currentHp > maxHp) {
    		currentHp = maxHp;
    	}
    }

    public void increaseHP(int hp) {
        maxHp += hp;
        currentHp += hp;
    }

    public void increaseMoveRange(int additionalMoveRange) {
        moveRange += additionalMoveRange;
    }
}
