package net.bbelovic.adventofcode.year2020.day4

import org.junit.jupiter.api.Test

class Day4PuzzlePart2Test {
    @Test
    fun `should count the number of valid passports - example data`() {
        val onlyValid = """pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980
hcl:#623a2f

eyr:2029 ecl:blu cid:129 byr:1989
iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm

hcl:#888785
hgt:164cm byr:2001 iyr:2015 cid:88
pid:545766238 ecl:hzl
eyr:2022

iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719"""

        val collectedKeys = mutableSetOf<String>()
        "eyr:2029 ecl:blu cid:129 byr:1989".splitToSequence(" ")
            .map { each -> """([a-z]{3}):(.*)""".toRegex().matchEntire(each)!!.destructured.component1() }
            .toCollection(collectedKeys)
    }

    fun processElement(element: String): Unit {
        val rules = mapOf("pid" to """[0-9]{9}""".toRegex())

        val (key, value) = """([a-z]{3}):(.*)""".toRegex().matchEntire(element)!!.destructured
        if (key == "pid") {
            val regex = rules[key]!!
            value.matches(regex)
        }

        val result = when (key) {
            "pid" -> if (value.matches(rules[key]!!)) key else "na"
            else -> "invalid"
        }
    }
}