package net.bbelovic.adventofcode.year2020.day3

class TobogganRacer(private val slopes: List<Pair<Int, Int>>) {

    fun solve(input: List<String>): Long {
        var result = 1L
        for (slope in slopes) {
            val increment = slope.first
            val step = slope.second
            result *= solve(input, step, increment)
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