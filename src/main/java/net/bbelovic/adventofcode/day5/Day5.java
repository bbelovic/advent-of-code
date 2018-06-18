package net.bbelovic.adventofcode.day5;

import net.bbelovic.adventofcode.InputReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Day5 {

    private static final char[][] FORBIDDEN_COMBINATIONS = new char[][]{
            {'a', 'b'}, {'c', 'd'},
            {'p', 'q'}, {'x', 'y'}
    };
    private static final int REQUIRED_VOWEL_COUNT = 3;
    private static final int REQUIRED_FORBIDDEN_COMBINATIONS_COUNT = 0;
    private static final int REQUIRED_LETTER_IN_ROW_COUNT = 0;

    public boolean isNiceString(String input) {
        int vowelCount = 0;
        char previous = '\0';
        int letterInRow = 0;
        int forbiddenCount = 0;
        for (char c: input.toCharArray()) {
            if (isVowel(c)) {
                vowelCount++;
            }
            if (sameChar(previous, c)) {
                letterInRow++;
            }
            if (isForbiddenCombination(new char []{previous, c})) {
                forbiddenCount++;
            }
            previous = c;
        }
        return hasNiceStringProperties(vowelCount, letterInRow, forbiddenCount);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private boolean sameChar(char previous, char c) {
        return previous == c;
    }

    private boolean isForbiddenCombination(char[] actual) {
        return Arrays.equals(actual, FORBIDDEN_COMBINATIONS[0]) ||
                Arrays.equals(actual, FORBIDDEN_COMBINATIONS[1]) ||
                Arrays.equals(actual, FORBIDDEN_COMBINATIONS[2]) ||
                Arrays.equals(actual, FORBIDDEN_COMBINATIONS[3]);
    }

    private boolean hasNiceStringProperties(int vowelCount, int letterInRow, int forbiddenCount) {
        return vowelCount >= REQUIRED_VOWEL_COUNT &&
                letterInRow > REQUIRED_LETTER_IN_ROW_COUNT &&
                forbiddenCount == REQUIRED_FORBIDDEN_COMBINATIONS_COUNT;
    }

    public static void main(String[] args) {
        InputReader reader = new InputReader();
        List<String> input = reader.readAllLines("input5.txt");
        Day5 day5 = new Day5();
        long count = input.stream()
                .map(day5::isNiceString)
                .filter(b -> b)
                .count();
        System.out.println(count);

    }

    public boolean isNiceStringPartTwo(String input) {

        for (int i = 0; i < input.length(); i++) {

        }



        return false;
    }
}
