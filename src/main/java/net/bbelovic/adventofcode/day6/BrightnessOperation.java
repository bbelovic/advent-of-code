package net.bbelovic.adventofcode.day6;

import java.util.function.Function;

public enum BrightnessOperation implements Operation<Grid<Integer>> {
    TURN_ON(b -> +1),
    TURN_OFF(b -> b > 0 ? -1 : 0),
    TOOGLE(b -> +2);
    private final Function<Integer, Integer> operation;

    BrightnessOperation(Function<Integer, Integer> operation) {
        this.operation = operation;
    }

    public int apply(Grid<Integer> grid, int x, int y) {
        int brightnessValue = grid.get(x, y);
        int result = operation.apply(brightnessValue);
        grid.set(x, y, brightnessValue + result);
        return result;
    }
}
