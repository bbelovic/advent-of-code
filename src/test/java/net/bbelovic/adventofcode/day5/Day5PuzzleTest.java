package net.bbelovic.adventofcode.day5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class Day5PuzzleTest {

    private final String input;
    private final boolean expectedOutput;

    public Day5PuzzleTest(String input, boolean expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void
    should_tell_whether_input_string_is_nice_or_naughty() {
        Day5Puzzle day5 = new Day5Puzzle();
        boolean actualOutput = day5.solve(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Parameters
    public static Collection<Object> testData() {
        return List.of(new Object[][]{
                {"ugknbfddgicrmopn", true},
                {"aaa", true},
                {"jchzalrnumimnmhp", false},
                {"haegwjzuvuyypxyu", false},
                {"dvszwmarrgswjxmb", false},
                {"aabbccdd", false},
                {"abiikloyuebcd", false},
                {"x", false},
                {"", false},
                {"aa", false},
                {"iwnekopujjmcd", false},
                {"aatrtacdirouu", false},
                {"afgujikoce", false},
                {"aatrxijodenokuwab", false},
                {"gftrridseqalojibu", true},
                {"pkpinberoayypqu", false}
        });
    }
}
