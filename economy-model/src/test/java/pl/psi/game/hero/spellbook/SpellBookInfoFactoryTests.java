package pl.psi.game.hero.spellbook;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import pl.psi.game.spellbook.SpellInfo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpellBookInfoFactoryTests {

    @BeforeAll
    static void initializeSpellBookInfoFactory(){
        new SpellBookInfoFactory();
    }

    private final static String STORM_ELEMENTAL = "Summon storm elemental";
    @Test
    void GetProperlySpell(){
        SpellInfo spellInfo = SpellBookInfoFactory.getSpell(STORM_ELEMENTAL);
        assertEquals(spellInfo.getName(), STORM_ELEMENTAL);
    }
}
