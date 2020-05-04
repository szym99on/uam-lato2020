package pl.psi.game.hero.artifacts;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.hero.converter.Hero;
import pl.psi.game.spellbook.SpellBook;

import static org.junit.jupiter.api.Assertions.*;

public class ArtifactTest {
    @Test
    @Disabled
    void artifactShouldIncreaseKnowledgeBy2Points(){
        Hero hero = Hero.builder.aKnowledge(7).build();
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact("Skull helmet");
        ArtifactsFactory factory = new ArtifactsFactory();
        Artifact artifact = factory.getArtifact(artifactInfo);

        artifact.buffSkill(hero);

        assertEquals(9, hero.getKnowledge());
    }
    @Test
    @Disabled
    void artifactShouldIncreaseSpellDurationBy1Point (){
        Spell spell = Spell.builder.aDuration(2).build();
        Artifact artifact = new Artifact(ArtifactsInfoFactory.getArtifact("Collar of Conjurin"));

        artifact.buffSpell(spell);

        assertEquals(3, spell.getDuration());
    }
}
