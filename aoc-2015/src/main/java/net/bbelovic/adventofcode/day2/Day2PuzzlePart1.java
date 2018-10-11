package net.bbelovic.adventofcode.day2;

import net.bbelovic.adventofcode.Puzzle;

public class Day2PuzzlePart1 implements Puzzle<String, Long> {

    public Long solve(String input) {
        long[] dimensions = parseDimensions(input);
        long slack = computeSlack(dimensions);
        long paper = computePaper(dimensions);
        return paper + slack;
    }

    private long[] parseDimensions(String input) {
        String[] split = input.split("x");
        return new long[]{
                Long.valueOf(split[0]),
                Long.valueOf(split[1]),
                Long.valueOf(split[2]),
        };
    }

    private long computePaper(long[] dimensions) {
        long l = dimensions[0];
        long w = dimensions[1];
        long h = dimensions[2];
        return 2 * l * w + 2 * w * h + 2 * h * l;
    }

    private long computeSlack(long[] dimensions) {
        long l = dimensions[0];
        long w = dimensions[1];
        long h = dimensions[2];
        long first = Math.min(l * w, w * h);
        long second = Math.min(w * h, h * l);
        return Math.min(first, second);
    }
}