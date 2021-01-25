package net.bbelovic.adventofcode.year2020.day6

import net.bbelovic.adventofcode.Puzzle

class Day6PuzzlePart1 : Puzzle<List<String>, Long> {
    override fun solve(input: List<String>): Long {
        var sum = 0L
        val c = mutableSetOf<Char>()
        for (line in input) {
            if (line != "") {
                line.toCollection(c)
            } else {
                sum += c.size
                c.clear()
            }
        }
        sum += c.size
        return sum
    }
}