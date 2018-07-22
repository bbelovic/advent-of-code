package net.bbelovic.adventofcode.day5;

import net.bbelovic.adventofcode.InputReader;
import net.bbelovic.adventofcode.Puzzle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day5PuzzleMainTest {
    private static final InputReader INPUT_READER = new InputReader();

    @ParameterizedTest
    @MethodSource("testData")
    void should_solve_puzzle(Puzzle<String, Boolean> puzzle, long expectedCount) {
        var lines = INPUT_READER.readAllLines("input5.txt");
        var actualCount = lines.stream()
                .filter(puzzle::solve)
                .count();
        assertEquals(expectedCount, actualCount);
    }

    static Iterable<Arguments> testData() {
        return List.of(
                Arguments.of(new Day5Puzzle(), 238),
                Arguments.of(new Day5PuzzlePart2(), 69)
        );
    }
}
