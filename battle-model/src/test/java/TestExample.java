import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestExample {

    @Test
    void x(){
        Integer intObject1 = new Integer(1);
        Integer intObject2 = new Integer(1);

        int int1 = 1;
        int int2 = 1;
        Integer intObjectCopy = intObject1;

        Integer intObject3 = new Integer(int1);

        assertEquals(int1,int2);                        //T
        assertEquals(intObject1,intObject2);            //T
        assertEquals(1,intObject2);            //T
        assertEquals(1,intObject1);             //T

        assertEquals(intObject3,intObject1);            //T
        assertTrue(intObject3.equals(intObject1));      //T

        assertTrue(int1==int2);                 // T
        assertTrue(int1==intObject1);           // F
        assertFalse(intObject1==intObject2);     // F
    }

}
