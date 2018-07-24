package net.bbelovic.adventofcode.day6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static net.bbelovic.adventofcode.day6.LightOperation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class InstructionsParserTest {

    @ParameterizedTest
    @MethodSource("testData")
    void
    should_parse_instruction_from_string(String inputLine, LightOperation lightOperation, int x1, int y1, int x2, int y2) {
        var parser = new InstructionsParser();
        var expectedInstructions = new Instructions(lightOperation, x1, y1, x2, y2);
        var actualInstructions = parser.parseInstructions(inputLine);
        assertEquals(expectedInstructions, actualInstructions);
    }

    private static Iterable<Arguments> testData() {
        return List.of(
                        Arguments.of("turn on 606,361 through 892,600", TURN_ON, 606, 361, 892, 600),
                        Arguments.of("turn off 448,208 through 645,684", TURN_OFF, 448, 208, 645, 684),
                        Arguments.of("toggle 50,472 through 452,788", TOOGLE, 50, 472, 452, 788)
        );
    }
}