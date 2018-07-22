package net.bbelovic.adventofcode.day4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class Day4PuzzleTest {

    private final String input;
    private final long expectedOutput;

    public Day4PuzzleTest(String input, long expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void
    should_compute_numeric_part_of_input() {
        Day4Puzzle day4 = new Day4Puzzle("00000");
        var actual = day4.solve(input);
        assertEquals(expectedOutput, actual);
    }

    public static Collection<Object[]> testData() {
        return List.of(new Object [][] {
                {"abcdef", 609043},
                {"pqrstuv", 1048970},
        });
    }
}