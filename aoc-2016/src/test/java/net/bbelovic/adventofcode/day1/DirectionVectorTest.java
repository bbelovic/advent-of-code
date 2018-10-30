package net.bbelovic.adventofcode.day1;

import org.junit.jupiter.api.Test;

import static net.bbelovic.adventofcode.day1.DirectionVector.Direction.Left;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionVectorTest {
    @Test
    void should_turn_left() {
        var start = new DirectionVector(0, 1);
        var expected = new DirectionVector(-1, 0 );
        assertEquals(expected, start.turn(Left));
        expected = new DirectionVector(0, -1);
        assertEquals(expected, start.turn(Left).turn(Left));
        expected = new DirectionVector(1, 0);
        assertEquals(expected, start.turn(Left).turn(Left).turn(Left));
        expected = new DirectionVector(0, 1);
        assertEquals(expected, start.turn(Left).turn(Left).turn(Left).turn(Left));
    }

}