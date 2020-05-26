package pl.psi.game.artifacts;

import pl.psi.game.fractions.Creature;

class CreatureSpeedArtifact extends CreatureBuffArtifact{
    private final int speed;

    CreatureSpeedArtifact(int aSpeed){
        speed = aSpeed;
    }

    @Override
    void buffCreature(Creature c) {
//        c.increaseMoveRange(speed);
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}
