package net.bbelovic.adventofcode.day6;

public class PuzzleDay6 {
    private final boolean [][] grid = new boolean[1000][1000];
    public long solve() {
        var cnt = 0L;
        for (var i = 0; i <= 0; i++) {
            for (var j = 0; j <= 999; j++) {
                grid [i][j] = true;
                ++cnt;
            }
        }
        return cnt;
    }
}