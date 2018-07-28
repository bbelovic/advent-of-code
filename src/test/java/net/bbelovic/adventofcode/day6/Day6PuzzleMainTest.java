package net.bbelovic.adventofcode.day6;

import net.bbelovic.adventofcode.InputReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Day6PuzzleMainTest {
    private static final long EXPECTED_LIGHTS_LIT_COUNT = 543903L;
    private static final InputReader INPUT_READER = new InputReader();

    @Test
    void should_solve_puzzle() {
        final var lines = INPUT_READER.readAllLines("input6.txt");
        DefaultInstructionsParser<Grid<Boolean>> parser = new DefaultInstructionsParser<>(LightOperation::valueOf);
        Day6Puzzle<Grid<Boolean>> puzzle = new Day6Puzzle<>(new MatrixGrid(1000, 1000), parser);
        var result = lines.stream()
                .mapToLong(puzzle::solve)
                .sum();
        assertEquals(EXPECTED_LIGHTS_LIT_COUNT, result);
    }
}
