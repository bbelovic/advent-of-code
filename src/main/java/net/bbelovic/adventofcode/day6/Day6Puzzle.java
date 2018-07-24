package net.bbelovic.adventofcode.day6;

import net.bbelovic.adventofcode.Puzzle;

class Day6Puzzle implements Puzzle<String, Long> {
    private static final int DEFAULT_GRID_WIDTH = 1000;
    private static final int DEFAULT_GRID_HEIGHT = 1000;
    private final Grid grid;
    private final InstructionsParser instructionsParser;

    Day6Puzzle(final InstructionsParser instructionsParser) {
        this(new MatrixGrid(DEFAULT_GRID_WIDTH, DEFAULT_GRID_HEIGHT), instructionsParser);
    }

    Day6Puzzle(Grid grid, InstructionsParser instructionsParser) {
        this.grid = grid;
        this.instructionsParser = instructionsParser;
    }

    public Long solve(final String line) {
        final var instructions = instructionsParser.parseInstructions(line);
        return instructions.applyOnGrid(grid);
    }
}