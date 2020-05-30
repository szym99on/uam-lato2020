package pl.psi.game.move;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenerateMovepointsTest {
    boolean NOT_IMPORTANT = false;

    @Test
    void testAllTheSlowestCreatureWithoutOtherStuff(){
        GenerateMovepoints points = new GenerateMovepoints(NOT_IMPORTANT,NOT_IMPORTANT,NOT_IMPORTANT,NOT_IMPORTANT,NOT_IMPORTANT);

        assertEquals(points.movementPoints(3),1500);
        assertEquals(points.movementPoints(4),1560);
        assertEquals(points.movementPoints(5),1630);
        assertEquals(points.movementPoints(6),1700);
        assertEquals(points.movementPoints(7),1760);
        assertEquals(points.movementPoints(8),1830);
        assertEquals(points.movementPoints(9),1900);
        assertEquals(points.movementPoints(10),1960);
        assertEquals(points.movementPoints(11),2000);
        assertEquals(points.movementPoints(12),2000);
    }

    @Test
    void artifactsAddPoints(){
        GenerateMovepoints points1 = new GenerateMovepoints(true,NOT_IMPORTANT,NOT_IMPORTANT,NOT_IMPORTANT,NOT_IMPORTANT);
        assertEquals(points1.movementPoints(3),2000);

        GenerateMovepoints points2 = new GenerateMovepoints(NOT_IMPORTANT,true,NOT_IMPORTANT,NOT_IMPORTANT,NOT_IMPORTANT);
        assertEquals(points2.movementPoints(3),1800);

        GenerateMovepoints points3 = new GenerateMovepoints(NOT_IMPORTANT,NOT_IMPORTANT,true,NOT_IMPORTANT,NOT_IMPORTANT);
        assertEquals(points3.movementPoints(3),2000);

        GenerateMovepoints points4 = new GenerateMovepoints(NOT_IMPORTANT,NOT_IMPORTANT,NOT_IMPORTANT,true,true);
        assertEquals(points4.movementPoints(3),2000);

        GenerateMovepoints points5 = new GenerateMovepoints(NOT_IMPORTANT,NOT_IMPORTANT,NOT_IMPORTANT,true,NOT_IMPORTANT);
        assertEquals(points5.movementPoints(3),1500);
    }

}
