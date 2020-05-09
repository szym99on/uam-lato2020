package pl.psi.game.fractions;

import com.google.common.collect.Range;
import java.util.ArrayList;
import java.util.List;

public class NecropolisInfoFactory extends FractionsInfoAbstractFactory {

    private final static List<CreatureInfo> creatureList = new ArrayList<>();
    {
        creatureList.add(CreatureInfo.builder().aMaxHp(6).aAttack(Range.closed(1, 3)).aName("Skeleton").aArmor(4).aMoveRange(4).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(15).aAttack(Range.closed(2, 3)).aName("Walking Dead").aArmor(5).aMoveRange(3).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(18).aAttack(Range.closed(3, 5)).aName("Wight").aArmor(7).aMoveRange(5).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(30).aAttack(Range.closed(5, 8)).aName("Vampire").aArmor(9).aMoveRange(6).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(30).aAttack(Range.closed(11, 13)).aName("Lich").aArmor(10).aMoveRange(6).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(120).aAttack(Range.closed(15, 30)).aName("Black Knight").aArmor(16).aMoveRange(7).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(150).aAttack(Range.closed(25, 50)).aName("Bone Dragon").aArmor(15).aMoveRange(9).build());
    }
}
