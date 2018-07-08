package net.bbelovic.adventofcode.day6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InstructionsParserTest {
    @Test
    public void
    should_parse_instruction_from_string() {
        var x1 = "turn on 606,361 through 892,600";
        var x2 = "turn off 448,208 through 645,684";
        var x3 = "toggle 50,472 through 452,788";
        var parser = new InstructionsParser();
        var expected = new Instructions(606, 361, 892, 600);
        var actual = parser.parseInstructions(x1);
        assertEquals(expected, actual);
    }

}