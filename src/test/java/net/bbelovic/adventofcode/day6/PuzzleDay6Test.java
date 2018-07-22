package net.bbelovic.adventofcode.day6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PuzzleDay6Test {
    private static final InstructionsParser INSTRUCTIONS_PARSER = new InstructionsParser();

    @ParameterizedTest
    @MethodSource("testData")
    void test(String line, int expectedLightsOnCount) {
        PuzzleDay6 puzzleDay6 = new PuzzleDay6(INSTRUCTIONS_PARSER);
        puzzleDay6.solve(line);
        assertEquals(expectedLightsOnCount, puzzleDay6.countLights());
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