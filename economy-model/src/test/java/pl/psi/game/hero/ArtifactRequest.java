package pl.psi.game.hero;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.hero.artifacts.ArtifactsInfoFactory;
import pl.psi.game.hero.economyHero.EconomyHero;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ArtifactRequest {

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

    @Disabled
    @Test
    void shouldReturnArtifactsByLocation(){
        EconomyHero hero = EconomyHero.builder().build();
        ArtifactInfo artifact = ArtifactsInfoFactory.getArtifact("Skull helmet");
//        hero.equip(artifact);

//        assertEquals(artifact,hero.getArtifactsByLocation(HEAD));
    }

    @Disabled
    @Test
    void shouldEquipIfSlotAvailable(){
        EconomyHero hero = EconomyHero.builder().build();
        ArtifactInfo artifact1 = ArtifactsInfoFactory.getArtifact("Skull helmet");
        ArtifactInfo artifact2 = ArtifactsInfoFactory.getArtifact("Helm of Chaos");

//        hero.equip(artifact1); //.equip should check if appropriate slot (in this instance HEAD) is available for the artifact
//        hero.equip(artifact2);

//        assertEquals(artifact1,hero.getArtifactsByLocation(HEAD));
//        assertNotEquals(artifact2, hero.getArtifacts());
    }



    @Disabled
    @Test
    void shouldUnequipArtifact(){
        EconomyHero hero = EconomyHero.builder().build();
        ArtifactInfo artifact = ArtifactsInfoFactory.getArtifact("Skull helmet");
//        hero.equip(artifact);

//        hero.unequip(HEAD);

//        assertNotEquals(artifact,hero.getArtifactsByLocation(HEAD));
    }



}
