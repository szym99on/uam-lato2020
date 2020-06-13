package pl.psi.game.fractions;

import com.google.common.collect.Range;

import java.util.ArrayList;
import java.util.List;

public class StrongholdInfoFactory extends FractionsInfoAbstractFactory {
    
    StrongholdInfoFactory(){
        creatureList.add(CreatureInfo.builder().aMaxHp(5).aAttack(Range.closed(1, 2)).aName("Hobgoblin").aArmor(3).aMoveRange(7).aCanFly(false).aCost(50).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(10).aAttack(Range.closed(3, 4)).aName("Wolf Raider").aArmor(5).aMoveRange(8).aCanFly(false).aCost(140).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(20).aAttack(Range.closed(2, 5)).aName("Orc Chieftain").aArmor(4).aMoveRange(5).aCanFly(false).aCost(165).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(60).aAttack(Range.closed(6, 12)).aName("Ogre Magi").aArmor(7).aMoveRange(5).aCanFly(false).aCost(400).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(60).aAttack(Range.closed(11, 15)).aName("Thunderbird").aArmor(11).aMoveRange(11).aCanFly(true).aCost(750).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(70).aAttack(Range.closed(16, 20)).aName("Cyclops King").aArmor(13).aMoveRange(8).aCanFly(false).aCost(1100).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(300).aAttack(Range.closed(30, 50)).aName("Ancient Behemoth").aArmor(19).aMoveRange(9).aCanFly(false).aCost(3000).build());
    }


    public List<CreatureInfo> getAllCreatures(){
        return creatureList;
    }
}
