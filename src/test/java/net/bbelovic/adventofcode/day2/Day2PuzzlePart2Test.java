package net.bbelovic.adventofcode.day2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day2PuzzlePart2Test {

    @ParameterizedTest
    @MethodSource("testData")
    void
    should_compute_ribbon_usage(String input, long expectedRibbonUsage) {
        Day2PuzzlePart2 day2 = new Day2PuzzlePart2();
        long actualRibbonUsage = day2.solve(input);
        assertEquals(expectedRibbonUsage, actualRibbonUsage);
    }

    public static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("1x1x10", 14L),
                Arguments.of("2x3x4", 34L)
        );
    }
}
