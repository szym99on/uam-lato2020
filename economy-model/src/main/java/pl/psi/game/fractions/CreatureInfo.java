package pl.psi.game.fractions;

import com.google.common.collect.Range;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreatureInfo {
    private final int maxHp;
    private final Range<Integer> attack;
    private final int armor;
    private final String name;
    private final int moveRange;

    @Builder
    public CreatureInfo(int aMaxHp, Range<Integer> aAttack, int aArmor, String aName, int aMoveRange) {
        maxHp = aMaxHp;
        attack = aAttack;
        armor = aArmor;
        name = aName;
        moveRange = aMoveRange;
    }

}
