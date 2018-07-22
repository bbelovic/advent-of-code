package net.bbelovic.adventofcode.day1;

import net.bbelovic.adventofcode.InputReader;
import net.bbelovic.adventofcode.Puzzle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1PuzzleMainTest {
    private static final InputReader INPUT_READER = new InputReader();
    private static final long DAY1_PUZZLE_PART1 = 74L;
    private static final long DAY1_PUZZLE_PART2 = 1795;

    @ParameterizedTest
    @MethodSource("testData")
    void should_solve_puzzle(Puzzle<String, Long> puzzle, long expectedResult) {
        var allLines = INPUT_READER.readAllLines("input1.txt");
        var actualResult = allLines.stream().mapToLong(puzzle::solve).sum();
        assertEquals(expectedResult, actualResult);
    }

    private static Iterable<Arguments> testData() {
        return List.of(
                Arguments.of(new Day1PuzzlePart1(), DAY1_PUZZLE_PART1),
                Arguments.of(new Day1PuzzlePart2(), DAY1_PUZZLE_PART2)
        );
    }
}
