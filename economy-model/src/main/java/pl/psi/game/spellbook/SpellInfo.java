package pl.psi.game.spellbook;

import lombok.Builder;
import lombok.Getter;
import pl.psi.game.AbstractItemInfo;

@Getter
public class SpellInfo extends AbstractItemInfo {

    public enum Type{
        FIRE,
        WATER,
        AIR,
        EARTH;
    }

    private final Type type;
    private final int level;
    private final int manaCost;
    private int duration;



    @Builder
     SpellInfo(String aName, String aDescription, int aCost, int aLevel, int aManaCost, Type aType, int aDuration) {
        super(aName,aDescription,aCost);
        level = aLevel;
        manaCost = aManaCost;
        type = aType;
        duration = aDuration;
    }
}
