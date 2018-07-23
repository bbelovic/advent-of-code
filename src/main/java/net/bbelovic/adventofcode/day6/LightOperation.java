package net.bbelovic.adventofcode.day6;

import java.util.function.Function;

public enum LightOperation {
    TURN_ON((lightState) -> lightState ? 0 : +1),
    TURN_OFF((lightState) -> lightState ? -1 : 0),
    TOOGLE((lightState) -> lightState ? -1 : +1);

    private final Function<Boolean, Integer> operation;

    LightOperation(Function<Boolean, Integer> operation) {
        this.operation = operation;
    }

    public int apply(boolean lightState) {
        return operation.apply(lightState);
    }
}
