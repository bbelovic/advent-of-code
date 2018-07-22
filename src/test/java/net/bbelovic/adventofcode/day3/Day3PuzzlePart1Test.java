package net.bbelovic.adventofcode.day3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day3PuzzlePart1Test {

    @ParameterizedTest
    @MethodSource("testData")
    void
    should_return_number_of_locations_visited_at_least_once(String input, int expectedLocationCount) {
        Day3PuzzlePart1 day3Part1 = new Day3PuzzlePart1();
        var actualLocationCount = day3Part1.solve(input);
        assertEquals(expectedLocationCount, actualLocationCount);
    }

    static Iterable<Arguments> testData() {
        return List.of(
                Arguments.of("^v", 2, 3),
                Arguments.of("^>v<", 4, 3),
                Arguments.of("^v^v^v^v^v", 2, 11)
        );
    }
}