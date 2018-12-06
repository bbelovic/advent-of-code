package net.bbelovic.adventofcode.year2018.day2

import net.bbelovic.adventofcode.Puzzle
import java.lang.StringBuilder
import java.util.ArrayList

class Day2PuzzlePart2 : Puzzle<List<String>, String> {
    override fun solve(input: List<String>): String {
        for (each in input) {
            val copy = ArrayList(input - each)
            for (s in copy) {
                if (!hasSingleDifference(each, s)) {
                    continue
                } else {
                    return findCommonLetters(each, s)
                }
            }
        }
        throw IllegalStateException("Expected exactly one pair of IDs that differ in one letter.")
    }

    private fun hasSingleDifference(first: String, second: String): Boolean {
        var diffs = 0
        for (i in 0 until first.length) {
            if (first[i] != second[i]) {
                ++diffs
            }
            if (diffs >= 2) break
        }
        return diffs == 1
    }

    private fun findCommonLetters(first: String, second: String): String {
        val result = StringBuilder()
        for (i in 0 until first.length) {
            if (first[i] == second[i]) result += first[i]
        }
        return result.toString()
    }

    operator fun StringBuilder.plusAssign(c: Char) {
        this.append(c)
    }
}