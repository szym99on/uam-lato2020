package pl.psi.game.hero;

import lombok.Builder;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.hero.artifacts.ArtifactInfo;

import java.util.ArrayList;
import java.util.List;

public class EconomyHero {

//    creatures and artifacts should be supplied by other groups
    List<CreatureInfo> creatures = new ArrayList<>();
    List<ArtifactInfo> artifacts = new ArrayList<>();
    int gold = 2000;


    public EconomyHero(List<CreatureInfo> creatures){
        this.creatures = creatures;
    }
    @Builder
    public EconomyHero(List<CreatureInfo> creatures, int gold){
        this.creatures = creatures;
        this.gold = gold;
    }
    public int getGold() {
        return gold;
    }

    public void addGold(int gold){
        this.gold += gold;
    }

    //to implement
    public void buyCreature(CreatureInfo creature){
    }


    //to implement
    public void sellCreature(CreatureInfo creature){
    }

    //to implement
    public void buyArtifact(ArtifactInfo artifact){
    }

    //to implement
    public void sellArtifact(ArtifactInfo artifact){
    }


    List<ArtifactInfo> getArtifacts() {
        return new ArrayList<>();
    }
}
