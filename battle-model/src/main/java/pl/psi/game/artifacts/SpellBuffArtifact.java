package pl.psi.game.artifacts;

import pl.psi.game.hero.converter.Hero;
import pl.psi.game.spellbook.Spell;

abstract class SpellBuffArtifact extends Artifact{
    @Override
    public void apply(Hero aHero) {
        aHero.getSpells().forEach(s -> buffSpell(s) );
    }


    void buffSpell(Spell s) {

    }

    @Override
    public int getAttack() { return 0; }

    @Override
    public int getDefence() { return 0; }

    @Override
    public int getPower() { return 0; }

    @Override
    public int getKnowledge() { return 0; }
}
