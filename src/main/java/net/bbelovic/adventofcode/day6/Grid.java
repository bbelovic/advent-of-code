package net.bbelovic.adventofcode.day6;

public interface Grid {

    boolean get(int x, int y);

    void set(int x, int y, boolean newValue);
}
