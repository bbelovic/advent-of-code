package net.bbelovic.adventofcode;

public interface Puzzle<I, R> {
    R solve(I input);
}
