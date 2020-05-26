package pl.psi.game.artifacts;

import pl.psi.game.hero.artifacts.ArtifactInfo;

import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.*;

public class ArtifactFactory {
    public static Artifact createFromInfo(ArtifactInfo aArtifactInfo) {

        return null;
    }

    //PW you should return concrete class not Artifact. For example:
    // SKULL_HELMET should return Artifact for heroes (more specific HeroAttributesArtifact)
    // BOOTS_OF_POLARITY should return Artifact for creature ( more specific CreatureMagicResistanceArtifact)
    public static Artifact createArtifact(ArtifactInfo artifactInfo){
        if (artifactInfo.equals(HELM_OF_THE_ALABASTER_UNICORN)){
            return new HeroStatisticArtifact(0,0,0,1);
        }
        else if (artifactInfo.equals(SKULL_HELMET)){
            return new HeroStatisticArtifact(0,0,0,2);
        }
        else if (artifactInfo.equals(HELM_OF_CHAOS)){
            return new HeroStatisticArtifact(0,0,0,3);
        }
        else if (artifactInfo.equals(CROWN_OF_THE_SUPREME_MAGI)){
            return new HeroStatisticArtifact(0,0,0,4);
        }
        else if (artifactInfo.equals(HELLSTORM_HELMET)){
            return new HeroStatisticArtifact(0,0,0,5);
        }
        else if (artifactInfo.equals(NECKLACE_OF_DRAGONTEETH)){
            return new HeroStatisticArtifact(0,0,3,3);
        }
        else if (artifactInfo.equals(CELESTIAL_NECKLACE_OF_BLISS)){
            return new HeroStatisticArtifact(3,3,3,3);
        }
        else if (artifactInfo.equals(COLLAR_OF_CONJURING)){
            return new SpellDurationArtifact(1);
        }
//        else if (artifactInfo.equals(PENDANT_OF_DISPASSION)){
//            return new CreatureBuffArtifact(0, 0, 0);
//        }
//        else if (artifactInfo.equals(PENDANT_OF_LIFE)){
//            return new CreatureBuffArtifact(0, 0, 0);
//        }
        else if (artifactInfo.equals(BREASTPLATE_OF_PETRIFIED_WOOD)){
            return new HeroStatisticArtifact(0,0,1,0);
        }
        else if (artifactInfo.equals(RIB_CAGE)){
            return new HeroStatisticArtifact(0,0,2,0);
        }
        else if (artifactInfo.equals(DRAGON_SCALE_ARMOR)){
            return new HeroStatisticArtifact(4,4,0,0);
        }
        else if (artifactInfo.equals(ARMOR_OF_WONDER)){
            return new HeroStatisticArtifact(1,1,1,1);
        }
        else if (artifactInfo.equals(TITANS_CUIRAS)){
            return new HeroStatisticArtifact(0,0,10,-2);
        }
        else if (artifactInfo.equals(CAPE_OF_CONJURING)){
            return new SpellDurationArtifact(3);
        }
        else if (artifactInfo.equals(DRAGON_WING_TABARD)){
            return new HeroStatisticArtifact(0,0,2,2);
        }
        else if (artifactInfo.equals(SURCOAT_OF_COUNTERPOISE)){
            return new CreatureBuffArtifact(0,10,0);
        }
//        else if (artifactInfo.equals(RECANTERS_CLOAK)){
//            return new SpellDurationArtifact(0);
//        }
        else if (artifactInfo.equals(CAPE_OF_VELOCITY)){
            return new CreatureBuffArtifact(2,0,0);
        }
        else if (artifactInfo.equals(CENTAURS_AX)){
            return new HeroStatisticArtifact(2,0,0,0);
        }
        else if (artifactInfo.equals(BLACKSHARD_OF_THE_DEAD_KNIGHT)){
            return new HeroStatisticArtifact(3,0,0,0);
        }
        else if (artifactInfo.equals(GREATER_GNOLLS_FLAIL)){
            return new HeroStatisticArtifact(4,0,0,0);
        }
        else if (artifactInfo.equals(OGRES_CLUB_OF_HAVOC)){
            return new HeroStatisticArtifact(5,0,0,0);
        }
        else if (artifactInfo.equals(TITANS_GLADIUS)){
            return new HeroStatisticArtifact(12,-3,0,0);
        }
        else if (artifactInfo.equals(SHIELD_OF_THE_DWARVEN_LORDS)){
            return new HeroStatisticArtifact(0,2,0,0);
        }
        else if (artifactInfo.equals(SHIELD_OF_THE_YAWNING_DEAD)){
            return new HeroStatisticArtifact(0,3,0,0);
        }
        else if (artifactInfo.equals(BUCKLER_OF_THE_GNOLL_KING)){
            return new HeroStatisticArtifact(0,4,0,0);
        }
        else if (artifactInfo.equals(TARG_OF_THE_RAMPAGING_OGRE)){
            return new HeroStatisticArtifact(0,5,0,0);
        }
        else if (artifactInfo.equals(SENTINELS_SHIELD)){
            return new HeroStatisticArtifact(-3,12,0,0);
        }
        else if (artifactInfo.equals(RING_OF_VITALITY)){
            return new CreatureBuffArtifact(0,0,1);
        }
        else if (artifactInfo.equals(RING_OF_LIFE)){
            return new CreatureBuffArtifact(0,0,2);
        }
        else if (artifactInfo.equals(RING_OF_CONJURING)){
            return new SpellDurationArtifact(2);
        }
        else if (artifactInfo.equals(RING_OF_THE_WAYFARER)){
            return new CreatureBuffArtifact(1,0,0);
        }
        else if (artifactInfo.equals(QUIET_EYE_OF_THE_DRAGON)){
            return new HeroStatisticArtifact(1,1,0,0);
        }
        else if (artifactInfo.equals(SANDALS_OF_THE_SAINT)){
            return new HeroStatisticArtifact(2,2,2,2);
        }
        else if (artifactInfo.equals(DRAGONBONE_GREAVES)){
            return new HeroStatisticArtifact(0,0,1,1);
        }
        else if (artifactInfo.equals(BOOTS_OF_POLARITY)){
            return new CreatureBuffArtifact(0,15,0);
        }
        else if (artifactInfo.equals(GUARDIANS_BOOTS)){
            return new HeroStatisticArtifact(0,3,0,0);
        }
        else if (artifactInfo.equals(MAGISTERS_SANDALS)){
            return new HeroStatisticArtifact(0,0,2,0);
        }
        else
            return null;
    }
}
