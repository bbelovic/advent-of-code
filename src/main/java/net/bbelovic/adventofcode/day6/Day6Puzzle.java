package net.bbelovic.adventofcode.day6;

import net.bbelovic.adventofcode.Puzzle;

class Day6Puzzle implements Puzzle<String, Long> {
    private final boolean [][] grid = new boolean[1000][1000];
    private final InstructionsParser instructionsParser;

    Day6Puzzle(final InstructionsParser instructionsParser) {
        this.instructionsParser = instructionsParser;
    }

    public Long solve(final String line) {
        final var instructions = instructionsParser.parseInstructions(line);
        return instructions.applyOnGrid(grid);
    }
}