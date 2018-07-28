package net.bbelovic.adventofcode.day6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day6PuzzlePart1Test {
    private static final DefaultInstructionsParser<Grid<Boolean>> INSTRUCTIONS_PARSER =
            new DefaultInstructionsParser<>(LightOperation::valueOf);

    @ParameterizedTest
    @MethodSource("testData")
    void should_compute_number_lights_on(String line, long expectedLightsOnCount) {
        Day6Puzzle<Grid<Boolean>> puzzle = new Day6Puzzle<>(new MatrixGrid(1000, 1000), INSTRUCTIONS_PARSER);
        long actualLightsOnCount = puzzle.solve(line);
        assertEquals(expectedLightsOnCount, actualLightsOnCount);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("turn on 0,0 through 999,999", 1_000_000),
                Arguments.of("toggle 0,0 through 999,0", 1000),
                Arguments.of("turn off 499,499 through 500,500", 0),
                Arguments.of("turn on 0,0 through 2,2", 9)
        );
    }

}