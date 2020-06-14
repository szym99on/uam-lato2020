package pl.psi.game.fractions;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MagicResistance {

    private int allSpellsResistancePercentage;
    private ImmunityType immunityType;
    private List<String> immunitySpells;
    
    public enum ImmunityType {NONE, FOURTH_TIER_AND_BELOW, EARTH_SPELLS, ICE_SPELLS, FIRE_SPELLS, AIR_SPELLS}
    
    public void addImmunitySpell(String spellName) {
    	immunitySpells.add(spellName);
    }
    
    public void removeImmunitySpell(String spellName) {
    	immunitySpells.remove(spellName);
    }
}
