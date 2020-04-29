package net.bbelovic.adventofcode;

import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuilder {
    private List<Arguments> arguments = new ArrayList<>();

    public TestDataBuilder withArguments(Arguments args) {
        this.arguments.add(args);
        return this;
    }

    public void testArguments(Object... args) {
        this.arguments.add(Arguments.of(args));
    }

    public List<Arguments> getArguments() {
        return arguments;
    }
}