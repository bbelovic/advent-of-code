package net.bbelovic.adventofcode.day6;

import net.bbelovic.adventofcode.InputReader;
import net.bbelovic.adventofcode.Puzzle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Day6PuzzleMainTest {
    private static final long EXPECTED_LIGHTS_LIT_COUNT = 543903L;
    private static final long EXPECTED_BRIGHTNESS = 14687245L;
    private static final InputReader INPUT_READER = new InputReader();

    @ParameterizedTest
    @MethodSource("testData")
    void should_solve_puzzle(Puzzle<String, Long> puzzle, long expectedResult) {
        final var lines = INPUT_READER.readAllLines("input6.txt");
        var actualResult = lines.stream()
                .mapToLong(puzzle::solve)
                .sum();
        assertEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new Day6Puzzle<Grid<Boolean>>(new MatrixGrid(1000, 1000),
                        new DefaultInstructionsParser<Grid<Boolean>>(LightOperation::valueOf)), EXPECTED_LIGHTS_LIT_COUNT),

                Arguments.of(new Day6Puzzle<Grid<Integer>>(new BrightnessGrid(1000, 1000),
                        new DefaultInstructionsParser<>(BrightnessOperation::valueOf)), EXPECTED_BRIGHTNESS)
        );
    }
}
