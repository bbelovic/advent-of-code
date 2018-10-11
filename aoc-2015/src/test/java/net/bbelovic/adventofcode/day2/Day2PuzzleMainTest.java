package net.bbelovic.adventofcode.day2;

import net.bbelovic.adventofcode.InputReader;
import net.bbelovic.adventofcode.Puzzle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day2PuzzleMainTest {
    private static final InputReader INPUT_READER = new InputReader();
    private static final int DAY2_PUZZLE_PART1_RESULT = 1598415;
    private static final int DAY2_PUZZLE_PART2_RESULT = 3812909;

    @ParameterizedTest
    @MethodSource("testData")
    void should_solve_puzzle(Puzzle<String, Long> puzzle, long expectedResult) {
        long actualResult = INPUT_READER.readAllLines("input2.txt")
                .stream()
                .mapToLong(puzzle::solve)
                .sum();
        assertEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new Day2PuzzlePart1(), DAY2_PUZZLE_PART1_RESULT),
                Arguments.of(new Day2PuzzlePart2(), DAY2_PUZZLE_PART2_RESULT)
        );
    }
}
