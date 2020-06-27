package pl.psi.game.artifacts;

import pl.psi.game.hero.converter.Hero;
import pl.psi.game.spellbook.Spell;

abstract class SpellBuffArtifact extends Artifact{
    @Override
    public void apply(Hero aHero) {
        aHero.getSpellBook().getSpells().forEach(s -> buffSpell(s) );
    }

    @Override
    public boolean affectsHeroStats(){ return false; }

    abstract void buffSpell(Spell s);
    
    @Override
    public int getSpeed() { return 0; }

    @Override
    public int getHealth() { return 0; }

    @Override
    public int getMagicResistance() { return 0; }

    @Override
    public String getSpellImmunityName() { return "NONE"; }
}
