package net.bbelovic.adventofcode.year2020.day1;

import net.bbelovic.adventofcode.Puzzle;

import java.util.Arrays;
import java.util.List;

public class Day1PuzzlePart1Sorted implements Puzzle<List<String>, Long> {
    @Override
    public Long solve(List<String> input) {
        var sortedInput = input.stream().mapToLong(Long::parseLong).sorted().toArray();
        for (var each: sortedInput) {
            var otherPart = 2020 - each;
            var idx = Arrays.binarySearch(sortedInput, otherPart);
            if (idx >= 0) {
                return otherPart * each;
            }
        }
        return Long.MIN_VALUE;
    }
}
