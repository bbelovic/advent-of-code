package net.bbelovic.adventofcode.year2020.day6;

import net.bbelovic.adventofcode.Puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day6PuzzlePart1Reductive implements Puzzle<String, Long> {
    @Override
    public Long solve(String input) {
        Arrays.stream(input.split("\n\n"))
                .map(this::toList)
                .reduce()
        return null;
    }

    private List<String> toList(String input) {
        List<String> result = new ArrayList<>();
        var chars = input.toCharArray();
        for (var each: chars) {
            result.add(Character.toString(each));
        }
        return result;
    }
}
