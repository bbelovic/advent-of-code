package net.bbelovic.adventofcode.day5;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Day5Part2Test {

    private String input;
    private boolean expectedResult;

    public Day5Part2Test(String input, boolean expectedResult) {
        this.expectedResult = expectedResult;
        this.input = input;
    }

    @Test
    public void
    should_tell_whether_input_string_is_nice() {
        Day5 day5 = new Day5();
        boolean actualResult = day5.isNiceStringPartTwo(input);
        Assert.assertEquals(String.format("%s expected false but was true", input), expectedResult, actualResult);
    }
    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                {"qjhvhtzxzqqjkmpb", true},
                {"xxyxx", true},
                {"uurcxstgmygtbstg", false},
                {"ieodomkazucvgmuy", false},
                {"urrvucyrzzzooxhx", false}
        });
    }
}
