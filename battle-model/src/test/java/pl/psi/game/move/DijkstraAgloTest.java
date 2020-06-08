package pl.psi.game.move;

import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DijkstraAgloTest {

    DijkstraAlgo algo = new DijkstraAlgo();

    @Test
    void goRightDistance(){
        Point startPoint = new Point(1,1);
        Point endPoint = new Point(5,1);
        int distance = algo.getDistance(startPoint, endPoint);

        assertEquals(4, distance);
    }

    @Test
    void goLeftDistance(){
        Point startPoint = new Point(5,1);
        Point endPoint = new Point(1,1);
        int distance = algo.getDistance(startPoint, endPoint);

        assertEquals(4, distance);

    }

    @Test
    void goUpDistance(){
        Point startPoint = new Point(1,1);
        Point endPoint = new Point(1,5);
        int distance = algo.getDistance(startPoint, endPoint);

        assertEquals(4, distance);
    }

    @Test
    void goDownDistance(){
        Point startPoint = new Point(1,5);
        Point endPoint = new Point(1,1);
        int distance = algo.getDistance(startPoint, endPoint);

        assertEquals(4, distance);
    }

    @Test
    void goRightUpDistance(){
        Point startPoint = new Point(1,1);
        Point endPoint = new Point(5,5);
        int distance = algo.getDistance(startPoint, endPoint);

        assertEquals(8, distance);
    }

    @Test
    void goLeftDownDistance(){
        Point startPoint = new Point(1,1);
        Point endPoint = new Point(5,1);
        int distance = algo.getDistance(startPoint, endPoint);

        assertEquals(8, distance);
    }
}
