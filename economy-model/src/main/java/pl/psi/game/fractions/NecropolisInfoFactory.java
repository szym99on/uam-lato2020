package pl.psi.game.fractions;

import com.google.common.collect.Range;
import java.util.ArrayList;
import java.util.List;

public class NecropolisInfoFactory extends FractionsInfoAbstractFactory {

    NecropolisInfoFactory(){
        creatureList.add(CreatureInfo.builder().aMaxHp(6).aAttack(Range.closed(1, 3)).aName("Skeleton Warrior").aArmor(6).aMoveRange(5).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(20).aAttack(Range.closed(2, 3)).aName("Zombie").aArmor(5).aMoveRange(4).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(18).aAttack(Range.closed(3, 5)).aName("Wraith").aArmor(7).aMoveRange(7).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(40).aAttack(Range.closed(5, 8)).aName("Vampire Lord").aArmor(10).aMoveRange(9).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(40).aAttack(Range.closed(11, 15)).aName("Power Lich").aArmor(10).aMoveRange(7).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(120).aAttack(Range.closed(15, 30)).aName("Dread Knight").aArmor(18).aMoveRange(9).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(200).aAttack(Range.closed(25, 50)).aName("Ghost Dragon").aArmor(17).aMoveRange(14).build());
    }
}
