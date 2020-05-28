package pl.psi.game.artifacts;

import pl.psi.game.fractions.Creature;

class CreatureHealthArtifact extends CreatureBuffArtifact{
    private final int health;

    CreatureHealthArtifact(int aHealth){
        health = aHealth;
    }

    @Override
    void buffCreature(Creature c) {
//        c.increaseHP(c);
    }

    @Override
    public int getHealth() { return health; }

    @Override
    public int getSpeed() { return 0; }
}
