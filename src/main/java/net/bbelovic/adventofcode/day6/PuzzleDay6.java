package net.bbelovic.adventofcode.day6;

import java.util.function.Function;

public class PuzzleDay6 {
    private final boolean [][] grid = new boolean[1000][1000];
    private final Function<Boolean, Boolean> TURN_ON = (b)-> true;
    private final Function<Boolean, Boolean> TURN_OFF = (b)-> false;
    private final Function<Boolean, Boolean> TOOGLE = (b)-> !b;
    public long solve(Instructions instructions) {

        var cnt = 0L;
        for (var i = instructions.getY1(); i <= instructions.getY2(); i++) {
            for (var j = instructions.getX1(); j <= instructions.getX2(); j++) {
                TURN_ON.apply(grid [i][j]);
                ++cnt;
            }
        }
        return cnt;
    }
}