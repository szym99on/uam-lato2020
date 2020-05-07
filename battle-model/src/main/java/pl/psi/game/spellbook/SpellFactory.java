package pl.psi.game.spellbook;

public class SpellFactory {

    public Spell createSpell(SpellInfo spellInfo){
       return Spell.builder().aName(spellInfo.getName()).build();
    }
}
