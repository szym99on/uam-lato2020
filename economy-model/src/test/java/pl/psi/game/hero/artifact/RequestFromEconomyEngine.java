package pl.psi.game.hero.artifact;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestFromEconomyEngine {
//PW it not request for economy tis functionality is Artifact team response. Test getByLocation and other factory methods
    @BeforeAll
    static void ArtifactsInfoFactory(){
        new ArtifactsInfoFactory();
    }

    //PW
    @Test
    void xxx(){
        ArtifactInfo artifact = ArtifactsInfoFactory.getArtifact(ArtifactsInfoFactory.HELM_OF_THE_ALABASTER_UNICORN);
        assertEquals("Helm of the Alabaster Unicorn", artifact.getName());
    }
}
