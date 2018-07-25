package net.bbelovic.adventofcode.day6;

public final class MatrixGrid implements Grid<Boolean> {
    private final boolean[][] grid;

    MatrixGrid(int width, int height) {
        grid = new boolean[width][height];
    }

    @Override
    public Boolean get(int x, int y) {
        return grid[x][y];
    }

    @Override
    public void set(int x, int y, Boolean newValue) {
        grid[x][y] = newValue;
    }
}
