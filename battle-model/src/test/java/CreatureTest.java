import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {

    @Test
    void creatureOneShouldLostTwoHp(){
        Creature c1 = new Creature();
        Creature c2 = new Creature();

        c2.attack(c1);

        assertEquals(8,c2.getHp());
    }

}