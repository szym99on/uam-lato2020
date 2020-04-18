import com.google.common.collect.Range;

public class ShootingCreature extends Creature {

    private boolean shouldShoot = true;

    public ShootingCreature(int aMaxHp, Range<Integer> aAttack, int aArmor, String aName) {
        super(aMaxHp, aAttack, aArmor, aName);
    }

    @Override
    public void attack(Creature aDefender) {
        if (shouldShoot){
            shoot(aDefender);
        }
        else
        {
            super.attack(aDefender);
        }
    }

    private void shoot(Creature aDefender) {
        dealDamage(aDefender);
    }
}
