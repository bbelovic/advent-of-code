package net.bbelovic.adventofcode.year2018.day3

import net.bbelovic.adventofcode.Puzzle

class Day3PuzzlePart1 : Puzzle<List<String>, Long> {
    override fun solve(input: List<String>): Long {
        val ft = FabricTemplate()
        return input.asSequence()
                .map { it -> RectangleParser.parse(it) }
                .map { it -> ft.makeClaim(it) }
                .sum()
    }
}