package net.bbelovic.adventofcode.day5;

import java.util.function.Predicate;

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
