package net.bbelovic.adventofcode.day6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day6PuzzlePart2Test {
    @ParameterizedTest
    @MethodSource("testData")
    void
    should_compute_total_brightness(String line, long expectedBrightness) {
        BrightnessInstructionsParser parser = new BrightnessInstructionsParser();
        Day6Puzzle puzzle = new Day6Puzzle(new BrightnessGrid(width), parser);
        long actualBrightness = puzzle.solve(line);
        assertEquals(expectedBrightness, actualBrightness);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("turn on 0,0 through 0,0", 1),
                Arguments.of("toogle 0,0 through 999,999", 2_000_000)
        );
    }
}
