package net.bbelovic.adventofcode.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1PuzzlePart1Test {
    @Test
    void should_compute_distance_from_start() {
        var input = "R2,L3";
        long expectedDistance = 5L;
        long actualDistance = new Day1PuzzlePart1().solve(input);
        assertEquals(expectedDistance, actualDistance);
    }
}
