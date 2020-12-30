package net.bbelovic.adventofcode.year2020.day1

import net.bbelovic.adventofcode.Puzzle

class Day1PuzzlePart2: Puzzle<List<String>, Long> {
    override fun solve(input: List<String>): Long {
        return Day1PuzzlePart1Recursion(3).solve(input)
    }
}
