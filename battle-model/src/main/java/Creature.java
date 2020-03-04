public class Creature {

    private final int maxHp;
    private final int attack;
    private int currentHp;

    public Creature(int aMaxHp, int aAttack) {
        maxHp = aMaxHp;
        attack = aAttack;
        currentHp = maxHp;
    }

    public void attack(Creature c1) {
        c1.currentHp = c1.currentHp - attack;
    }

    public int getHp() {
        return currentHp;
    }
}
