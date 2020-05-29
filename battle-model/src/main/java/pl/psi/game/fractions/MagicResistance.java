package pl.psi.game.fractions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MagicResistance {

    private int allSpellsResistancePercentage;
    private ImmunityType immunityType;

    public enum ImmunityType {NONE, FOURTH_TIER_AND_BELOW, EARTH_SPELLS, ICE_SPELLS, FIRE_SPELLS, AIR_SPELLS}

}
