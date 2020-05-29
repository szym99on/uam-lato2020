package pl.psi.game.fractions;

import com.google.common.collect.Range;
import java.util.ArrayList;
import java.util.List;

public class ElementalInfoFactory extends FractionsInfoAbstractFactory {

    ElementalInfoFactory(){
        creatureList.add(CreatureInfo.builder().aMaxHp(25).aAttack(Range.closed(2, 8)).aName("Storm Elemental").aArmor(9).aMoveRange(8).aCanFly(false).aCost(275).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(30).aAttack(Range.closed(3, 7)).aName("Ice Elemental").aArmor(10).aMoveRange(6).aCanFly(false).aCost(375).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(35).aAttack(Range.closed(4, 6)).aName("Energy Elemental").aArmor(8).aMoveRange(8).aCanFly(true).aCost(400).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(40).aAttack(Range.closed(6, 10)).aName("Magma Elemental").aArmor(11).aMoveRange(6).aCanFly(false).aCost(500).build());
    }
}
