package net.bbelovic.adventofcode.day6;

public interface OperationParser<T> {
    Operation<T> parse(String operationAsString);
}
