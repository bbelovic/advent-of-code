package net.bbelovic.adventofcode.day5;

import net.bbelovic.adventofcode.InputReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

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

    public static void main(String[] args) {
        InputReader reader = new InputReader();
        List<String> input = reader.readAllLines("input5.txt");
        Day5 day5 = new Day5();
        long count = input.stream()
                .map(day5::isNiceStringPartTwo)
                .filter(b -> b)
                .count();
        System.out.println(count);

    }

    public boolean isNiceStringPartTwo(String input) {
        return new Rule1().and(new Rule2()).test(input);
    }


}

class Rule2 implements Predicate<String> {
    public boolean test(String input) {
        for (int i = 0; i <= input.length() - 3; i++) {
            var part = input.substring(i, i + 3);
            if (part.charAt(0) == part.charAt(2)) {
                return true;
            }
        }
        return false;
    }
}

class Rule1 implements Predicate<String> {

    private static final int PAIR_LENGTH = 2;

    public boolean test(String input) {
        List<String> lettersForPairs = prepareLettersForPairs(input);
        List<String> pairs = generatePairs(lettersForPairs);
        return checkPairs(input, pairs);
    }

    private List<String> prepareLettersForPairs(String input) {
        var letterToOccurrences = getLetters(input).stream().collect(groupingBy(identity(), counting()));
        return letterToOccurrences.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(toList());
    }

    private boolean checkPairs(String input, List<String> pairs) {
        var result = false;
        for (var pair : pairs) {
            int index = input.indexOf(pair);
            if (index != -1) {
                index = input.indexOf(pair, index + PAIR_LENGTH);
                if (index != -1) {
                    result = true;
                    break;
                }

            }
        }
        return result;
    }

    private List<String> getLetters(String input) {
        final var letters = new ArrayList<String>();
        for (var i = 0; i < input.length(); i++) {
            letters.add(input.substring(i, i + 1));
        }
        return letters;
    }

    private List<String> generatePairs(List<String> lettersForPairs) {
        var pairs = new ArrayList<String>();
        for (var i = 0; i < lettersForPairs.size(); i++) {
            for (var letter : lettersForPairs) {
                var pair = lettersForPairs.get(i) + letter;
                pairs.add(pair);
            }
        }
        return pairs;
    }

}