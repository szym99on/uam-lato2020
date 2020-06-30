package pl.psi.game.fractions;

import com.google.common.collect.Range;

import java.util.ArrayList;
import java.util.List;

public class StrongholdInfoFactory extends FractionsInfoAbstractFactory {

    public static final String HOBGOBLIN = "Hobgoblin";
    public static final String WOLF_RAIDER = "Wolf Raider";
    public static final String ORC_CHIEFTAIN = "Orc Chieftain";
    public static final String OGRE_MAGI = "Ogre Magi";
    public static final String THUNDERBIRD = "Thunderbird";
    public static final String CYCLOPS_KING = "Cyclops King";
    public static final String ANCIENT_BEHEMOTH = "Ancient Behemoth";

    StrongholdInfoFactory(){
        creatureList.add(CreatureInfo.builder().aMaxHp(5).aAttack(Range.closed(1, 2)).aName(HOBGOBLIN).aArmor(3).aMoveRange(7).aCanFly(false).aCost(50).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(10).aAttack(Range.closed(3, 4)).aName(WOLF_RAIDER).aArmor(5).aMoveRange(8).aCanFly(false).aCost(140).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(20).aAttack(Range.closed(2, 5)).aName(ORC_CHIEFTAIN).aArmor(4).aMoveRange(5).aCanFly(false).aCost(165).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(60).aAttack(Range.closed(6, 12)).aName(OGRE_MAGI).aArmor(7).aMoveRange(5).aCanFly(false).aCost(400).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(60).aAttack(Range.closed(11, 15)).aName(THUNDERBIRD).aArmor(11).aMoveRange(11).aCanFly(true).aCost(750).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(70).aAttack(Range.closed(16, 20)).aName(CYCLOPS_KING).aArmor(13).aMoveRange(8).aCanFly(false).aCost(1100).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(300).aAttack(Range.closed(30, 50)).aName(ANCIENT_BEHEMOTH).aArmor(19).aMoveRange(9).aCanFly(false).aCost(3000).build());
    }
}
