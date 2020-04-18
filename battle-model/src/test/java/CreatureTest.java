import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {

    private final static int NOT_IMPORTANT_1 = 1;
    private final static int NOT_IMPORTANT_0 = 0;

    @Test
    void creatureOneShouldLostTwoHp(){
        Creature c1 = new Creature(10, NOT_IMPORTANT_1, NOT_IMPORTANT_0);
        Creature c2 = new Creature(NOT_IMPORTANT_0,2, NOT_IMPORTANT_0);

        c2.attack(c1);

        assertEquals(8,c1.getHp());
    }

    @Test
    void creatureShouldLostOneHpBecauseHasOneDefence(){
        Creature defender = new Creature(10, NOT_IMPORTANT_1,1);
        Creature attacker = new Creature(NOT_IMPORTANT_1,2, NOT_IMPORTANT_1);

        attacker.attack(defender);

        assertEquals(9,defender.getHp());
    }


}