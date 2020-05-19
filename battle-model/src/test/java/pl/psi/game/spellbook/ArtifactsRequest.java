package pl.psi.game.spellbook;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArtifactsRequest {

    @Disabled
    @Test
    void shouldReturnSpellDuration(){
        SpellInfo spell = SpellBookInfoFactory.getSpell("AIR_SHIELD");

        assertEquals(1, spell.getDuration());
    }

    @Disabled
    @Test
    void shouldIncreaseSpellDuration(){
        SpellInfo spell = SpellBookInfoFactory.getSpell("AIR_SHIELD");

        spell.increaseDuration(1);

        assertEquals(2,spell.getDuration());
    }

}
