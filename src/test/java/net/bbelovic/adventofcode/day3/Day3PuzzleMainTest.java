package net.bbelovic.adventofcode.day3;

import net.bbelovic.adventofcode.InputReader;
import net.bbelovic.adventofcode.Puzzle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day3PuzzleMainTest {

    private static final int DAY3_PUZZLE_PART1 = 2592;
    private static final int DAY3_PUZZLE_PART2 = 2360;

    @ParameterizedTest
    @MethodSource("testData")
    void should_solve_puzzle(Puzzle<String, Integer> puzzle, int expectedResultPerPart) {
        InputReader reader = new InputReader();
        String input = reader.readFileIntoString("input3.txt");
        int actualResultPerPart = puzzle.solve(input);
        assertEquals(expectedResultPerPart, actualResultPerPart);

    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new Day3PuzzlePart1(), DAY3_PUZZLE_PART1),
                Arguments.of(new Day3PuzzlePart2(), DAY3_PUZZLE_PART2)
        );
    }
}
