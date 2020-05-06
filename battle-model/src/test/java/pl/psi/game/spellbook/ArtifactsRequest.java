package pl.psi.game.spellbook;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArtifactsRequest {

    @Test
    void shouldReturnSpellDuration(){
        SpellInfo spell = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.AIR_SHIELD);
        assertEquals("Air shield", spell.getName());
        assertEquals(1, spell.getDuration());
    }
    
}
