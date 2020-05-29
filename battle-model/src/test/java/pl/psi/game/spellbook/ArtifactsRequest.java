package pl.psi.game.spellbook;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArtifactsRequest {
    @Disabled
    @Test
    void shouldIncreaseSpellDuration(){
        SpellInfo spell = SpellBookInfoFactory.getSpell("AIR_SHIELD");

        //spell.increaseDuration(1);

        //assertEquals(2,spell.getDuration());
    }

    @Disabled
    @Test
    void shouldPreventSpellCastingOfLevel3AndHigher(){
        // Recanter's Cloak prevents casting spells of level 3 and higher by both the wearer of the artifact as well as his opponent.
        // Therefore, we need a way to disable those spells in question without removing them.
    }

}
