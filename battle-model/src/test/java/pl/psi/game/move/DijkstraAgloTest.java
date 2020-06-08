package pl.psi.game.move;

import org.junit.jupiter.api.Test;
import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void getFourNeighbors(){
        Point point = new Point(2, 2);
        List<Point> neighbors = algo.getNeighbors(point);

        assertTrue(neighbors.contains(new Point(1, 2)));
        assertTrue(neighbors.contains(new Point(3, 2)));
        assertTrue(neighbors.contains(new Point(2, 1)));
        assertTrue(neighbors.contains(new Point(2, 3)));
        assertFalse(neighbors.contains(new Point(10, 10)));
    }

    @Test
    void getTwoNeighbors(){
        Point point = new Point(1, 1);
        List<Point> neighbors = algo.getNeighbors(point);

        assertTrue(neighbors.contains(new Point(1, 2)));
        assertTrue(neighbors.contains(new Point(2, 1)));
        assertFalse(neighbors.contains(new Point(0, 1)));
        assertFalse(neighbors.contains(new Point(1, 0)));
    }
}
