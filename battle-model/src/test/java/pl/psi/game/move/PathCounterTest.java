package pl.psi.game.move;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;


class PathCounterTest {
    PathCounter pathCounterFly = new PathCounter("fly");
    PathCounter pathCounterWalk = new PathCounter("walk");

    @Test
    void test1(){
        pathCounterWalk.countPath(new Point(1,1), new Point(1,5), new LinkedList());
    }

}
