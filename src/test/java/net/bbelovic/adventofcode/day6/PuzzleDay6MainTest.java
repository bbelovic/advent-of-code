package net.bbelovic.adventofcode.day6;

import net.bbelovic.adventofcode.InputReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PuzzleDay6MainTest {
    private static final long EXPECTED_LIGHTS_LIT_COUNT = 543903L;
    private static final InstructionsParser INSTRUCTIONS_PARSER = new InstructionsParser();
    private static final InputReader INPUT_READER = new InputReader();

    @Test
    void test_for_first_part_of_puzzle() {
        final var lines = INPUT_READER.readAllLines("input6.txt");
        PuzzleDay6 puzzle = new PuzzleDay6(INSTRUCTIONS_PARSER);
        var result = lines.stream()
                .mapToLong(puzzle::solve)
                .sum();
        assertEquals(EXPECTED_LIGHTS_LIT_COUNT, result);
    }
}
