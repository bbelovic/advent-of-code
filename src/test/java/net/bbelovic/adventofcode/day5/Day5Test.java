package net.bbelovic.adventofcode.day5;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Day5Test {

    private String input;
    private boolean expectedOutput;

    public Day5Test(String input, boolean expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void
    should_tell_whether_input_string_is_nice_or_naughty() {
        Day5 day5 = new Day5();
        boolean actualOutput = day5.isNiceString(input);
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Parameterized.Parameters
    public static Collection<Object> testData() {
        return Arrays.asList(new Object[][] {
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
