package net.bbelovic.adventofcode.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

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
