package pl.psi.game.artifacts;

import pl.psi.game.spellbook.Spell;

class SpellPreventCastingArtifact extends SpellBuffArtifact{
    @Override
    void buffSpell(Spell s) {

    }

    @Override
    public int getDuration() { return 0; }
}
