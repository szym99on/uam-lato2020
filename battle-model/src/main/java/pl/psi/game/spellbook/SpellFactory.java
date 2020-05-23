package pl.psi.game.spellbook;

public class SpellFactory {

    public Spell createSpell(SpellInfo spellInfo){
        switch (spellInfo.getName()){
            case "Haste" : // or replace by SpellBookInfoFactory.HASTE , it have to be public.
                return BuffDebufSpell.builder().aName(spellInfo.getName()).aCost(spellInfo.getCost()).aDescription(spellInfo.getDescription()).aDuration(spellInfo.getDuration()).aManaCost(spellInfo.getManaCost()).aLevel(spellInfo.getLevel()).aType(spellInfo.getType()).build();
            default:
                throw new IllegalArgumentException("This spell doesn't exist");
        }
    }
}
