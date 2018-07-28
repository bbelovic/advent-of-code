package net.bbelovic.adventofcode.day6;

import java.util.Objects;

import static java.lang.String.format;

public final class Instructions<T> {
    private final Operation<T> operation;
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    Instructions(Operation<T> operation, int x1, int y1, int x2, int y2) {
        this.operation = operation;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instructions that = (Instructions) o;
        return x1 == that.x1 &&
                y1 == that.y1 &&
                x2 == that.x2 &&
                y2 == that.y2 &&
                operation == that.operation;
    }

    @Override
    public int hashCode() {

        return Objects.hash(operation, x1, y1, x2, y2);
    }

    @Override
    public String toString() {
        return format("Instructions[operation=%s, x1=%d, y1=%d, x2=%d, y2=%d]", operation,
                x1, y1, x2, y2);
    }

    long applyOnGrid(T grid) {
        var delta = 0L;
        for (var i = y1; i <= y2; i++) {
            for (var j = x1; j <= x2; j++) {
                delta += operation.apply(grid, i, j);
            }
        }
        return delta;
    }
}
