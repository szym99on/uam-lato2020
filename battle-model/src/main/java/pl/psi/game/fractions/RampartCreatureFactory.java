package pl.psi.game.fractions;

import com.google.common.collect.Range;

public class RampartCreatureFactory {

    public Creature createCreature(int aTier) {
        switch (aTier) {
            case 1:
                return Creature.builder().aMaxHp(8).aAttack(Range.closed(2, 3)).aName("Centaur").aArmor(3).aMoveRange(6).build();
            case 2:
                return Creature.builder().aMaxHp(20).aAttack(Range.closed(2, 4)).aName("Dwarf").aArmor(7).aMoveRange(3).build();
            case 3:
                return Creature.builder().aMaxHp(15).aAttack(Range.closed(3, 5)).aName("Wood Elf").aArmor(5).aMoveRange(6).build();
            case 4:
                return Creature.builder().aMaxHp(30).aAttack(Range.closed(5, 9)).aName("Pegasus").aArmor(8).aMoveRange(8).build();
            case 5:
                return Creature.builder().aMaxHp(55).aAttack(Range.closed(10, 14)).aName("Dendroid Guard").aArmor(12).aMoveRange(3).build();
            case 6:
                return Creature.builder().aMaxHp(90).aAttack(Range.closed(18, 22)).aName("Unicorn").aArmor(14).aMoveRange(7).build();
            case 7:
                return Creature.builder().aMaxHp(180).aAttack(Range.closed(40, 50)).aName("Green Dragon").aArmor(18).aMoveRange(10).build();
            default:
                throw new IllegalArgumentException("You have to pass tier 1-7");
        }
    }
}
