package pl.psi.game.artifacts;

import pl.psi.game.hero.converter.Hero;

class CreatureBuffArtifact extends Artifact {
    private final int speed;
    private final int magicResistance;
    private final int health;

    CreatureBuffArtifact(int aSpeed, int aMagicResistance, int aHealth){
        speed = aSpeed;
        magicResistance = aMagicResistance;
        health = aHealth;
    }
    @Override
    public void apply(Hero aHero) {

    }

    @Override
    public int getAttack() {
        return 0;
    }
}
