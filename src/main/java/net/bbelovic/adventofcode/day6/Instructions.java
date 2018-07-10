package net.bbelovic.adventofcode.day6;

import java.util.Objects;
import java.util.function.Function;

import static java.lang.String.format;

public final class Instructions {
    private final Function<Boolean, Boolean> f;
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    Instructions(Function<Boolean, Boolean> f, int x1, int y1, int x2, int y2) {
        this.f = f;
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
                y2 == that.y2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, x2, y2);
    }

    @Override
    public String toString() {
        return format("Instructions[x1=%d, y1=%d, x2=%d, y2=%d]", x1, y1, x2, y2);
    }

    int getX1() {
        return x1;
    }

    int getY1() {
        return y1;
    }

    int getX2() {
        return x2;
    }

    int getY2() {
        return y2;
    }

    boolean applyOnLight(boolean lightState) {
        return f.apply(lightState);
    }
}
