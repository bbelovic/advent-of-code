package net.bbelovic.adventofcode.day6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class InstructionsParserTest {
    private static final Function<Boolean, Boolean> TURN_ON = (b) -> true;
    private static final Function<Boolean, Boolean> TURN_OFF = (b) -> false;
    private static final Function<Boolean, Boolean> TOOGLE = (b) -> !b;
    private final String inputLine;
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;
    private final Function<Boolean, Boolean> lightFunction;

    public InstructionsParserTest(String inputLine, int x1, int y1, int x2, int y2, Function<Boolean, Boolean> lightFunction) {
        this.inputLine = inputLine;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.lightFunction = lightFunction;
    }

    @Test
    public void
    should_parse_instruction_from_string() {
        var parser = new InstructionsParser();
        var expected = new Instructions(lightFunction, x1, y1, x2, y2);
        var actual = parser.parseInstructions(inputLine);
        assertEquals(expected, actual);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return List.of(
                new Object[][] {
                        {"turn on 606,361 through 892,600", TURN_ON, 606, 361, 892, 600},
                        {"turn off 448,208 through 645,684", TURN_OFF, 448, 208, 645, 684},
                        {"toggle 50,472 through 452,788", TOOGLE, 50, 472, 452, 788},
                }
        );
    }
}