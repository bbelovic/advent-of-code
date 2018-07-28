package net.bbelovic.adventofcode.day6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day6PuzzleDifferentGridsTest {
    private static final DefaultInstructionsParser<Grid<Boolean>> INSTRUCTIONS_PARSER =
            new DefaultInstructionsParser<>(LightOperation::valueOf);

    @ParameterizedTest
    @MethodSource("testData")
    void should_support_various_grid_implementations(Grid<Boolean> grid, String line, long expectedLightsOnCount) {
        Day6Puzzle<Grid<Boolean>> puzzle = new Day6Puzzle<>(grid, INSTRUCTIONS_PARSER);
        long actualLightsOnCount = puzzle.solve(line);
        assertEquals(expectedLightsOnCount, actualLightsOnCount);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new MatrixGrid(1000,1000), "turn on 0,0 through 999,999", 1_000_000),
                Arguments.of(new MatrixGrid(1000,1000), "toggle 0,0 through 999,0", 1000),
                Arguments.of(new MatrixGrid(1000,1000), "turn off 499,499 through 500,500", 0),
                Arguments.of(new MatrixGrid(1000,1000), "turn on 0,0 through 2,2", 9),

                Arguments.of(new VectorGrid(1_000_000, 1000), "turn on 0,0 through 999,999", 1_000_000),
                Arguments.of(new VectorGrid(1_000_000, 1000), "toggle 0,0 through 999,0", 1000),
                Arguments.of(new VectorGrid(1_000_000, 1000), "turn off 499,499 through 500,500", 0),
                Arguments.of(new VectorGrid(1_000_000, 1000), "turn on 0,0 through 2,2", 9),

                Arguments.of(new BitGrid(1_000_000, 1000), "turn on 0,0 through 999,999", 1_000_000),
                Arguments.of(new BitGrid(1_000_000, 1000), "toggle 0,0 through 999,0", 1000),
                Arguments.of(new BitGrid(1_000_000, 1000), "turn off 499,499 through 500,500", 0),
                Arguments.of(new BitGrid(1_000_000, 1000), "turn on 0,0 through 2,2", 9)
        );
    }

}
