package net.bbelovic.adventofcode.day6;

import net.bbelovic.adventofcode.InputReader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class PuzzleDay6Test {
    private Instructions instructions;
    private int expectedLightsOnCount;

    public PuzzleDay6Test(Instructions instructions, int expectedLightsOnCount) {
        this.instructions = instructions;
        this.expectedLightsOnCount = expectedLightsOnCount;
    }

    @Test
    public void test() {
        PuzzleDay6 puzzleDay6 = new PuzzleDay6();
        puzzleDay6.solve(instructions);
        Assert.assertEquals(expectedLightsOnCount, puzzleDay6.countLights());
    }

    @Test
    public void test2() {
        InputReader reader = new InputReader();
        List<String> lines = reader.readAllLines("input6.txt");
        InstructionsParser parser = new InstructionsParser();
        PuzzleDay6 puzzleDay6 = new PuzzleDay6();
        for (var eachLine: lines) {
            Instructions instructions = parser.parseInstructions(eachLine);
            puzzleDay6.solve(instructions);
        }
        System.out.println(puzzleDay6.countLights());
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return List.of(new Object[][] {
                {new Instructions((b)->!b, 0,0, 999,0), 1000},
                {new Instructions((b)->true, 0,0, 999,999), 1_000_000},
                {new Instructions((b)->false, 499,499,500,500), 0},
                {new Instructions((b)->true, 0,0,2,2), 9},
        });
    }

}