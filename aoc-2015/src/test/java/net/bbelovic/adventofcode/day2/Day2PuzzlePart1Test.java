package net.bbelovic.adventofcode.day2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day2PuzzlePart1Test {

    @ParameterizedTest
    @MethodSource("testData")
    void
    should_compute_wrapper_paper_usage(String input, long expectedWrapperPaper) {
        Day2PuzzlePart1 part1 = new Day2PuzzlePart1();
        long actualWrapperPaper = part1.solve(input);
        assertEquals(expectedWrapperPaper, actualWrapperPaper);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("1x1x10", 43L),
                Arguments.of("2x3x4", 58)
        );
    }
}
