package net.bbelovic.adventofcode.day6;

import org.junit.jupiter.api.Test;

import static net.bbelovic.adventofcode.day6.LightOperation.TURN_ON;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InstructionsTest {
    @Test
    void should_apply_instructions_on_grid_and_return_number_of_changes() {
        final var grid = new MatrixGrid(10, 10);
        final var instructions = new Instructions(TURN_ON, 0, 0, 1, 1);
        final long expected = 4L;
        long actual = instructions.applyOnGrid(grid);
        assertEquals(expected, actual);
    }
}
