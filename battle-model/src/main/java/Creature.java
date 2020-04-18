import com.google.common.collect.Range;
import lombok.Builder;

import java.util.Random;

public class Creature {

    private final int maxHp;
    private final Range<Integer> attack;
    private final int armor;
    private int currentHp;
    private boolean canCounterAttacked;

    @Builder
    public Creature(int aMaxHp, Range<Integer> aAttack, int aArmor) {
        maxHp = aMaxHp;
        attack = aAttack;
        currentHp = maxHp;
        armor = aArmor;
        canCounterAttacked = true;
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
        Random random = new Random();
        int rand = random.nextInt(attack.upperEndpoint());

        int damageToDeal = attack.upperEndpoint()+rand;

        if (attack.lowerEndpoint() - aDefender.armor <= 0) {
            damageToDeal = 1;
        } else {
            damageToDeal = attack.lowerEndpoint() - aDefender.armor;
        }
        aDefender.currentHp = aDefender.currentHp - damageToDeal;
    }

    public int getHp() {
        return currentHp;
    }
}
