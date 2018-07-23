package net.bbelovic.adventofcode.day6;

class PuzzleDay6 {
    private final boolean [][] grid = new boolean[1000][1000];
    private final InstructionsParser instructionsParser;

    PuzzleDay6(final InstructionsParser instructionsParser) {
        this.instructionsParser = instructionsParser;
    }

    long solve(final String line) {
        final var instructions = instructionsParser.parseInstructions(line);
        return instructions.applyOnGrid(grid);
    }
}