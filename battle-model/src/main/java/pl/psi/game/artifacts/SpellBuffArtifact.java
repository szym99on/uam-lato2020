package pl.psi.game.artifacts;

import pl.psi.game.hero.converter.Hero;
import pl.psi.game.spellbook.Spell;

abstract class SpellBuffArtifact extends Artifact{
    @Override
    public void apply(Hero aHero) {
        aHero.getSpellBook().getSpells().forEach(s -> buffSpell(s) );
    }


    abstract void buffSpell(Spell s);

    //For tests
    @Override
    public int getAttack() { return 0; }

    @Override
    public int getDefence() { return 0; }

    @Override
    public int getPower() { return 0; }

    @Override
    public int getKnowledge() { return 0; }

    @Override
    public int getSpeed() { return 0; }

    @Override
    public int getHealth() { return 0; }

    @Override
    public int getMagicResistance() { return 0; }
}
