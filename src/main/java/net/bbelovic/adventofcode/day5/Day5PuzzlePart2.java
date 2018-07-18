package net.bbelovic.adventofcode.day5;

public class Day5PuzzlePart2 {
    private static final Rule1 RULE_1 = new Rule1();
    private static final Rule2 RULE_2 = new Rule2();

    public boolean solve(String input) {
        return RULE_1.and(RULE_2).test(input);
    }
}
