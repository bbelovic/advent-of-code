package net.bbelovic.adventofcode.day5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day5PuzzlePart1Test {

    @ParameterizedTest
    @MethodSource("testData")
    void
    should_tell_whether_input_string_is_nice_or_naughty(String input, boolean expectedOutput) {
        Day5PuzzlePart1 day5 = new Day5PuzzlePart1();
        boolean actualOutput = day5.solve(input);
        assertEquals(expectedOutput, actualOutput);
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("ugknbfddgicrmopn", true),
                Arguments.of("aaa", true),
                Arguments.of("jchzalrnumimnmhp", false),
                Arguments.of("haegwjzuvuyypxyu", false),
                Arguments.of("dvszwmarrgswjxmb", false),
                Arguments.of("aabbccdd", false),
                Arguments.of("abiikloyuebcd", false),
                Arguments.of("x", false),
                Arguments.of("", false),
                Arguments.of("aa", false),
                Arguments.of("iwnekopujjmcd", false),
                Arguments.of("aatrtacdirouu", false),
                Arguments.of("afgujikoce", false),
                Arguments.of("aatrxijodenokuwab", false),
                Arguments.of("gftrridseqalojibu", true),
                Arguments.of("pkpinberoayypqu", false)
        );
    }
}
