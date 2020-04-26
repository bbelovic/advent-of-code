package net.bbelovic.adventofcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.provider.*;

public class ArgumentsBuilder {
    private final List<Object> arguments = new ArrayList<>();

    public ArgumentsBuilder withList(List<Object> values) {
        arguments.add(values);
        return this;
    }
    public ArgumentsBuilder withValue(Object o) {
        arguments.add(o);
        return this;
    }

    public ArgumentsBuilder withValues(Object... values) {
        arguments.add(values);
        return this;
    }

    public Arguments build() {
//        return Arguments.of(arguments.toArray(new Object[0]));
        return () -> arguments.toArray();
    }
}
