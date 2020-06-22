package pl.psi.game.fractions;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.psi.game.spellbook.Spell;

@AllArgsConstructor
public class MagicResistance {

    @Getter private int allSpellsResistancePercentage;
    @Getter private GroupImmunityType groupImmunityType;
    private List<String> immunitySpells;

    public MagicResistance(int aAllSpellsResistancePercentage, GroupImmunityType aGroupImmunityType) {
        allSpellsResistancePercentage = aAllSpellsResistancePercentage;
        groupImmunityType = aGroupImmunityType;
        immunitySpells = new ArrayList<>();
    }

    public int countDamage(Spell spell) {
        //TODO
        return 0;
    }

    public enum GroupImmunityType {NONE, FOURTH_TIER_AND_BELOW, EARTH_SPELLS, ICE_SPELLS, FIRE_SPELLS, AIR_SPELLS}
    
    public void addImmunitySpell(String spellName) {
    	immunitySpells.add(spellName);
    }
    
    public void removeImmunitySpell(String spellName) {
    	immunitySpells.remove(spellName);
    }

    public boolean isImmuneToSpell(String spellName) { return immunitySpells.contains(spellName); }

    public void addAllSpellsResistancePercentage(int percentage)  { allSpellsResistancePercentage += percentage; }

    public void removeAllSpellsResistancePercentage(int percentage)  { allSpellsResistancePercentage -= percentage; }
}
