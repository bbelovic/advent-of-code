package net.bbelovic.adventofcode.day6;

import java.util.function.Function;

public class PuzzleDay6 {
    private final boolean [][] grid = new boolean[1000][1000];
    private final Function<Boolean, Boolean> TURN_ON = (b)-> true;
    private final Function<Boolean, Boolean> TURN_OFF = (b)-> false;
    private final Function<Boolean, Boolean> TOOGLE = (b)-> !b;
    public long solve(int[] coords1, int[] coords2) {

        var cnt = 0L;
        for (var i = coords1[1]; i <= coords2[1]; i++) {
            for (var j = coords1[0]; j <= coords2[0]; j++) {
                TURN_ON.apply(grid [i][j]);
                ++cnt;
            }
        }
        return cnt;
    }
}