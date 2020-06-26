package pl.psi.game.spellbook;

public class SpellFactory {

    @Deprecated
    public Spell createSpell(SpellInfo spellInfo){
        return createSpell(spellInfo, 1);
    }

    public Spell createSpell(SpellInfo spellInfo, int aHeroPower){
        switch (spellInfo.getName()){
            case SpellBookInfoFactory.MAGIC_ARROW :
                return DamageSpell.builder().aTarget(spellInfo.getTarget()).aSpellDamage((aHeroPower * 10) + 10).aName(spellInfo.getName()).aCost(spellInfo.getCost()).aDescription(spellInfo.getDescription()).aDuration(spellInfo.getDuration()).aManaCost(spellInfo.getManaCost()).aLevel(spellInfo.getLevel()).aType(spellInfo.getType()).build();
            case SpellBookInfoFactory.LIGHTNING_BOLT :
                return DamageSpell.builder().aTarget(spellInfo.getTarget()).aSpellDamage((aHeroPower * 25) + 10).aName(spellInfo.getName()).aCost(spellInfo.getCost()).aDescription(spellInfo.getDescription()).aDuration(spellInfo.getDuration()).aManaCost(spellInfo.getManaCost()).aLevel(spellInfo.getLevel()).aType(spellInfo.getType()).build();
            case SpellBookInfoFactory.DESTROY_UNDEAD :
                return DamageSpell.builder().aTarget(spellInfo.getTarget()).aSpellDamage((aHeroPower * 10) + 10).aName(spellInfo.getName()).aCost(spellInfo.getCost()).aDescription(spellInfo.getDescription()).aDuration(spellInfo.getDuration()).aManaCost(spellInfo.getManaCost()).aLevel(spellInfo.getLevel()).aType(spellInfo.getType()).build();
            case SpellBookInfoFactory.FIRE_BALL :
                return DamageSpell.builder().aTarget(spellInfo.getTarget()).aSpellDamage((aHeroPower * 10) + 15).aName(spellInfo.getName()).aCost(spellInfo.getCost()).aDescription(spellInfo.getDescription()).aDuration(spellInfo.getDuration()).aManaCost(spellInfo.getManaCost()).aLevel(spellInfo.getLevel()).aType(spellInfo.getType()).build();
            case SpellBookInfoFactory.METEOR_SHOWER :
                return DamageSpell.builder().aTarget(spellInfo.getTarget()).aSpellDamage((aHeroPower * 25) + 25).aName(spellInfo.getName()).aCost(spellInfo.getCost()).aDescription(spellInfo.getDescription()).aDuration(spellInfo.getDuration()).aManaCost(spellInfo.getManaCost()).aLevel(spellInfo.getLevel()).aType(spellInfo.getType()).build();
            case SpellBookInfoFactory.IMPLOSION :
                return DamageSpell.builder().aTarget(spellInfo.getTarget()).aSpellDamage((aHeroPower * 75) + 100).aName(spellInfo.getName()).aCost(spellInfo.getCost()).aDescription(spellInfo.getDescription()).aDuration(spellInfo.getDuration()).aManaCost(spellInfo.getManaCost()).aLevel(spellInfo.getLevel()).aType(spellInfo.getType()).build();
            case SpellBookInfoFactory.WEAKNESS :
                return BuffDebufSpell.builder().aTarget(spellInfo.getTarget()).aModificationAttack(-3).aModificationArmor(0).aModificationMoveRange(0).aName(spellInfo.getName()).aCost(spellInfo.getCost()).aDescription(spellInfo.getDescription()).aDuration(spellInfo.getDuration()*aHeroPower).aManaCost(spellInfo.getManaCost()).aLevel(spellInfo.getLevel()).aType(spellInfo.getType()).build();
            case SpellBookInfoFactory.HASTE :
                return BuffDebufSpell.builder().aTarget(spellInfo.getTarget()).aModificationAttack(0).aModificationArmor(0).aModificationMoveRange(3).aName(spellInfo.getName()).aCost(spellInfo.getCost()).aDescription(spellInfo.getDescription()).aDuration(spellInfo.getDuration()*aHeroPower).aManaCost(spellInfo.getManaCost()).aLevel(spellInfo.getLevel()).aType(spellInfo.getType()).build();
            case SpellBookInfoFactory.STONESKIN :
                return BuffDebufSpell.builder().aTarget(spellInfo.getTarget()).aModificationAttack(0).aModificationArmor(3).aModificationMoveRange(0).aName(spellInfo.getName()).aCost(spellInfo.getCost()).aDescription(spellInfo.getDescription()).aDuration(spellInfo.getDuration()*aHeroPower).aManaCost(spellInfo.getManaCost()).aLevel(spellInfo.getLevel()).aType(spellInfo.getType()).build();
            case SpellBookInfoFactory.PRAYER :
                return BuffDebufSpell.builder().aTarget(spellInfo.getTarget()).aModificationAttack(2).aModificationArmor(2).aModificationMoveRange(2).aName(spellInfo.getName()).aCost(spellInfo.getCost()).aDescription(spellInfo.getDescription()).aDuration(spellInfo.getDuration()*aHeroPower).aManaCost(spellInfo.getManaCost()).aLevel(spellInfo.getLevel()).aType(spellInfo.getType()).build();
            case SpellBookInfoFactory.AIR_SHIELD :
            case SpellBookInfoFactory.BLOODLUST :
            case SpellBookInfoFactory.FIRE_SHIELD :
            case SpellBookInfoFactory.SLOW :
                return BuffDebufSpell.builder().aTarget(spellInfo.getTarget()).aName(spellInfo.getName()).aCost(spellInfo.getCost()).aDescription(spellInfo.getDescription()).aDuration(spellInfo.getDuration()).aManaCost(spellInfo.getManaCost()).aLevel(spellInfo.getLevel()).aType(spellInfo.getType()).build();
            case SpellBookInfoFactory.STORM_ELEMENTAL :
                return SummonUnits.builder().aTarget(spellInfo.getTarget()).aName(spellInfo.getName()).build();
            case SpellBookInfoFactory.ENERGY_ELEMENTAL :
                return SummonUnits.builder().aTarget(spellInfo.getTarget()).aName(spellInfo.getName()).build();
            case SpellBookInfoFactory.ICE_ELEMENTAL :
                return SummonUnits.builder().aTarget(spellInfo.getTarget()).aName(spellInfo.getName()).build();
            case SpellBookInfoFactory.MAGMA_ELEMENTAL :
                return SummonUnits.builder().aTarget(spellInfo.getTarget()).aName(spellInfo.getName()).build();
            default:
                throw new IllegalArgumentException("This spell doesn't exist");
        }
    }
}
