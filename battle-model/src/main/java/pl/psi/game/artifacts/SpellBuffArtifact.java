package pl.psi.game.artifacts;

import pl.psi.game.hero.converter.Hero;
import pl.psi.game.spellbook.Spell;

abstract class SpellBuffArtifact extends Artifact{
    @Override
    public void apply(Hero aHero) {
        aHero.getSpellBook().getSpells().forEach(s -> buffSpell(s) );
    }

    abstract void buffSpell(Spell s);
}
