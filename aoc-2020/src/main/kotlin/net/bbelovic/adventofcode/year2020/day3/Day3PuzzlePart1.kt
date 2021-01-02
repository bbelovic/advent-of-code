package net.bbelovic.adventofcode.year2020.day3

import net.bbelovic.adventofcode.Puzzle

class Day3PuzzlePart1(private val slopes: List<Pair<Int, Int>>) : Puzzle<List<String>, Long> {

    override fun solve(input: List<String>): Long {
        var result = 1L
        for (slope in slopes) {
            result *= solve(input, slope.second, slope.first)
        }
        return result
    }

    private fun solve(input: List<String>, step: Int, increment: Int): Int {
        var treeCount = 0
        var idx = input[0].indexOf('.')

        for (i in input.indices step step) {
            val inputLine = repeatIfNeeded(idx, input[i])
            if (inputLine[idx] == '#') {
                ++treeCount
            }
            idx += increment

        }
        return treeCount
    }

    private fun repeatIfNeeded(idx: Int, line: String): String {
        if (idx >= line.length) {
            return line.repeat((idx / line.length) + 1)
        }
        return line
    }
}