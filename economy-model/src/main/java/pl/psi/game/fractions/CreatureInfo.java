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
    private int currentHp;
    private boolean canCounterAttacked;
    private final int moveRange;

    @Builder
    public CreatureInfo(int aMaxHp, Range<Integer> aAttack, int aArmor, String aName, int aMoveRange) {
        maxHp = aMaxHp;
        attack = aAttack;
        currentHp = maxHp;
        armor = aArmor;
        canCounterAttacked = true;
        name = aName;
        moveRange = aMoveRange;
    }

}
