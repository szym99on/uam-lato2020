import lombok.Builder;

public class Creature {

    private final int maxHp;
    private final int attack;
    private final int armor;
    private int currentHp;
    private boolean canCounterAttacked;

    @Builder
    public Creature(int aMaxHp, int aAttack, int aArmor) {
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
        int damageToDeal;
        if (attack - aDefender.armor <= 0) {
            damageToDeal = 1;
        } else {
            damageToDeal = attack - aDefender.armor;
        }
        aDefender.currentHp = aDefender.currentHp - damageToDeal;
    }

    public int getHp() {
        return currentHp;
    }
}
