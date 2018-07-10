package net.bbelovic.adventofcode.day6;

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
        long actual = new PuzzleDay6().solve(instructions);
        Assert.assertEquals(expectedLightsOnCount, actual);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return List.of(new Object[][] {
                {new Instructions(0,0, 999,0), 1000},
                {new Instructions(0,0, 999,999), 1_000_000},
                {new Instructions(499,499,500,500), 4},
                {new Instructions(0,0,2,2), 9},
        });
    }

}