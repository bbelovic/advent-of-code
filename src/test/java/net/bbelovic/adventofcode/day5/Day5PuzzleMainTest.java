package net.bbelovic.adventofcode.day5;

import net.bbelovic.adventofcode.InputReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class Day5PuzzleMainTest {
    private static final InputReader INPUT_READER = new InputReader();
    private final Puzzle puzzle;
    private final long expectedCount;

    public Day5PuzzleMainTest(Puzzle puzzle, long expectedCount) {
        this.puzzle = puzzle;
        this.expectedCount = expectedCount;
    }

    @Test
    public void should_solve_puzzle() {
        var lines = INPUT_READER.readAllLines("input5.txt");
        var actualCount = lines.stream()
                .filter(puzzle::solve)
                .count();
        assertEquals(expectedCount, actualCount);
    }

    @Parameters
    public static Collection<Object[]> testData() {
        return List.of(new Object[][] {
                {new Day5Puzzle(), 238},
                {new Day5PuzzlePart2(), 69}
        });
    }
}
