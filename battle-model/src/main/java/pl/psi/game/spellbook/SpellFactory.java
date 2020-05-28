package pl.psi.game.spellbook;

public class SpellFactory {

    public Spell createSpell(SpellInfo spellInfo){
        switch (spellInfo.getName()){
            case SpellBookInfoFactory.MAGIC_ARROW :
            case SpellBookInfoFactory.LIGHTNING_BOLT :
            case SpellBookInfoFactory.DESTROY_UNDEAD :
            case SpellBookInfoFactory.FIRE_BALL :
                return null; //Wait for damageSpell implementation
            case SpellBookInfoFactory.WEAKNESS :
            case SpellBookInfoFactory.HASTE :
            case SpellBookInfoFactory.AIR_SHIELD :
            case SpellBookInfoFactory.BLOODLUST :
            case SpellBookInfoFactory.FIRE_SHIELD :
            case SpellBookInfoFactory.SLOW :
            case SpellBookInfoFactory.STONESKIN :
            case SpellBookInfoFactory.PRAYER :
                return BuffDebufSpell.builder().aName(spellInfo.getName()).aCost(spellInfo.getCost()).aDescription(spellInfo.getDescription()).aDuration(spellInfo.getDuration()).aManaCost(spellInfo.getManaCost()).aLevel(spellInfo.getLevel()).aType(spellInfo.getType()).build();
            case SpellBookInfoFactory.STORM_ELEMENTAL :
            case SpellBookInfoFactory.ENERGY_ELEMENTAL :
            case SpellBookInfoFactory.ICE_ELEMENTAL :
            case SpellBookInfoFactory.MAGMA_ELEMENTAL :
                return null; //Wait for summonUnits implementation
            default:
                throw new IllegalArgumentException("This spell doesn't exist");
        }
    }
}
