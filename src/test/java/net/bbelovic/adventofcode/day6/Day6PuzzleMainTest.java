package net.bbelovic.adventofcode.day6;

import net.bbelovic.adventofcode.InputReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Day6PuzzleMainTest {
    private static final long EXPECTED_LIGHTS_LIT_COUNT = 543903L;
    private static final InstructionsParser INSTRUCTIONS_PARSER = new DefaultInstructionsParser();
    private static final InputReader INPUT_READER = new InputReader();

    @Test
    void should_solve_puzzle() {
        final var lines = INPUT_READER.readAllLines("input6.txt");
        Day6Puzzle puzzle = new Day6Puzzle(INSTRUCTIONS_PARSER);
        var result = lines.stream()
                .mapToLong(puzzle::solve)
                .sum();
        assertEquals(EXPECTED_LIGHTS_LIT_COUNT, result);
    }
}
