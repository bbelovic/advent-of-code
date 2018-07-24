package net.bbelovic.adventofcode.day6;

import java.util.BitSet;

public final class BitGrid implements Grid {

    private final BitSet bitSet;
    private final int rowLength;

    BitGrid(int length, int rowLength) {
        bitSet = new BitSet(length);
        this.rowLength = rowLength;
    }

    @Override
    public boolean get(int x, int y) {
        return bitSet.get(x * rowLength + y);
    }

    @Override
    public void set(int x, int y, boolean newValue) {
        bitSet.set(x * rowLength + y, newValue);
    }
}
