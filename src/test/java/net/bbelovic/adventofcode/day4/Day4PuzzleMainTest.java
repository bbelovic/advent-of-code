package net.bbelovic.adventofcode.day4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class Day4PuzzleMainTest {

    private static final String INPUT = "iwrupvqb";
    private final String zeroPrefix;
    private final int expectedCount;

    public Day4PuzzleMainTest(String zeroPrefix, int expectedCount) {
        this.zeroPrefix = zeroPrefix;
        this.expectedCount = expectedCount;
    }

    @Test
    public void
    should_solve_puzzle() {
        final Day4 puzzle = new Day4(zeroPrefix);
        final var actualCount = puzzle.solve(INPUT);
        assertEquals(expectedCount, actualCount);

    }
    @Parameters
    public static Collection<Object[]> testData() {
        return List.of(new Object[][]{
                {"00000", 346386},
                {"000000", 9958218}
        });
    }
}
