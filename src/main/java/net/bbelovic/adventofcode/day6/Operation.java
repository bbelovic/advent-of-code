package net.bbelovic.adventofcode.day6;

public interface Operation<T> {
    int apply(T t, int x, int y);
}
