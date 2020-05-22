package pl.psi.game.fractions;

import com.google.common.collect.Range;

public class RampartCreatureFactory {

    public Creature createCreature(int aTier) {
        switch (aTier) {
            case 1:
                return Creature.builder().aMaxHp(10).aAttack(Range.closed(2, 3)).aName("Centaur Captain").aArmor(3).aMoveRange(8).build();
            case 2:
                return Creature.builder().aMaxHp(20).aAttack(Range.closed(2, 4)).aName("Battle Dwarf").aArmor(7).aMoveRange(5).build();
            case 3:
                return Creature.builder().aMaxHp(15).aAttack(Range.closed(3, 5)).aName("Grand Elf").aArmor(5).aMoveRange(7).build();
            case 4:
                return Creature.builder().aMaxHp(30).aAttack(Range.closed(5, 9)).aName("Silver Pegasus").aArmor(10).aMoveRange(12).build();
            case 5:
                return Creature.builder().aMaxHp(65).aAttack(Range.closed(10, 14)).aName("Dendroid Soldier").aArmor(12).aMoveRange(4).build();
            case 6:
                return Creature.builder().aMaxHp(110).aAttack(Range.closed(18, 22)).aName("War Unicorn").aArmor(14).aMoveRange(9).build();
            case 7:
                return Creature.builder().aMaxHp(250).aAttack(Range.closed(40, 50)).aName("Gold Dragon").aArmor(27).aMoveRange(16).build();
            default:
                throw new IllegalArgumentException("You have to pass tier 1-7");
        }
    }
}
