package net.bbelovic.adventofcode.day1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1PuzzlePart1Test {
    @ParameterizedTest
    @MethodSource("testData")
    void should_compute_distance_from_start(String input, int expectedDistance) {
        long actualDistance = new Day1PuzzlePart1().solve(input);
        assertEquals(expectedDistance, actualDistance);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(Arguments.of("R2, L3", 5),
                Arguments.of("R2, R2, R2", 2), Arguments.of("R5, L5, R5, R3", 12));
    }
}
