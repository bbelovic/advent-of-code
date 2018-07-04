package net.bbelovic.adventofcode.day6;

public class PuzzleDay6 {
    private final boolean [][] grid = new boolean[1000][1000];
    public long solve() {

        final var coords1 = new int [] {499, 499};
        final var coords2 = new int [] {500, 500};

        var cnt = 0L;
        for (var i = coords1[0]; i <= coords1[1]; i++) {
            for (var j = coords2[1]; j <= coords2[0]; j++) {
                grid [i][j] = true;
                ++cnt;
            }
        }
        return cnt;
    }
}