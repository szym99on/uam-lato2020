package pl.psi.game.skills;

import lombok.Builder;
import pl.psi.game.AbstractItemInfo;

public class SkillInfo extends AbstractItemInfo {

    public enum SkillType {
        OFFENCE,
        INTELLIGENCE,
        WISDOM,
        ARMOUR
    }
    @Builder
    public SkillInfo(String aName, String aDescription, int aCost) {
        super(aName, aDescription, aCost);
    }
}
