package net.bbelovic.adventofcode.day6;

import java.util.function.Function;

public enum LightOperation implements Operation<Grid<Boolean>> {
    TURN_ON((lightState) -> lightState ? 0 : +1),
    TURN_OFF((lightState) -> lightState ? -1 : 0),
    TOOGLE((lightState) -> lightState ? -1 : +1);

    private final Function<Boolean, Integer> operation;

    LightOperation(Function<Boolean, Integer> operation) {
        this.operation = operation;
    }

    @Override
    public int apply(Grid<Boolean> grid, int x, int y) {
        var result = operation.apply(grid.get(x, y));
        if (result == 1) {
            grid.set(x, y, true);
        } else if (result == -1) {
            grid.set(x, y, false);
        }
        return result;
    }
}
