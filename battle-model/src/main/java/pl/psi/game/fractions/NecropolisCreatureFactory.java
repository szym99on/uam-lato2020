package pl.psi.game.fractions;

import com.google.common.collect.Range;

public class NecropolisCreatureFactory {

    public Creature createCreature(int aTier) {
        switch (aTier) {
            case 1:
                return Creature.builder().aMaxHp(6).aAttack(Range.closed(1, 3)).aName("Skeleton").aArmor(4).aMoveRange(4).build();
            case 2:
                return Creature.builder().aMaxHp(15).aAttack(Range.closed(2, 3)).aName("Walking Dead").aArmor(5).aMoveRange(3).build();
            case 3:
                return Creature.builder().aMaxHp(18).aAttack(Range.closed(3, 5)).aName("Wight").aArmor(7).aMoveRange(5).build();
            case 4:
                return Creature.builder().aMaxHp(30).aAttack(Range.closed(5, 8)).aName("Vampire").aArmor(9).aMoveRange(6).build();
            case 5:
                return Creature.builder().aMaxHp(30).aAttack(Range.closed(11, 13)).aName("Lich").aArmor(10).aMoveRange(6).build();
            case 6:
                return Creature.builder().aMaxHp(120).aAttack(Range.closed(15, 30)).aName("Black Knight").aArmor(16).aMoveRange(7).build();
            case 7:
                return Creature.builder().aMaxHp(150).aAttack(Range.closed(25, 50)).aName("Bone Dragon").aArmor(15).aMoveRange(9).build();
            default:
                throw new IllegalArgumentException("You have to pass tier 1-7");
        }
    }
}
