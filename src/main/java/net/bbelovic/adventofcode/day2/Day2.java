package net.bbelovic.adventofcode.day2;

import net.bbelovic.adventofcode.InputReader;

import java.util.List;

public class Day2 {
    public long computeWrapperPaper(String input) {
        long[] dimensions = parseDimensions(input);
        long slack = computeSlack(dimensions);
        long paper = computePaper(dimensions);
        return paper + slack;
    }

    private long computePaper(long [] dimensions) {
        long l = dimensions[0];
        long w = dimensions[1];
        long h = dimensions[2];
        return 2*l*w + 2*w*h + 2*h*l;
    }

    private long computeSlack(long [] dimensions) {
        long l = dimensions[0];
        long w = dimensions[1];
        long h = dimensions[2];
        long first = Math.min(l * w, w * h);
        long second = Math.min(w * h, h * l);
        return Math.min(first, second);
    }

    public long computeRibbonUsage(String input) {
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

    public static void main(String[] args) {
        InputReader reader = new InputReader();
        List<String> lines = reader.readAllLines("input2.txt");


        Day2 day2 = new Day2();
        long wrapperPaper = lines.stream().mapToLong(day2::computeWrapperPaper).sum();
        System.out.println(wrapperPaper);
        long ribbonUsage = lines.stream().mapToLong(day2::computeRibbonUsage).sum();
        System.out.println(ribbonUsage);
    }
}
