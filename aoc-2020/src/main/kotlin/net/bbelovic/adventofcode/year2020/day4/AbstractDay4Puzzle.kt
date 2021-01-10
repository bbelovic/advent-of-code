package net.bbelovic.adventofcode.year2020.day4

import net.bbelovic.adventofcode.Puzzle

abstract class AbstractDay4Puzzle : Puzzle<List<String>, Long> {
    override fun solve(lines: List<String>): Long {
        var cnt = 0L
        val collectedKeys = mutableSetOf<String>()
        for (line in lines) {
            if (line != "") {
                line.splitToSequence(" ")
                    .map { each -> processElement(each) }
                    .toCollection(collectedKeys)
            } else {
                cnt += if (collectedKeys.containsAll(setOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"))) +1 else 0
                collectedKeys.clear()
            }
        }
        if (collectedKeys.isNotEmpty()) {
            cnt += if (collectedKeys.containsAll(setOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"))) +1 else 0
        }
        return cnt
    }

    abstract fun processElement(line: String): String

}