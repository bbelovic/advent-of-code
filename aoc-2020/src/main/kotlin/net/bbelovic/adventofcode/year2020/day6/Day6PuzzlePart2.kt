package net.bbelovic.adventofcode.year2020.day6

import net.bbelovic.adventofcode.Puzzle

class Day6PuzzlePart2 : Puzzle<List<String>, Long> {
    override fun solve(input: List<String>): Long {
        var sum = 0L
        val c = mutableSetOf<Char>()
        for (line in input) {
            if (line != "") {
                if (c.isEmpty()) {
                    line.toCollection(c)
                } else {
                    c.removeAll(line.toList())
                }
            } else {
                sum += c.size
                c.clear()
            }
        }
        sum += c.size
        return sum
    }
}
