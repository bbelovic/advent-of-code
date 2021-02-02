package net.bbelovic.adventofcode.year2020.day6;

import net.bbelovic.adventofcode.Puzzle;

import java.util.Arrays;

public class Day6PuzzlePart1Reductive implements Puzzle<String, Long> {
    @Override
    public Long solve(String input) {
        return Arrays.stream(input.split("\n\n"))
                .mapToLong(this::countDistinct)
                .sum();
    }

    private long countDistinct(String input) {
        String trimmed = input.trim();
        String[] splitInput = trimmed.split("\n");
        return Arrays.stream(splitInput).flatMapToInt(String::chars)
                .distinct()
                .count();
    }
}
