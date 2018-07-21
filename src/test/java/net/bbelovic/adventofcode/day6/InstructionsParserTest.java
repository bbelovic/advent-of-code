package net.bbelovic.adventofcode.day6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

class InstructionsParserTest {
    private static final Function<Boolean, Boolean> TURN_ON = (b) -> true;
    private static final Function<Boolean, Boolean> TURN_OFF = (b) -> false;
    private static final Function<Boolean, Boolean> TOOGLE = (b) -> !b;

    @ParameterizedTest
    @MethodSource("testData")
    void
    should_parse_instruction_from_string(String inputLine, Function<Boolean, Boolean> lightFunction, int x1, int y1, int x2, int y2) {
        var parser = new InstructionsParser();
        var expected = new Instructions(lightFunction, x1, y1, x2, y2);
        var actual = parser.parseInstructions(inputLine);
        assertEquals(expected, actual);
    }

    static Iterable<Arguments> testData() {
        return List.of(
                        Arguments.of("turn on 606,361 through 892,600", TURN_ON, 606, 361, 892, 600),
                        Arguments.of("turn off 448,208 through 645,684", TURN_OFF, 448, 208, 645, 684),
                        Arguments.of("toggle 50,472 through 452,788", TOOGLE, 50, 472, 452, 788)
        );
    }
}