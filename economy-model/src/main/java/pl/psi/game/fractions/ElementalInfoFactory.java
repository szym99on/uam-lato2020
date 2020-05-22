package pl.psi.game.fractions;

import com.google.common.collect.Range;
import java.util.ArrayList;
import java.util.List;

public class ElementalInfoFactory extends FractionsInfoAbstractFactory {

    private final static List<CreatureInfo> creatureList = new ArrayList<>();
    {
    	creatureList.add(CreatureInfo.builder().aMaxHp(25).aAttack(Range.closed(2, 8)).aName("Storm Elemental").aArmor(9).aMoveRange(8).aCost(275).build());
    	creatureList.add(CreatureInfo.builder().aMaxHp(30).aAttack(Range.closed(3, 7)).aName("Ice Elemental").aArmor(10).aMoveRange(6).aCost(375).build());
    	creatureList.add(CreatureInfo.builder().aMaxHp(35).aAttack(Range.closed(4, 6)).aName("Energy Elemental").aArmor(8).aMoveRange(8).aCost(400).build());
    	creatureList.add(CreatureInfo.builder().aMaxHp(40).aAttack(Range.closed(6, 10)).aName("Magma Elemental").aArmor(11).aMoveRange(6).aCost(500).build());
    }
    
    public CreatureInfo getByTier(int aTier) {
    	return creatureList.get(aTier-1);
    }
}
