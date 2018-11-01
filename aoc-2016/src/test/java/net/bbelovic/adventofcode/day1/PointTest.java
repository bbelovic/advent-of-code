package net.bbelovic.adventofcode.day1;

import org.junit.jupiter.api.Test;

import static net.bbelovic.adventofcode.day1.Direction.Left;
import static net.bbelovic.adventofcode.day1.Direction.Right;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {
    @Test
    void should_turn_left() {
        var start = new Point(0, 1);
        var expected = new Point(-1, 0 );
        assertEquals(expected, start.turn(Left));
        expected = new Point(0, -1);
        assertEquals(expected, start.turn(Left).turn(Left));
        expected = new Point(1, 0);
        assertEquals(expected, start.turn(Left).turn(Left).turn(Left));
        expected = new Point(0, 1);
        assertEquals(expected, start.turn(Left).turn(Left).turn(Left).turn(Left));
    }

    @Test
    void should_turn_right() {
        var start = new Point(0, 1);
        var expected = new Point(1, 0);
        assertEquals(expected, start.turn(Right));
        expected = new Point(0, -1);
        assertEquals(expected, start.turn(Right).turn(Right));
        expected = new Point(-1, 0);
        assertEquals(expected, start.turn(Right).turn(Right).turn(Right));
        expected = new Point(0, 1);
        assertEquals(expected, start.turn(Right).turn(Right).turn(Right).turn(Right));
    }
}