package net.bbelovic.adventofcode.day6;

public final class VectorGrid implements Grid<Boolean> {
    private final boolean[] vector;
    private final int rowLength;

    VectorGrid(int length, int rowLength) {
        this.vector = new boolean[length];
        this.rowLength = rowLength;
    }

    @Override
    public Boolean get(int x, int y) {
        return vector[x * rowLength + y];
    }

    @Override
    public void set(int x, int y, Boolean newValue) {
        vector[x * rowLength + y] = newValue;
    }
}
