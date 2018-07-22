package net.bbelovic.adventofcode.day4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day4PuzzleTest {

    @ParameterizedTest
    @MethodSource("testData")
    void
    should_compute_numeric_part_of_input(String input, long expectedResult) {
        Day4Puzzle day4 = new Day4Puzzle("00000");
        long actual = day4.solve(input);
        assertEquals(expectedResult, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abcdef", 609043),
                Arguments.of("pqrstuv", 1048970)
        );
    }
}