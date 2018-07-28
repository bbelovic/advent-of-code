package net.bbelovic.adventofcode.day6;

public class BrightnessGrid implements Grid<Boolean> {
    private final int [][] grid;

    BrightnessGrid(int width, int height) {
        grid = new int[width][height];
    }

    @Override
    public Boolean get(int x, int y) {
        return grid[x][y] > 0;
    }

    @Override
    public void set(int x, int y, Boolean newValue) {

    }
}
