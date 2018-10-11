package net.bbelovic.adventofcode.day6;

public interface Grid<T> {

    T get(int x, int y);

    void set(int x, int y, T newValue);
}
