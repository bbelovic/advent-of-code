package net.bbelovic.adventofcode.day1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1PuzzlePart1Test {
    @ParameterizedTest
    @MethodSource("testData")
    void
    should_compute_floor_from_input(String input, long expectedResult) {
        var day1 = new Day1PuzzlePart1();
        long actualResult = day1.solve(input);
        assertEquals(expectedResult, actualResult);
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("(((", 3L),
                Arguments.of("(())", 0L),
                Arguments.of("))(((((", 3L),
                Arguments.of("()()", 0L),
                Arguments.of("())", -1L),
                Arguments.of(")))", -3L),
                Arguments.of(")())())", -3L)
        );
    }
}
