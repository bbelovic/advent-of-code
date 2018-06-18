package net.bbelovic.adventofcode.day3;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Day3Test {

    private String input;
    private long visitedOnceExpected;
    private long visitedOnce2SantasExpected;

    private final Day3 day3 = new Day3();


    public Day3Test(String input, long visitedOnceExpected, long visitedOnce2SantasExpected) {
        this.input = input;
        this.visitedOnceExpected = visitedOnceExpected;
        this.visitedOnce2SantasExpected = visitedOnce2SantasExpected;
    }

    @Test
    public void
    should_return_number_of_locations_visited_at_least_once() {
        long locationsVisitedOnce = day3.getLocationVisitedOnce(input);
        Assert.assertEquals(visitedOnceExpected, locationsVisitedOnce);
    }

    @Test
    public void
    should_return_number_of_location_visited_at_least_once_with_2_santas_in_action() {
        long locationsVisitedOnce = day3.getLocationVisitedOnceTwoSantas(input);
        Assert.assertEquals(visitedOnce2SantasExpected, locationsVisitedOnce);
    }


    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                {"^v", 2, 3},
                {"^>v<", 4, 3},
                {"^v^v^v^v^v", 2, 11}
        });
    }
}
