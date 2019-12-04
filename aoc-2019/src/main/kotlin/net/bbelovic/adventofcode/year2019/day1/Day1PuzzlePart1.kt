package net.bbelovic.adventofcode.year2019.day1

import net.bbelovic.adventofcode.Puzzle

class Day1PuzzlePart1 : Puzzle<List<String>, Long> {
    override fun solve(input: List<String>): Long {
        return input.asSequence()
                .map { line -> line.toLong() }
                .map { each -> Math.floorDiv(each , 3) - 2}.sum()
    }
}