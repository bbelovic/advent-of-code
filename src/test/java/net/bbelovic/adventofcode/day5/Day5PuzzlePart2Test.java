package net.bbelovic.adventofcode.day5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Day5PuzzlePart2Test {

    @ParameterizedTest
    @MethodSource("testData")
    void
    should_tell_whether_input_string_is_nice(String input, boolean expectedResult) {
        Day5PuzzlePart2 day5 = new Day5PuzzlePart2();
        boolean actualResult = day5.solve(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("xxyxx", true),
                Arguments.of("qjhvhtzxzqqjkmpb", true),
                Arguments.of("uurcxstgmygtbstg", false),
                Arguments.of("ieodomkazucvgmuy", false),
                Arguments.of("urrvucyrzzzooxhx", false)
        );
    }
}
