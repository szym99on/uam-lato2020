package pl.psi.game.artifacts;

import pl.psi.game.hero.artifacts.ArtifactInfo;

import static pl.psi.game.hero.artifacts.ArtifactsInfoFactory.*;

public class ArtifactFactory {
    public static Artifact createArtifact(ArtifactInfo artifactInfo){
        if (artifactInfo.getName().equals(HELM_OF_THE_ALABASTER_UNICORN)){
            return new HeroStatisticArtifact(0,0,0,1);
        }
        else if (artifactInfo.getName().equals(SKULL_HELMET)){
            return new HeroStatisticArtifact(0,0,0,2);
        }
        else if (artifactInfo.getName().equals(HELM_OF_CHAOS)){
            return new HeroStatisticArtifact(0,0,0,3);
        }
        else if (artifactInfo.getName().equals(CROWN_OF_THE_SUPREME_MAGI)){
            return new HeroStatisticArtifact(0,0,0,4);
        }
        else if (artifactInfo.getName().equals(HELLSTORM_HELMET)){
            return new HeroStatisticArtifact(0,0,0,5);
        }
        else if (artifactInfo.getName().equals(NECKLACE_OF_DRAGONTEETH)){
            return new HeroStatisticArtifact(0,0,3,3);
        }
        else if (artifactInfo.getName().equals(CELESTIAL_NECKLACE_OF_BLISS)){
            return new HeroStatisticArtifact(3,3,3,3);
        }
        else if (artifactInfo.getName().equals(COLLAR_OF_CONJURING)){
            return new SpellDurationArtifact(1);
        }
//        else if (artifactInfo.getName().equals(PENDANT_OF_DISPASSION)){
//            return new CreatureImmunityArtifact();
//        }
//        else if (artifactInfo.getName().equals(PENDANT_OF_LIFE)){
//            return new CreatureImmunityArtifact();
//        }
        else if (artifactInfo.getName().equals(BREASTPLATE_OF_PETRIFIED_WOOD)){
            return new HeroStatisticArtifact(0,0,1,0);
        }
        else if (artifactInfo.getName().equals(RIB_CAGE)){
            return new HeroStatisticArtifact(0,0,2,0);
        }
        else if (artifactInfo.getName().equals(DRAGON_SCALE_ARMOR)){
            return new HeroStatisticArtifact(4,4,0,0);
        }
        else if (artifactInfo.getName().equals(ARMOR_OF_WONDER)){
            return new HeroStatisticArtifact(1,1,1,1);
        }
        else if (artifactInfo.getName().equals(TITANS_CUIRAS)){
            return new HeroStatisticArtifact(0,0,10,-2);
        }
        else if (artifactInfo.getName().equals(CAPE_OF_CONJURING)){
            return new SpellDurationArtifact(3);
        }
        else if (artifactInfo.getName().equals(DRAGON_WING_TABARD)){
            return new HeroStatisticArtifact(0,0,2,2);
        }
        else if (artifactInfo.getName().equals(SURCOAT_OF_COUNTERPOISE)){
            return new CreatureMagicResistanceArtifact(10);
        }
//        else if (artifactInfo.getName().equals(RECANTERS_CLOAK)){
//            return new SpellPreventCastingArtifact(0);
//        }
        else if (artifactInfo.getName().equals(CAPE_OF_VELOCITY)){
            return new CreatureSpeedArtifact(2);
        }
        else if (artifactInfo.getName().equals(CENTAURS_AX)){
            return new HeroStatisticArtifact(2,0,0,0);
        }
        else if (artifactInfo.getName().equals(BLACKSHARD_OF_THE_DEAD_KNIGHT)){
            return new HeroStatisticArtifact(3,0,0,0);
        }
        else if (artifactInfo.getName().equals(GREATER_GNOLLS_FLAIL)){
            return new HeroStatisticArtifact(4,0,0,0);
        }
        else if (artifactInfo.getName().equals(OGRES_CLUB_OF_HAVOC)){
            return new HeroStatisticArtifact(5,0,0,0);
        }
        else if (artifactInfo.getName().equals(TITANS_GLADIUS)){
            return new HeroStatisticArtifact(12,-3,0,0);
        }
        else if (artifactInfo.getName().equals(SHIELD_OF_THE_DWARVEN_LORDS)){
            return new HeroStatisticArtifact(0,2,0,0);
        }
        else if (artifactInfo.getName().equals(SHIELD_OF_THE_YAWNING_DEAD)){
            return new HeroStatisticArtifact(0,3,0,0);
        }
        else if (artifactInfo.getName().equals(BUCKLER_OF_THE_GNOLL_KING)){
            return new HeroStatisticArtifact(0,4,0,0);
        }
        else if (artifactInfo.getName().equals(TARG_OF_THE_RAMPAGING_OGRE)){
            return new HeroStatisticArtifact(0,5,0,0);
        }
        else if (artifactInfo.getName().equals(SENTINELS_SHIELD)){
            return new HeroStatisticArtifact(-3,12,0,0);
        }
        else if (artifactInfo.getName().equals(RING_OF_VITALITY)){
            return new CreatureHealthArtifact(1);
        }
        else if (artifactInfo.getName().equals(RING_OF_LIFE)){
            return new CreatureHealthArtifact(2);
        }
        else if (artifactInfo.getName().equals(RING_OF_CONJURING)){
            return new SpellDurationArtifact(2);
        }
        else if (artifactInfo.getName().equals(RING_OF_THE_WAYFARER)){
            return new CreatureSpeedArtifact(1);
        }
        else if (artifactInfo.getName().equals(QUIET_EYE_OF_THE_DRAGON)){
            return new HeroStatisticArtifact(1,1,0,0);
        }
        else if (artifactInfo.getName().equals(SANDALS_OF_THE_SAINT)){
            return new HeroStatisticArtifact(2,2,2,2);
        }
        else if (artifactInfo.getName().equals(DRAGONBONE_GREAVES)){
            return new HeroStatisticArtifact(0,0,1,1);
        }
        else if (artifactInfo.getName().equals(BOOTS_OF_POLARITY)){
            return new CreatureMagicResistanceArtifact(15);
        }
        else if (artifactInfo.getName().equals(GUARDIANS_BOOTS)){
            return new HeroStatisticArtifact(0,3,0,0);
        }
        else if (artifactInfo.getName().equals(MAGISTERS_SANDALS)){
            return new HeroStatisticArtifact(0,0,2,0);
        }
        else
            throw new UnsupportedOperationException("Incorrect ArtifactInfo");
    }
}
