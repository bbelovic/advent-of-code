package net.bbelovic.adventofcode.day6;

import net.bbelovic.adventofcode.Puzzle;

public class Day6Puzzle<T> implements Puzzle<String, Long> {
    private final T grid;
    private final DefaultInstructionsParser<T> instructionsParser;

    public Day6Puzzle(T grid, DefaultInstructionsParser<T> instructionsParser) {
        this.grid = grid;
        this.instructionsParser = instructionsParser;
    }

    public Long solve(final String line) {
        final Instructions<T> instructions = instructionsParser.parseInstructions(line);
        return instructions.applyOnGrid(grid);
    }
}