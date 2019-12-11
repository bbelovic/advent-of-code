package net.bbelovic.adventofcode.year2019.day1;

import net.bbelovic.adventofcode.Puzzle;

import java.util.List;

public class Day1PuzzlePart2 implements Puzzle<List<String>, Long> {

    private static long getSum(long x) {
        var sum = 0L;
        var z = 0L;
        while ((z = Math.floorDiv(x, 3) - 2) > 0) {
            sum += z;
            x = z;
        }
        return sum;
    }

    @Override
    public Long solve(List<String> input) {
        return input.stream().mapToLong(Long::parseLong)
                .map(Day1PuzzlePart2::getSum)
                .sum();
    }
}
