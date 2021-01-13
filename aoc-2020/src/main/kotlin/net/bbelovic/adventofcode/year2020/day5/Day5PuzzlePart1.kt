package net.bbelovic.adventofcode.year2020.day5

import java.util.Comparator

class Day5PuzzlePart1 {

    fun solve(input: List<String>): Long {
        return input.asSequence().map { each -> map(each) }
            .maxWithOrNull(Comparator.naturalOrder()).let { -1 }
    }

    private fun map(input: String): Long {
        val row = computePosition(input.substring(0, 7), 0, 127, 'F')
        val col = computePosition(input.substring(7), 0, 7, 'L')
        return row * 8L + col

    }
    private fun computePosition(input: String, l: Int, u: Int, c: Char): Int {
        var result = 0
        var uu = u
        var ll = l
        for (i in input.toList()) {
            val m = (ll + uu) / 2
            if (i == c) {
                uu = m
                result = uu
            } else {
                ll = m + 1
                result = ll
            }
        }
        return result
    }

}
