package net.bbelovic.adventofcode.year2020.day4

class Day4PuzzlePart1 {
    fun solve(lines: List<String>): Long {
        var cnt = 0L
        val collectedKeys = mutableSetOf<String>()
        for (line in lines) {
            if (line != "") {
                line.splitToSequence(" ")
                    .map { each -> """([a-z]{3}):.*""".toRegex().matchEntire(each)!!.destructured.component1() }
                    .toCollection(collectedKeys)
            } else {
                cnt += if (collectedKeys.containsAll(setOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"))) +1 else 0
                collectedKeys.clear()
            }
        }
        return cnt

    }
}
