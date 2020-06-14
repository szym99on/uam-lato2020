package pl.psi.game.fractions;

public class CreatureStack {

    CreatureInfo creatureInfo;
    int creaturesCount;

    public CreatureStack(CreatureInfo creatureInfo, int creaturesCount) {
        this.creatureInfo = creatureInfo;
        this.creaturesCount = creaturesCount;
    }

    void removeCreatureFromStack(){
        this.setCreaturesCount(this.getCreaturesCount()-1);
    }

    public CreatureInfo getCreatureInfo() {
        return creatureInfo;
    }

    public void setCreatureInfo(CreatureInfo creatureInfo) {
        this.creatureInfo = creatureInfo;
    }

    public int getCreaturesCount() {
        return creaturesCount;
    }

    public void setCreaturesCount(int creaturesCount) {
        this.creaturesCount = creaturesCount;
    }
}
