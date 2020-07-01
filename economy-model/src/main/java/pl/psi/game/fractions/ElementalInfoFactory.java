package pl.psi.game.fractions;

import com.google.common.collect.Range;
import java.util.ArrayList;
import java.util.List;

public class ElementalInfoFactory extends FractionsInfoAbstractFactory {

    public String getName(){
        return "ELEMENTAL";
    }
    public static final String STORM_ELEMENTAL = "Storm Elemental";
    public static final String ICE_ELEMENTAL = "Ice Elemental";
    public static final String ENERGY_ELEMENTAL = "Energy Elemental";
    public static final String MAGMA_ELEMENTAL = "Magma Elemental";

    ElementalInfoFactory(){
        creatureList.add(CreatureInfo.builder().aMaxHp(25).aAttack(Range.closed(2, 8)).aName(STORM_ELEMENTAL).aArmor(9).aMoveRange(8).aCanFly(false).aCost(275).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(30).aAttack(Range.closed(3, 7)).aName(ICE_ELEMENTAL).aArmor(10).aMoveRange(6).aCanFly(false).aCost(375).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(35).aAttack(Range.closed(4, 6)).aName(ENERGY_ELEMENTAL).aArmor(8).aMoveRange(8).aCanFly(true).aCost(400).build());
        creatureList.add(CreatureInfo.builder().aMaxHp(40).aAttack(Range.closed(6, 10)).aName(MAGMA_ELEMENTAL).aArmor(11).aMoveRange(6).aCanFly(false).aCost(500).build());
    }
}
