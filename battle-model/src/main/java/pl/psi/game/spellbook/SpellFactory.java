package pl.psi.game.spellbook;

public class SpellFactory {

    @Deprecated
    public Spell createSpell(SpellInfo spellInfo){
        return createSpell(spellInfo, 1);
    }

    public Spell createSpell(SpellInfo spellInfo, int heroPower){
        switch (spellInfo.getName()){
            case SpellBookInfoFactory.MAGIC_ARROW :
                return DamageSpell.builder().aName(spellInfo.getName()).build();
            case SpellBookInfoFactory.LIGHTNING_BOLT :
                return DamageSpell.builder().aName(spellInfo.getName()).build();
            case SpellBookInfoFactory.DESTROY_UNDEAD :
                return DamageSpell.builder().aName(spellInfo.getName()).build();
            case SpellBookInfoFactory.FIRE_BALL :
                return DamageSpell.builder().aName(spellInfo.getName()).build();
            case SpellBookInfoFactory.METEOR_SHOWER :
                return DamageSpell.builder().aName(spellInfo.getName()).build();
            case SpellBookInfoFactory.IMPLOSION :
                return DamageSpell.builder().aName(spellInfo.getName()).build();
            case SpellBookInfoFactory.WEAKNESS :
                return BuffDebufSpell.builder().aModificationAttack(-3).aModificationArmor(0).aModificationMoveRange(0).aName(spellInfo.getName()).aCost(spellInfo.getCost()).aDescription(spellInfo.getDescription()).aDuration(spellInfo.getDuration()).aManaCost(spellInfo.getManaCost()).aLevel(spellInfo.getLevel()).aType(spellInfo.getType()).build();
            case SpellBookInfoFactory.HASTE :
                return BuffDebufSpell.builder().aModificationAttack(0).aModificationArmor(0).aModificationMoveRange(3).aName(spellInfo.getName()).aCost(spellInfo.getCost()).aDescription(spellInfo.getDescription()).aDuration(spellInfo.getDuration()).aManaCost(spellInfo.getManaCost()).aLevel(spellInfo.getLevel()).aType(spellInfo.getType()).build();
            case SpellBookInfoFactory.STONESKIN :
                return BuffDebufSpell.builder().aModificationAttack(0).aModificationArmor(3).aModificationMoveRange(0).aName(spellInfo.getName()).aCost(spellInfo.getCost()).aDescription(spellInfo.getDescription()).aDuration(spellInfo.getDuration()).aManaCost(spellInfo.getManaCost()).aLevel(spellInfo.getLevel()).aType(spellInfo.getType()).build();
            case SpellBookInfoFactory.PRAYER :
                return BuffDebufSpell.builder().aModificationAttack(2).aModificationArmor(2).aModificationMoveRange(2).aName(spellInfo.getName()).aCost(spellInfo.getCost()).aDescription(spellInfo.getDescription()).aDuration(spellInfo.getDuration()).aManaCost(spellInfo.getManaCost()).aLevel(spellInfo.getLevel()).aType(spellInfo.getType()).build();
            case SpellBookInfoFactory.AIR_SHIELD :
            case SpellBookInfoFactory.BLOODLUST :
            case SpellBookInfoFactory.FIRE_SHIELD :
            case SpellBookInfoFactory.SLOW :
                return BuffDebufSpell.builder().aName(spellInfo.getName()).aCost(spellInfo.getCost()).aDescription(spellInfo.getDescription()).aDuration(spellInfo.getDuration()).aManaCost(spellInfo.getManaCost()).aLevel(spellInfo.getLevel()).aType(spellInfo.getType()).build();
            case SpellBookInfoFactory.STORM_ELEMENTAL :
                return SummonUnits.builder().aName(spellInfo.getName()).build();
            case SpellBookInfoFactory.ENERGY_ELEMENTAL :
                return SummonUnits.builder().aName(spellInfo.getName()).build();
            case SpellBookInfoFactory.ICE_ELEMENTAL :
                return SummonUnits.builder().aName(spellInfo.getName()).build();
            case SpellBookInfoFactory.MAGMA_ELEMENTAL :
                return SummonUnits.builder().aName(spellInfo.getName()).build();
            default:
                throw new IllegalArgumentException("This spell doesn't exist");
        }
    }
}
