package net.bbelovic.adventofcode.day3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day3PuzzlePart2Test {

    @ParameterizedTest
    @MethodSource("testData")
    void
    should_return_number_of_location_visited_at_least_once_with_2_santas_in_action(String input, long expectedLocationCount) {
        Day3PuzzlePart2 day3Part2 = new Day3PuzzlePart2();
        var actualLocationCount = day3Part2.solve(input);
        assertEquals(expectedLocationCount, actualLocationCount);
    }

    static Iterable<Arguments> testData() {
        return List.of(
                Arguments.of("^v", 3),
                Arguments.of("^>v<", 3),
                Arguments.of("^v^v^v^v^v", 11)
        );
    }
}