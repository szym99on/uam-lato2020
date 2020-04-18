import com.google.common.collect.Range;
import lombok.Builder;

import java.util.Random;

public class Creature {

    private final int maxHp;
    private final Range<Integer> attack;
    private final int armor;
    private final String name;
    private int currentHp;
    private boolean canCounterAttacked;
    private Random random;
    private final int moveRange;

    @Builder
    public Creature(int aMaxHp, Range<Integer> aAttack, int aArmor, String aName, int aMoveRange) {
        maxHp = aMaxHp;
        attack = aAttack;
        currentHp = maxHp;
        armor = aArmor;
        canCounterAttacked = true;
        random = new Random();
        name = aName;
        moveRange = aMoveRange;
    }

    public Creature(int aMaxHp, Range<Integer> aAttack, int aArmor, Random aRandom) {
        maxHp = aMaxHp;
        attack = aAttack;
        currentHp = maxHp;
        armor = aArmor;
        canCounterAttacked = true;
        random = aRandom;
        name = "";
        moveRange = 0;
    }

    public void attack(Creature aDefender) {
        dealDamage(aDefender);
        if (aDefender.canCounterAttacked) {
            aDefender.counterAttack(this);
        }
    }

    private void counterAttack(Creature aDefender) {
        dealDamage(aDefender);
        canCounterAttacked = false;
    }

    void dealDamage(Creature aDefender) {
        int rand = random.nextInt(attack.upperEndpoint());
        int damageToDeal = attack.lowerEndpoint()+rand;



        if (damageToDeal - aDefender.armor <= 0) {
            damageToDeal = 1;
        }
        else
        {
            damageToDeal = damageToDeal - aDefender.armor;
        }
        aDefender.currentHp = aDefender.currentHp - damageToDeal;
    }

    public int getHp() {
        return currentHp;
    }
}
