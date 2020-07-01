package pl.psi.game.hero.artifacts;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.psi.game.artifacts.Artifact;
import pl.psi.game.artifacts.ArtifactFactory;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.spellbook.SpellBookInfoFactory;
import pl.psi.game.spellbook.SpellInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.CAPE_OF_CONJURING;
import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.RING_OF_CONJURING;
import static pl.psi.game.spellbook.SpellBookInfoFactory.BLOODLUST;
import static pl.psi.game.spellbook.SpellBookInfoFactory.HASTE;

public class SpellBuffArtifactTest {
    @BeforeAll
    static void initializeFactories() {
        new ArtifactsInfoFactory();
        new ArtifactFactory();
        new SpellBookInfoFactory();
    }

    @Test
    void artifactShouldIncreaseSpellDurationBy2() {
        //given
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact(RING_OF_CONJURING);
        Artifact ringOfConjuring = ArtifactFactory.createArtifact(artifactInfo);

        SpellInfo spellInfo = SpellBookInfoFactory.getSpell(HASTE);
        Hero battleHero = Hero.builder().build();
        battleHero.getSpellBook().createSpell(spellInfo);

        //when
        try {
            ringOfConjuring.apply(battleHero);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //then
        assertEquals(3, battleHero.getSpellBook().getSpells().get(0).getDuration());
    }
}
