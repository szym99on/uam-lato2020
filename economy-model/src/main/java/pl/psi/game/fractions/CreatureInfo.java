package pl.psi.game.fractions;

import com.google.common.collect.Range;
import lombok.Builder;
import lombok.Getter;
import pl.psi.game.AbstractItemInfo;

@Getter
public class CreatureInfo extends AbstractItemInfo {
    private final int maxHp;
    private final Range<Integer> attack;
    private final int armor;
    private final int moveRange;

    @Builder
    public CreatureInfo(int aMaxHp, Range<Integer> aAttack, int aArmor, String aName, int aMoveRange, String aDescription, int aCost) {
        super(aName, aDescription, aCost);
        maxHp = aMaxHp;
        attack = aAttack;
        armor = aArmor;
        moveRange = aMoveRange;
    }

}
