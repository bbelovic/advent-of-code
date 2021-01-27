package net.bbelovic.adventofcode.year2020.day6

import net.bbelovic.adventofcode.Puzzle

class Day6PuzzlePart2 : Puzzle<List<String>, Long> {
    override fun solve(input: List<String>): Long {
        var sum = 0L
        val c = mutableSetOf<Char>()
        var lineNo = 0
        for (line in input) {
            if (line != "") {
                ++lineNo
                if (c.isEmpty() && lineNo == 1) {
                    line.toCollection(c)
                } else {
                    c.retainAll(line.toList())
                }
            } else {
                sum += c.size
                c.clear()
                lineNo = 0
            }
        }
        sum += c.size
        return sum
    }
}
