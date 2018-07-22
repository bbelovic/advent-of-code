package net.bbelovic.adventofcode.day2;

import net.bbelovic.adventofcode.Puzzle;

class Day2PuzzlePart2 implements Puzzle<String, Long> {
    @Override
    public Long solve(String input) {
        long[] dimensions = parseDimensions(input);
        return computeRibbon(dimensions);
    }

    private long computeRibbon(long [] dimensions) {
        long l = dimensions[0];
        long w = dimensions[1];
        long h = dimensions[2];
        long first = Math.min(2 * (l + w), 2*(w+h));
        long second = Math.min(2 * (w + h), 2 * (h + l));
        long perimeter = Math.min(first, second);
        return perimeter + l*w*h;
    }

    private long [] parseDimensions(String input) {
        String[] split = input.split("x");
        return new long []{
                Long.valueOf(split[0]),
                Long.valueOf(split[1]),
                Long.valueOf(split[2]),
        };
    }
}
