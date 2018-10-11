package net.bbelovic.adventofcode.day5;

import net.bbelovic.adventofcode.Puzzle;

import java.util.Arrays;

public class Day5PuzzlePart1 implements Puzzle<String, Boolean> {

    private static final char[][] FORBIDDEN_COMBINATIONS = new char[][]{
            {'a', 'b'}, {'c', 'd'},
            {'p', 'q'}, {'x', 'y'}
    };
    private static final int REQUIRED_VOWEL_COUNT = 3;
    private static final int REQUIRED_FORBIDDEN_COMBINATIONS_COUNT = 0;
    private static final int REQUIRED_LETTER_IN_ROW_COUNT = 0;

    public Boolean solve(String input) {
        int vowelCount = 0;
        char previous = '\0';
        int letterInRow = 0;
        int forbiddenCount = 0;
        for (char c : input.toCharArray()) {
            if (isVowel(c)) {
                vowelCount++;
            }
            if (sameChar(previous, c)) {
                letterInRow++;
            }
            if (isForbiddenCombination(new char[]{previous, c})) {
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
}