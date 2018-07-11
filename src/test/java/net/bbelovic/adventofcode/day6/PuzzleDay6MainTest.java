package net.bbelovic.adventofcode.day6;

import net.bbelovic.adventofcode.InputReader;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PuzzleDay6MainTest {
    private static final long EXPECTED_LIGHTS_LIT_COUNT = 543903L;
    private static final InstructionsParser INSTRUCTIONS_PARSER = new InstructionsParser();
    private static final InputReader INPUT_READER = new InputReader();

    @Test
    public void test_for_first_part_of_puzzle() {
        final var lines = INPUT_READER.readAllLines("input6.txt");
        PuzzleDay6 puzzle = new PuzzleDay6(INSTRUCTIONS_PARSER);
        for (var eachLine: lines) {
            puzzle.solve(eachLine);
        }
        assertEquals(EXPECTED_LIGHTS_LIT_COUNT, puzzle.countLights());
    }
}
