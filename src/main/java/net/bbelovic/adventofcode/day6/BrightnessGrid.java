package net.bbelovic.adventofcode.day6;

public class BrightnessGrid implements Grid<Integer> {
    private final int [][] grid;

    BrightnessGrid(int width, int height) {
        grid = new int[width][height];
    }

    @Override
    public Integer get(int x, int y) {
        return grid[x][y];
    }

    @Override
    public void set(int x, int y, Integer newValue) {

    }
}
