package pl.psi.game.fractions;

import com.google.common.collect.Range;

import java.util.ArrayList;
import java.util.List;

public class RampartInfoFactory extends FractionsInfoAbstractFactory {

    public static final String CENTAUR_CAPTAIN = "Centaur Captain";
    public static final String BATTLE_DWARF = "Battle Dwarf";
    public static final String GRAND_ELF = "Grand Elf";
    public static final String SILVER_PEGASUS = "Silver Pegasus";
    public static final String DENDROID_SOLDIER = "Dendroid Soldier";
    public static final String WAR_UNICORN = "War Unicorn";
    public static final String GOLD_DRAGON = "Gold Dragon";

    RampartInfoFactory(){
        creatureList.add(CreatureInfo.builder().aMaxHp(10).aAttack(Range.closed(2, 3)).aName(CENTAUR_CAPTAIN).aArmor(3).aMoveRange(8).aCanFly(false).aCost(90).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(20).aAttack(Range.closed(2, 4)).aName(BATTLE_DWARF).aArmor(7).aMoveRange(5).aCanFly(false).aCost(150).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(15).aAttack(Range.closed(3, 5)).aName(GRAND_ELF).aArmor(5).aMoveRange(7).aCanFly(false).aCost(225).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(30).aAttack(Range.closed(5, 9)).aName(SILVER_PEGASUS).aArmor(10).aMoveRange(12).aCanFly(true).aCost(275).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(65).aAttack(Range.closed(10, 14)).aName(DENDROID_SOLDIER).aArmor(12).aMoveRange(4).aCanFly(false).aCost(425).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(110).aAttack(Range.closed(18, 22)).aName(WAR_UNICORN).aArmor(14).aMoveRange(9).aCanFly(false).aCost(950).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(250).aAttack(Range.closed(40, 50)).aName(GOLD_DRAGON).aArmor(27).aMoveRange(16).aCanFly(true).aCost(4000).build());
    }
}
