package net.bbelovic.adventofcode.year2020.day1

import net.bbelovic.adventofcode.Puzzle

class Day1PuzzlePart1: Puzzle<List<String>, Long> {
    override fun solve(input: List<String>): Long {
        val actualResult = Long.MIN_VALUE
        for (each in input) {
            val otherPart = 2020 - each.toLong()
            if (otherPart.toString() in input) {
                return otherPart * each.toLong()
            }
        }
        return actualResult
    }
}
