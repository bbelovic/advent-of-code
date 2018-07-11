package net.bbelovic.adventofcode.day6;

import net.bbelovic.adventofcode.InputReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PuzzleDay6Test {
    private static final InstructionsParser INSTRUCTIONS_PARSER = new InstructionsParser();
    private final String line;
    private final int expectedLightsOnCount;

    public PuzzleDay6Test(final String line, final int expectedLightsOnCount) {
        this.line = line;
        this.expectedLightsOnCount = expectedLightsOnCount;
    }

    @Test
    public void test() {
        PuzzleDay6 puzzleDay6 = new PuzzleDay6(INSTRUCTIONS_PARSER);
        puzzleDay6.solve(line);
        assertEquals(expectedLightsOnCount, puzzleDay6.countLights());
    }

    @Test
    public void test2() {
        InputReader reader = new InputReader();
        List<String> lines = reader.readAllLines("input6.txt");
        PuzzleDay6 puzzleDay6 = new PuzzleDay6(INSTRUCTIONS_PARSER);
        for (var eachLine: lines) {
            puzzleDay6.solve(eachLine);
        }
        assertEquals(543903, puzzleDay6.countLights());
    }

    @Parameters
    public static Collection<Object[]> testData() {
        return List.of(new Object[][] {
                {"toggle 0,0 through 999,0", 1000},
                {"turn on 0,0 through 999,999", 1_000_000},
                {"turn off 499,499 through 500,500", 0},
                {"turn on 0,0 through 2,2", 9},
        });
    }

}