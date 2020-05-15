package pl.psi.game.hero;

import lombok.Builder;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.hero.artifacts.ArtifactInfo;

import java.util.ArrayList;
import java.util.List;

public class EconomyHero  {

//    creatures and artifacts should be supplied by other groups
    private List<CreatureInfo> creatures = new ArrayList<>();
    private List<ArtifactInfo> artifacts = new ArrayList<>();
    private int gold = 2000;



    @Builder
    public EconomyHero(List<CreatureInfo> creatures, List<ArtifactInfo> artifacts, int gold){
        this.creatures = creatures;
        this.artifacts = artifacts;
        this.gold = gold;
    }

    int getGold() {
        return gold;
    }

    void addGold(int gold){
        this.gold += gold;
    }
    private void decreaseGold(int gold){
        this.gold -= gold;
    }

    //to implement
    private void buyCreature(CreatureInfo creature){
    }


    //to implement
    private void sellCreature(CreatureInfo creature){
    }

    void buyArtifact(ArtifactInfo artifact){
//        if(this.isSlotEmpty(artifact.getLocation())){
//            this.decreaseGold(artifact.getCost());
//            this.artifacts.add(artifact);
//        }
    }

    //to implement
    private void sellArtifact(ArtifactInfo artifact){
    }


    //Don't know why it always return false
    boolean isSlotEmpty(String location){
        return !this.artifacts.stream().anyMatch(artifact -> artifact.getLocation().equals(location));
    }

    List<ArtifactInfo> getArtifacts() {
        return this.artifacts;
    }

    ArtifactInfo getArtifact(String name){
        return this.artifacts.stream().filter(artifact -> artifact.getName().equals(name)).findAny().orElse(null);
    }

//request to artifact group for getter to artifact location
//    List<Location> getArtifactsLocations(){
//        return this.artifacts.stream().map(artifact -> artifact.getLocation().collectors(Collect.toList()));
//    }
}
