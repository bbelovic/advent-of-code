package net.bbelovic.adventofcode.day6;

public class PuzzleDay6 {
    private final boolean [][] grid = new boolean[1000][1000];
    public long solve(int[] coords1, int[] coords2) {

        var cnt = 0L;
        for (var i = coords1[1]; i <= coords2[1]; i++) {
            for (var j = coords1[0]; j <= coords2[0]; j++) {
                grid [i][j] = true;
                ++cnt;
            }
        }
        return cnt;
    }
}