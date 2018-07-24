package net.bbelovic.adventofcode.day6;

import net.bbelovic.adventofcode.Puzzle;

class Day6Puzzle implements Puzzle<String, Long> {
    private static final int GRID_WIDTH = 1000;
    private static final int GRID_HEIGHT = 1000;
    private final Grid grid = new MatrixGrid(GRID_WIDTH, GRID_HEIGHT);
    private final InstructionsParser instructionsParser;

    Day6Puzzle(final InstructionsParser instructionsParser) {
        this.instructionsParser = instructionsParser;
    }

    public Long solve(final String line) {
        final var instructions = instructionsParser.parseInstructions(line);
        return instructions.applyOnGrid(grid);
    }
}