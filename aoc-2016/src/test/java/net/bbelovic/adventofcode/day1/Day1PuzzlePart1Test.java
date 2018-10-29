package net.bbelovic.adventofcode.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.Math.cos;

public class Day1PuzzlePart1Test {
    @Test
    public void should_compute_distance_from_start() {
        var input = "R2,L3";
        long expectedDistance = 5L;
        long actualDistance = new Day1PuzzlePart1().solve(input);

        double cos = cos(Math.PI/2);
        System.out.println(cos);

        Assertions.assertEquals(expectedDistance, actualDistance);

    }
}
