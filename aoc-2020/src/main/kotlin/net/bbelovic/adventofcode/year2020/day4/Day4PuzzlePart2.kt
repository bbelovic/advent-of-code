package net.bbelovic.adventofcode.year2020.day4

class Day4PuzzlePart2 : AbstractDay4Puzzle() {

    override fun processElement(line: String): String {
        val rules = mapOf(
            "byr" to """19[2-9][0-9]|200[0-2]""".toRegex(),
            "iyr" to """201[0-9]|2020""".toRegex(),
            "eyr" to """202[0-9]|2030""".toRegex(),
            "hgt" to """1[5-8][0-9]cm|19[0-3]cm|59in|6[0-9]in|7[0-6]in""".toRegex(),
            "hcl" to """#[0-9a-f]{6}""".toRegex(),
            "ecl" to """amb|blu|brn|gry|grn|hzl|oth""".toRegex(),
            "pid" to """[0-9]{9}""".toRegex(),
            "cid" to """.*""".toRegex()
        )

        val (key, value) = """([a-z]{3}):(.*)""".toRegex().matchEntire(line)!!.destructured
        return if (value.matches(rules[key]!!)) key else "invalid value [$value] for key [$key]"
    }
}