import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {

    private final static int NOT_MPORTANT = 1;

    @Test
    void creatureOneShouldLostTwoHp(){
        Creature c1 = new Creature(10,NOT_MPORTANT);
        Creature c2 = new Creature(NOT_MPORTANT,2);

        c2.attack(c1);

        assertEquals(8,c1.getHp());
    }

}