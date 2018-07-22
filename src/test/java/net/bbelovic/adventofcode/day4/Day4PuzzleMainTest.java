package net.bbelovic.adventofcode.day4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day4PuzzleMainTest {

    private static final String INPUT = "iwrupvqb";
    private static final int FIVE_ZEROS_PREFIX_RESULT = 346386;
    private static final int SIX_ZEROS_PREFIX_RESULT = 9958218;
    private static final String FIVE_ZEROS_PREFIX = "00000";
    private static final String SIX_ZEROS_PREFIX = "000000";

    @ParameterizedTest
    @MethodSource("testData")
    void
    should_solve_puzzle(String zeroPrefix, long expectedCount) {
        final Day4Puzzle puzzle = new Day4Puzzle(zeroPrefix);
        final long actualCount = puzzle.solve(INPUT);
        assertEquals(expectedCount, actualCount);

    }

    public static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(FIVE_ZEROS_PREFIX, FIVE_ZEROS_PREFIX_RESULT),
                Arguments.of(SIX_ZEROS_PREFIX, SIX_ZEROS_PREFIX_RESULT)
        );
    }
}
