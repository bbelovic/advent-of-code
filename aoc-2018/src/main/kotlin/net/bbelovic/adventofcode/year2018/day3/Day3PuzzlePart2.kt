package net.bbelovic.adventofcode.year2018.day3

import net.bbelovic.adventofcode.Puzzle

class Day3PuzzlePart2 : Puzzle<List<Rectangle>, Int> {
    private val fabric = Fabric2(1000, 1000)
    override fun solve(input: List<Rectangle>): Int {
        for (each in input) {
            fabric.makeClaim(each)

        }
        if (fabric.registeredClaims.isEmpty()) {
            return 0
        } else {
            return fabric.registeredClaims[0]
        }
    }
}
