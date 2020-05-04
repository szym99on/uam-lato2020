package pl.psi.game.hero.artifacts;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.hero.converter.Hero;
import static org.junit.jupiter.api.Assertions.*;

public class ArtifactTest {
    @Test
    @Disabled
    void artifactShouldIncreaseKnowledgeBy2Point(){
        Hero hero = Hero.builder.aKnowledge(7).build();
        ArtifactInfo artifactInfo = ArtifactsInfoFactory.getArtifact("Skull helmet");
        ArtifactsFactory factory = new ArtifactsFactory();
        Artifact artifact = factory.getArtifact(artifactInfo);

        artifact.buff(hero);

        assertEquals(9, hero.getKnowledge());
    }
}
