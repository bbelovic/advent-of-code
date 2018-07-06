package net.bbelovic.adventofcode.day6;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class PuzzleDay6Test {
    private int [] coords1;
    private int [] coords2;
    private int expectedLightsOnCount;

    public PuzzleDay6Test(int[] coords1, int[] coords2, int expectedLightsOnCount) {
        this.coords1 = coords1;
        this.coords2 = coords2;
        this.expectedLightsOnCount = expectedLightsOnCount;
    }

    @Test
    public void test() {
        long actual = new PuzzleDay6().solve(coords1, coords2);
        Assert.assertEquals(expectedLightsOnCount, actual);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return List.of(new Object[][] {
                {new int []{0,0}, new int [] {999,0}, 1000},
                {new int []{0,0}, new int [] {999,999}, 1_000_000},
                {new int []{499,499}, new int [] {500,500}, 4},
                {new int []{0,0}, new int [] {2,2}, 9},
        });
    }

}