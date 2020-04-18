import lombok.Builder;

public class Creature {

    private final int maxHp;
    private final int attack;
    private final int armor;
    private int currentHp;

    @Builder
    public Creature(int aMaxHp, int aAttack, int aArmor) {
        maxHp = aMaxHp;
        attack = aAttack;
        currentHp = maxHp;
        armor = aArmor;
    }

    public void attack(Creature aDefender) {
        dealDamage(aDefender);
        aDefender.counterAttack(this);
    }

    private void counterAttack(Creature aDefender){
        dealDamage(aDefender);
    }

    private void dealDamage(Creature aDefender) {
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
