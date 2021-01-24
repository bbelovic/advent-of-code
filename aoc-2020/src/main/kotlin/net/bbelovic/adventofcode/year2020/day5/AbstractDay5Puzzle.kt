package net.bbelovic.adventofcode.year2020.day5

import net.bbelovic.adventofcode.Puzzle

abstract class AbstractDay5Puzzle : Puzzle<List<String>, Long> {
    protected fun computeRowAndCols(input: String): Long {
        val row = computePosition(input.substring(0, 7), 0, 127, 'F')
        val col = computePosition(input.substring(7), 0, 7, 'L')
        return row * 8L + col

    }
    private fun computePosition(input: String, lBound: Int, uBound: Int, c: Char): Int {
        var result = 0
        var u = uBound
        var l = lBound
        for (i in input.toList()) {
            val m = (l + u) / 2
            if (i == c) {
                u = m
                result = u
            } else {
                l = m + 1
                result = l
            }
        }
        return result
    }
}