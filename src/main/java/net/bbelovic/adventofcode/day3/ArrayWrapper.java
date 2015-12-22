package net.bbelovic.adventofcode.day3;

import java.util.Arrays;

/**
 * Created by bbelovic on 21.12.15.
 */
final class ArrayWrapper {
    private final int [] value;

    public ArrayWrapper(int[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayWrapper that = (ArrayWrapper) o;
        return Arrays.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(value);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ArrayWrapper{");
        sb.append("value=").append(Arrays.toString(value));
        sb.append('}');
        return sb.toString();
    }

    public int[] getValue() {
        return value;
    }
}
