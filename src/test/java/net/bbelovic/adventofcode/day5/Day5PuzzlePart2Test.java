package net.bbelovic.adventofcode.day5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class Day5PuzzlePart2Test {

    private final String input;
    private final boolean expectedResult;

    public Day5PuzzlePart2Test(String input, boolean expectedResult) {
        this.expectedResult = expectedResult;
        this.input = input;
    }

    @Test
    public void
    should_tell_whether_input_string_is_nice() {
        Day5 day5 = new Day5();
        boolean actualResult = day5.isNiceStringPartTwo(input);
        assertEquals(String.format("%s expected false but was true", input), expectedResult, actualResult);
    }
    @Parameters
    public static Collection<Object[]> testData() {
        return List.of(new Object[][] {
                {"qjhvhtzxzqqjkmpb", true},
                {"xxyxx", true},
                {"uurcxstgmygtbstg", false},
                {"ieodomkazucvgmuy", false},
                {"urrvucyrzzzooxhx", false}
        });
    }
}
