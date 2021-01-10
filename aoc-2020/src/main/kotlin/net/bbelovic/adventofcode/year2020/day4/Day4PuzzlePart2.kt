package net.bbelovic.adventofcode.year2020.day4

class Day4PuzzlePart2 {
    fun solve(lines: List<String>): Long {
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

    private fun processElement(element: String): String {
        val rules = mapOf(
            "byr" to """19[2-9][0-9]|200[0-2]""".toRegex(),
            "iyr" to """201[0-9]|2020""".toRegex(),
            "eyr" to """202[0-9]|2030""".toRegex(),
            "hgt" to """1[5-8][0-9]cm|19[0-3]cm|[5-7][9|0-6]in""".toRegex(),
            "hcl" to """#[0-9a-f]{6}""".toRegex(),
            "ecl" to """amb|blu|brn|gry|grn|hzl|oth""".toRegex(),
            "pid" to """[0-9]{9}""".toRegex(),
            "cid" to """.*""".toRegex()
        )

        val (key, value) = """([a-z]{3}):(.*)""".toRegex().matchEntire(element)!!.destructured
        return if (value.matches(rules[key]!!)) key else {
            println("invalid value [$value] for key [$key]")
            "invalid value [$value] for key [$key]"
        }
    }
}