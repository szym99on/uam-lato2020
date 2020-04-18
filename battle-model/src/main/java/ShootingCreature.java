
public class ShootingCreature extends Creature {

    private boolean shouldShoot = true;

    public ShootingCreature(int aMaxHp, int aAttack, int aArmor) {
        super(aMaxHp, aAttack, aArmor);
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
