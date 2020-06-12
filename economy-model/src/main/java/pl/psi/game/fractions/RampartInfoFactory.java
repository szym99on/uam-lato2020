package pl.psi.game.fractions;

import com.google.common.collect.Range;

import java.util.ArrayList;
import java.util.List;

public class RampartInfoFactory extends FractionsInfoAbstractFactory {

    RampartInfoFactory(){
        creatureList.add(CreatureInfo.builder().aMaxHp(10).aAttack(Range.closed(2, 3)).aName("Centaur Captain").aArmor(3).aMoveRange(8).aCanFly(false).aCost(90).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(20).aAttack(Range.closed(2, 4)).aName("Battle Dwarf").aArmor(7).aMoveRange(5).aCanFly(false).aCost(150).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(15).aAttack(Range.closed(3, 5)).aName("Grand Elf").aArmor(5).aMoveRange(7).aCanFly(false).aCost(225).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(30).aAttack(Range.closed(5, 9)).aName("Silver Pegasus").aArmor(10).aMoveRange(12).aCanFly(true).aCost(275).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(65).aAttack(Range.closed(10, 14)).aName("Dendroid Soldier").aArmor(12).aMoveRange(4).aCanFly(false).aCost(425).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(110).aAttack(Range.closed(18, 22)).aName("War Unicorn").aArmor(14).aMoveRange(9).aCanFly(false).aCost(950).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(250).aAttack(Range.closed(40, 50)).aName("Gold Dragon").aArmor(27).aMoveRange(16).aCanFly(true).aCost(4000).build());
    }


    public List<CreatureInfo> getAllCreatures(){
        return creatureList;
    }
}
