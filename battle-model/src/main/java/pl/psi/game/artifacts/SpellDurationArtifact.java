package pl.psi.game.artifacts;

import pl.psi.game.hero.converter.Hero;
import pl.psi.game.spellbook.Spell;

class SpellDurationArtifact extends SpellBuffArtifact {
    private int duration;

    SpellDurationArtifact(int aDuration){
        duration = aDuration;
        statisticsBuffs.replace(SPELL_DURATION, duration);
    }

    @Override
    void buffSpell(Spell s) {
        s.increaseDuration(duration);
    }
}



