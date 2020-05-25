package pl.psi.game.artifacts;

import pl.psi.game.hero.artifacts.ArtifactInfo;

import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.HELM_OF_THE_ALABASTER_UNICORN;

public class ArtifactFactory {
    public static Artifact createFromInfo(ArtifactInfo aArtifactInfo) {

        return null;
    }

    //PW you should return concrete class not Artifact. For example:
    // SKULL_HELMET should return Artifact for heroes (more specific HeroAttributesArtifact)
    // BOOTS_OF_POLARITY should return Artifact for creature ( more specific MagicResistanceForCreatureArtifact)
    public static Artifact createArtifact(ArtifactInfo artifactInfo){
//        if (artifactInfo.equals(HELM_OF_THE_ALABASTER_UNICORN)){
//            return new HeroStatisticBuffArtifact(0,0,1,0);
//        }
//        if (artifactInfo.equals(SKULL_HELMET)){
//            return new HeroStatisticBuffArtifact(0,0,2,0);
//        }
//        if (artifactInfo.equals(SURCOAT_OF_COUNTERPOISE)){
//            return new CreatureResistanceArtifact(10);
//        }
//        if{
//
//        }


//        return Artifact.builder().aName(artifactInfo.getName()).aLocation(artifactInfo.getLocation()).build();
        return null;
    }
}
