package net.bbelovic.adventofcode.day1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1PuzzlePart2Test {

    @ParameterizedTest
    @MethodSource("testData")
    void
    should_compute_position_where_first_basement_floor_is_entered(String input, long expectedResult) {
        var day1 = new Day1PuzzlePart2();
        long actualPosition = day1.solve(input);
        assertEquals(expectedResult, actualPosition);
    }

    private static Iterable<Arguments> testData() {
        return List.of(
                Arguments.of(")", 1L),
                Arguments.of("()())", 5L),
                Arguments.of("())", 3L),
                Arguments.of("))(", 1L)
        );
    }
}
