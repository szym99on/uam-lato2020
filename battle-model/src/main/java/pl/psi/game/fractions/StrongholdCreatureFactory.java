package pl.psi.game.fractions;

import com.google.common.collect.Range;

public class StrongholdCreatureFactory {

    public Creature createCreature(int aTier) {
        switch (aTier) {
            case 1:
                return Creature.builder().aMaxHp(5).aAttack(Range.closed(1, 2)).aName("Goblin").aArmor(2).aMoveRange(5).build();
            case 2:
                return Creature.builder().aMaxHp(10).aAttack(Range.closed(2, 4)).aName("Wolf Rider").aArmor(5).aMoveRange(6).build();
            case 3:
                return Creature.builder().aMaxHp(15).aAttack(Range.closed(2, 5)).aName("Orc").aArmor(4).aMoveRange(4).build();
            case 4:
                return Creature.builder().aMaxHp(40).aAttack(Range.closed(6, 12)).aName("Ogre").aArmor(7).aMoveRange(4).build();
            case 5:
                return Creature.builder().aMaxHp(60).aAttack(Range.closed(11, 15)).aName("Roc").aArmor(11).aMoveRange(7).build();
            case 6:
                return Creature.builder().aMaxHp(70).aAttack(Range.closed(16, 20)).aName("Cyclops").aArmor(12).aMoveRange(6).build();
            case 7:
                return Creature.builder().aMaxHp(160).aAttack(Range.closed(30, 50)).aName("Behemoth").aArmor(17).aMoveRange(6).build();
            default:
                throw new IllegalArgumentException("You have to pass tier 1-7");

        }
    }
}
