package net.bbelovic.adventofcode.day1;

import org.junit.Assert;
import org.junit.Test;

public class Day1Test {
    @Test
    public void
    should_compute_floor_from_input() {
        String [] input = {"(((", "(())", "))(((((", "()()", "())", ")))", ")())())"};
        long [] expectedOutput = {3L, 0L, 3L, 0L, -1L, -3L, -3L};


        Day1 day1 = new Day1();
        for (int i = 0; i < input.length; i++) {
            long actual = day1.computeFloor(input[i]);
            Assert.assertEquals(expectedOutput[i], actual);
        }

    }

    @Test
    public void
    should_compute_position_where_first_basement_floor_is_entered() {
        String [] input = {")", "()())", "())", "))("};
        long [] expectedResults = {1L, 5L, 3L, 1L};
        Day1 day1 = new Day1();
        for (int i = 0; i < input.length; i++) {
            long actualPosition = day1.computePositionForBasementFloor(input[i]);
            Assert.assertEquals(expectedResults[i], actualPosition);
        }
    }
}
