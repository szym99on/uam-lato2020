package pl.psi.game.fractions;

import com.google.common.collect.Range;

public class NecropolisCreatureFactory {

    public Creature createCreature(int aTier) {
        switch (aTier) {
            case 1:
                return Creature.builder().aMaxHp(6).aAttack(Range.closed(1, 3)).aName("Skeleton Warrior").aArmor(6).aMoveRange(5).build();
            case 2:
                return Creature.builder().aMaxHp(20).aAttack(Range.closed(2, 3)).aName("Zombie").aArmor(5).aMoveRange(4).build();
            case 3:
                return Creature.builder().aMaxHp(18).aAttack(Range.closed(3, 5)).aName("Wraith").aArmor(7).aMoveRange(7).build();
            case 4:
                return Creature.builder().aMaxHp(40).aAttack(Range.closed(5, 8)).aName("Vampire Lord").aArmor(10).aMoveRange(9).build();
            case 5:
                return Creature.builder().aMaxHp(40).aAttack(Range.closed(11, 15)).aName("Power Lich").aArmor(10).aMoveRange(7).build();
            case 6:
                return Creature.builder().aMaxHp(120).aAttack(Range.closed(15, 30)).aName("Dread Knight").aArmor(18).aMoveRange(9).build();
            case 7:
                return Creature.builder().aMaxHp(200).aAttack(Range.closed(25, 50)).aName("Ghost Dragon").aArmor(17).aMoveRange(14).build();
            default:
                throw new IllegalArgumentException("You have to pass tier 1-7");
        }
    }
}
