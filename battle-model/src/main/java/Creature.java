public class Creature {

    private final int maxHp;
    private final int attack;
    private final int armor;
    private int currentHp;

    public Creature(int aMaxHp, int aAttack, int aArmor) {
        maxHp = aMaxHp;
        attack = aAttack;
        currentHp = maxHp;
        armor = aArmor;
    }

    public void attack(Creature aDefender) {
        aDefender.currentHp = aDefender.currentHp - (attack - aDefender.armor);
    }

    public int getHp() {
        return currentHp;
    }
}
