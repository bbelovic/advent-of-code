package net.bbelovic.adventofcode.day2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class Day2Test {

    private String input;
    private long expectedWrapperPaper;
    private long expectedRibbonUsage;

    public Day2Test(String input, long expectedWrapperPaper, long expectedRibbonUsage) {
        this.input = input;
        this.expectedWrapperPaper = expectedWrapperPaper;
        this.expectedRibbonUsage = expectedRibbonUsage;
    }

    @Test
    public void
    should_compute_wrapper_paper_usage() {
        Day2 day2 = new Day2();
        assertEquals(expectedWrapperPaper, day2.computeWrapperPaper(input));
    }

    @Test
    public void
    should_compute_ribbon_usage() {
        Day2 day2 = new Day2();
        long actualRibbonUsage = day2.computeRibbonUsage(input);
        Assert.assertEquals(expectedRibbonUsage, actualRibbonUsage);
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"1x1x10", 43L, 14L},
                {"2x3x4", 58, 34L}
        });
    }
}
