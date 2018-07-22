package net.bbelovic.adventofcode.day3;

import net.bbelovic.adventofcode.Puzzle;

public class Day3Puzzle implements Puzzle<String, Integer> {

    private final Puzzle<String, Integer> puzzle;

    Day3Puzzle(Puzzle<String, Integer> puzzle) {
        this.puzzle = puzzle;
    }

    @Override
    public Integer solve(String input) {
        return puzzle.solve(input);
    }
}
