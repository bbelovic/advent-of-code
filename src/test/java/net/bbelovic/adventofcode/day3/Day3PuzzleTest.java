package net.bbelovic.adventofcode.day3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day3PuzzleTest {

    private final Day3Puzzle day3Puzzle = new Day3Puzzle();

    @ParameterizedTest
    @MethodSource("testData")
    void
    should_return_number_of_locations_visited_at_least_once(String input, int expectedLocationCount) {
        var actualLocationCount = day3Puzzle.getLocationVisitedOnce(input);
        assertEquals(expectedLocationCount, actualLocationCount);
    }

    @ParameterizedTest
    @MethodSource("testData2Santas")
    void
    should_return_number_of_location_visited_at_least_once_with_2_santas_in_action(String input, long expectedLocationCount) {
        var actualLocationCount = day3Puzzle.getLocationVisitedOnceTwoSantas(input);
        assertEquals(expectedLocationCount, actualLocationCount);
    }


    static Iterable<Arguments> testData() {
        return List.of(
                Arguments.of("^v", 2, 3),
                Arguments.of("^>v<", 4, 3),
                Arguments.of("^v^v^v^v^v", 2, 11)
        );
    }

    static Iterable<Arguments> testData2Santas() {
        return List.of(
                Arguments.of("^v", 3),
                Arguments.of("^>v<", 3),
                Arguments.of("^v^v^v^v^v", 11)
        );
    }
}
