import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test()
    void x()
    {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 1);
        Set set = new HashSet();
        set.add(p1);
        set.add(p2);

        assertEquals(1, set.size());
        assertTrue(set.contains(p1));
        assertTrue(set.contains(p2));

        p1.setX(2);

        assertNotEquals(p1,p2);

        assertFalse(set.contains(p1));       //F
        assertFalse(set.contains(p2));       //F
        assertEquals(1, set.size());       //F
        set.forEach(System.out::println);
    }

}