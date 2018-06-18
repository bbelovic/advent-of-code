package net.bbelovic.adventofcode.day4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Day4Test {

    private String input;
    private long expectedOutput;

    public Day4Test(String input, long expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void
    should_compute_numeric_part_of_input() {
        Day4 day4 = new Day4();
        long actual = day4.computeNumericpart(input);
        Assert.assertEquals(expectedOutput, actual);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object [][] {
                {"abcdef", 609043},
                {"pqrstuv", 1048970},
        });
    }
}
