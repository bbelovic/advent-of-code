package net.bbelovic.adventofcode.day6;

public class PuzzleDay6 {
    private final boolean [][] grid = new boolean[1000][1000];
    public void solve(Instructions instructions) {
        for (var i = instructions.getY1(); i <= instructions.getY2(); i++) {
            for (var j = instructions.getX1(); j <= instructions.getX2(); j++) {
                grid [i][j] = instructions.applyOnLight(grid [i][j]);
            }
        }
    }

    long countLights() {
        long cnt = 0L;
        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[i].length; j++) {
                if (grid[i][j]) {
                    ++cnt;
                }
            }
        }
        return cnt;
    }
}