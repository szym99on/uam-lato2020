package pl.psi.game.fractions;

import com.google.common.collect.Range;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

public class NecropolisInfoFactory extends FractionsInfoAbstractFactory {

    public final static String SKELETON_WARRIOR = "Skeleton Warrior";
    public final static String ZOMBIE = "Zombie";
    public final static String WRAITH = "Wraith";
    public final static String VAMPIRE_LORD = "Vampire Lord";
    public final static String POWER_LICH = "Power Lich";
    public final static String DREAD_KNIGHT = "Dread Knight";
    public final static String GHOST_DRAGON = "Ghost Dragon";


    NecropolisInfoFactory(){
            creatureList.add(CreatureInfo.builder().aMaxHp(6).aAttack(Range.closed(1, 3)).aName("Skeleton Warrior").aArmor(6).aMoveRange(5).aCanFly(false).aCost(70).build());
            creatureList.add(CreatureInfo.builder().aMaxHp(20).aAttack(Range.closed(2, 3)).aName("Zombie").aArmor(5).aMoveRange(4).aCanFly(false).aCost(125).build());
            creatureList.add(CreatureInfo.builder().aMaxHp(18).aAttack(Range.closed(3, 5)).aName("Wraith").aArmor(7).aMoveRange(7).aCanFly(true).aCost(230).build());
            creatureList.add(CreatureInfo.builder().aMaxHp(40).aAttack(Range.closed(5, 8)).aName("Vampire Lord").aArmor(10).aMoveRange(9).aCanFly(true).aCost(500).build());
            creatureList.add(CreatureInfo.builder().aMaxHp(40).aAttack(Range.closed(11, 15)).aName("Power Lich").aArmor(10).aMoveRange(7).aCanFly(false).aCost(600).build());
            creatureList.add(CreatureInfo.builder().aMaxHp(120).aAttack(Range.closed(15, 30)).aName("Dread Knight").aArmor(18).aMoveRange(9).aCanFly(false).aCost(1500).build());
            creatureList.add(CreatureInfo.builder().aMaxHp(200).aAttack(Range.closed(25, 50)).aName("Ghost Dragon").aArmor(17).aMoveRange(14).aCanFly(true).aCost(3000).build());
    }
}
