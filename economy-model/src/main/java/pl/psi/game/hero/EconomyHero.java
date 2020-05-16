package pl.psi.game.hero;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.spellbook.SpellInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Builder
public class EconomyHero  {

    //    creatures and artifacts should be supplied by other groups
    @Singular  private List<CreatureInfo> creatures = new ArrayList<>();
    @Singular  private List<ArtifactInfo> artifacts = new ArrayList<>();
    @Singular  private List<SpellInfo> spells = new ArrayList<>();
    private int gold = 2000;


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
    void buyCreature(CreatureInfo creature){
    }


    //to implement
    void sellCreature(CreatureInfo creature){
    }

    void buyArtifact(ArtifactInfo artifact){
//        if(this.isSlotEmpty(artifact.getLocation())){
//            this.decreaseGold(artifact.getCost());
//            this.artifacts.add(artifact);
//        }
    }

    //to implement
    void sellArtifact(ArtifactInfo artifact){
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

    public void sellSpell(SpellInfo spell) {
    }

    public void buySpell(SpellInfo spell) {
    }

    List<SpellInfo> getSpells() {
    return this.spells;
    }

//request to artifact group for getter to artifact location
    List<ArtifactInfo.Location> getArtifactsLocations(){
        return this.artifacts.stream().map(ArtifactInfo::getLocation).collect(Collectors.toList());
    }
}
