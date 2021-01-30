package net.bbelovic.adventofcode.year2020.day6;

import net.bbelovic.adventofcode.Puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day6PuzzlePart1Reductive implements Puzzle<String, Long> {
    @Override
    public Long solve(String input) {
        Arrays.stream(input.split("\n\n"))
                .map(this::toList);
        return null;
    }

    private List<String> toList(String input) {
        String trimmed = input.trim();
        String[] splitInput = trimmed.split("\n");


        List<String> result = new ArrayList<>();
        for (var s: splitInput) {
            for (var each: s.toCharArray()) {
                result.add(Character.toString(each));
            }
        }



        return result;
    }
}
