package pl.psi.game.hero;

import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.spellbook.SpellBook;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import pl.psi.game.spellbook.SpellInfo;

import java.util.ArrayList;
import java.util.List;

public class SpellBookRequest {

    /*@Test
    void ApplyEffectsOfArtifactOnSpell()
    {
        SpellBook spellBook = new SpellBook();
        SpellBookInfoFactory spellBookInfoFactory = new SpellBookInfoFactory();
        spellBook.addSpell(spellBookInfoFactory.getSpell(SpellInfo.Type.AIR.MAGIC_ARROW));

        ArtifactsInfoFactory artifactsInfoFactory = new ArtifactsInfoFactory();
        ////ArtifactInfo artifact = artifactsInfoFactory.getByType(ArtifactInfo.Location.FINGERS).stream().findFirst();
        List<Spell> spells = new ArrayList<Spell>();
        spells=spellBook.getSpells();
        spells.forEach(s -> s.applyEffectsOfArtifact(artifact);)
    }*/
}
