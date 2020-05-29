package pl.psi.game.hero.economyHero;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import pl.psi.game.fractions.CreatureInfo;
import pl.psi.game.hero.HeroInfo;
import pl.psi.game.hero.artifacts.ArtifactInfo;
import pl.psi.game.spellbook.SpellInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public class EconomyHero {

    private List<CreatureInfo> creatures;
    private List<ArtifactInfo> artifacts;
    private List<SpellInfo> spells;
    private int gold = 2000;
    private HeroInfo heroInfo;


    @Builder
    EconomyHero(int aGold, HeroInfo aHeroInfo) {
        gold = aGold;
        creatures = new ArrayList<>();
        artifacts = new ArrayList<>();
        spells = new ArrayList<>();
        this.heroInfo = aHeroInfo;
    }

    void increaseGold(int gold) {

        this.gold += gold;
    }

    void decreaseGold(int gold)  {

        if (gold < 0) {
            String output = String.format("You can't decrease a negative gold");
            throw new IllegalStateException(output);
        }
        int secgold = this.getGold() - gold;

        if (secgold < 0) {
            String output = String.format("Not enough gold to decrease");
            throw new IllegalStateException(output);
        }
        this.gold -= gold;


    }

    void buyCreature(CreatureInfo creature) throws Exception {
        if (this.getGold() >= creature.getCost()) {

            this.decreaseGold(creature.getCost());
            this.creatures.add(creature);

        } else {
            String output = String.format("Not enough gold to buy creature: %s", creature.getName());
            throw new Exception(output);
        }

    }

    void sellCreature(CreatureInfo creature) throws Exception {

        if (!this.creatures.contains(creature)) {
            String output = String.format("Hero doesn't have creature: %s", creature.getName());
            throw new Exception(output);
        }
        int sellCreatureValue = (int) (creature.getCost() * 0.75);

        this.increaseGold(sellCreatureValue);
        this.creatures.remove(creature);

    }

    List<CreatureInfo> getCreatures() {
        return this.creatures;
    }

    void buyArtifact(ArtifactInfo artifact) throws Exception {
        if (this.isSlotEmpty(artifact.getLocation().toString())) {
            String output = String.format("Location: %s is taken.", artifact.getLocation().toString());
            throw new Exception(output);
        }
        if (this.getGold() >= artifact.getCost()) {
            this.decreaseGold(artifact.getCost());
            this.artifacts.add(artifact);
        } else {
            String output = String.format("Not enough gold to buy %s", artifact.getName());
            throw new Exception(output);
        }

    }

    void sellArtifact(ArtifactInfo artifact) throws Exception {
        if (!this.artifacts.contains(artifact)) {
            String output = String.format("Hero doesn't have artifact: %s", artifact.getName());
            throw new Exception(output);
        }
        int sellArtifactValue = (int) (artifact.getCost() * 0.75);
        this.increaseGold(sellArtifactValue);
        this.artifacts.remove(artifact);
    }


    boolean isSlotEmpty(String location) {
        return this.artifacts.stream().anyMatch(artifact -> artifact.getLocation().toString().equals(location));
    }

    List<ArtifactInfo> getArtifacts() {
        return this.artifacts;
    }

    ArtifactInfo getArtifact(String name) {
        return this.artifacts.stream().filter(artifact -> artifact.getName().equals(name)).findAny().orElse(null);
    }


    ArtifactInfo getArtifactByLocation(ArtifactInfo.Location location) {
        return this.artifacts.stream().filter(artifact -> artifact.getLocation() == location).findAny().orElseThrow();
    }


    public void sellSpell(SpellInfo spell) throws Exception {
        if (!this.spells.contains(spell)) {
            String output = String.format("Hero doesn't have spell: %s", spell.getName());
            throw new Exception(output);
        }
        int sellSpellValue = (int) (spell.getCost() * 0.75);
        this.increaseGold(sellSpellValue);
        this.spells.remove(spell);
    }

    public void buySpell(SpellInfo spell) throws Exception{
        if(this.spells.contains(spell)){
            String output = String.format("Hero has got this spell %s ", spell.getName());
            throw new Exception(output);
        }
        if(getGold() >= spell.getCost()){
            this.decreaseGold(spell.getCost());
            this.spells.add(spell);
        }
    }

    List<SpellInfo> getSpells() {
        return this.spells;
    }

    //request to artifact group for getter to artifact location
    List<ArtifactInfo.Location> getArtifactsLocations() {
        return this.artifacts.stream().map(ArtifactInfo::getLocation).collect(Collectors.toList());
    }

    void addCreature(CreatureInfo creature) {
        this.creatures.add(creature);
    }

    void addArtifact(ArtifactInfo artifact) {
        this.artifacts.add(artifact);
    }

    void addSpell(SpellInfo spell) {
        this.spells.add(spell);
    }



    //methods from heroInfo

    HeroInfo.Fraction getFraction() {
        return heroInfo.getFraction();
    }

    HeroInfo getHeroInfo() {return heroInfo;}

    String getName() {
        return this.heroInfo.getName();
    }
    int getAttack() {
        System.out.println("I am in the getAttack");
        return this.heroInfo.getAttack();
    }
    int getDefense() {
        return this.heroInfo.getDefense();
    }
    int getPower() {
        return this.heroInfo.getPower();
    }
    int getKnowledge() {
        return this.heroInfo.getKnowledge();
    }

}
