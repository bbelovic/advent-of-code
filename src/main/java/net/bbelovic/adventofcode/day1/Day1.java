package net.bbelovic.adventofcode.day1;


import net.bbelovic.adventofcode.InputReader;

import java.util.List;
import java.util.stream.Collectors;

public class Day1 {
    public long computeFloor(String input) {
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

    public static void main(String[] args) {
        InputReader reader = new InputReader();
        List<String> strings = reader.readAllLines("input1.txt");

        final Day1 day1 = new Day1();
        long sum = strings.stream().mapToLong(day1::computeFloor).sum();

        System.out.println(sum);

        String collect = strings.stream().collect(Collectors.joining());

        long position = day1.computePositionForBasementFloor(collect);

        System.out.println(position);
    }

    public long computePositionForBasementFloor(String input) {
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
