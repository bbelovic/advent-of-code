package net.bbelovic.adventofcode.year2018.day1

import net.bbelovic.adventofcode.Puzzle

class Day1PuzzlePart1 : Puzzle<String, Long> {
    override fun solve(input: String?): Long {
        val sum = input?.splitToSequence(", ")
                ?.map { it -> it.toInt() }
                ?.sum()
        return sum?.toLong() ?: 0L
    }
}