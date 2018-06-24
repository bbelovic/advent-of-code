package net.bbelovic.adventofcode.day6;

import org.junit.Assert;
import org.junit.Test;

public class PuzzleDay6Test {
    @Test
    public void test() {
        long actual = new PuzzleDay6().solve();
        long expected = 1000 ;
        Assert.assertEquals(expected, actual);
    }

}