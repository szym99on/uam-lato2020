package pl.psi.game.skills;

import lombok.Builder;
import lombok.Getter;
import pl.psi.game.AbstractItemInfo;

@Getter
public class SkillInfo extends AbstractItemInfo {

    private final SkillType type;

    public enum SkillType {
        COMBAT_SKILL,
        ADVENTURE_SKILL,
        MAGIC_SKILL

    }
    @Builder
    public SkillInfo(String aName, String aDescription, int aCost, SkillType aType) {
        super(aName, aDescription, aCost);
        type = aType;
    }
}
