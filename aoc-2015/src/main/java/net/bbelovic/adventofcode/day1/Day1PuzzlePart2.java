package net.bbelovic.adventofcode.day1;

import net.bbelovic.adventofcode.Puzzle;

public class Day1PuzzlePart2 implements Puzzle<String, Long> {

    public Long solve(String input) {
        long position = 0L;
        long result = 0L;
        for (char c: input.toCharArray()) {
            if (c == ')') {
                result = result - 1;
            } else if (c == '(') {
                result = result + 1;
            }
            ++position;
            if (result == -1) {
                break;
            }
        }
        return position;
    }
}