package net.bbelovic.adventofcode.day1;

import net.bbelovic.adventofcode.Puzzle;

public class Day1PuzzlePart1 implements Puzzle<String, Long> {

    public Long solve(String input) {
        long result = 0L;
        char[] chars = input.toCharArray();
        for (char c: chars) {
            if (c == ')') {
                result = result - 1;
            } else if (c == '(') {
                result = result + 1;
            }
        }
        return result;
    }
}