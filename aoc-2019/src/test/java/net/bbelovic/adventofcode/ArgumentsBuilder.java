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
        for (var each: values) {
            arguments.add(each);
        }
        return this;
    }

    public Arguments build() {
//        var result = new Object[arguments.size()];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = arguments.get(i);
//        }
        return () -> arguments.toArray(new Object[0]);
    }
}
