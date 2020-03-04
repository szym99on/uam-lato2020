import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SegmentTest {

    @Test
    void x(){
        Point startP = new Point(1, 1);
        Point startP2 = new Point (startP);
        Point endP = new Point(5, 1);

        Segment s1 = new Segment(startP, endP);
        Segment s2 = new Segment(startP2, endP);

        s1.getStartPoint().setY(2);

        assertNotEquals(s1,s2);
    }

}