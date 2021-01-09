package net.bbelovic.adventofcode.year2020.day4

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
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
            .map { each -> processElement(each) }
            .toCollection(collectedKeys)
    }


//    byr (Birth Year) - four digits; at least 1920 and at most 2002.
//    iyr (Issue Year) - four digits; at least 2010 and at most 2020.
//    eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
//    hgt (Height) - a number followed by either cm or in:
//    If cm, the number must be at least 150 and at most 193.
//    If in, the number must be at least 59 and at most 76.
//    hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
//    ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
//    pid (Passport ID) - a nine-digit number, including leading zeroes.
//    cid (Country ID) - ignored, missing or not.

    private fun processElement(element: String): String {
        val rules = mapOf(
            "byr" to """19[2-9][0-9]|200[0-2]""".toRegex(),
            "hgt" to """1[5-9][0-3]cm|[5-7][9|0-6]in""".toRegex(),
            "pid" to """[0-9]{9}""".toRegex(),

            )

        val (key, value) = """([a-z]{3}):(.*)""".toRegex().matchEntire(element)!!.destructured
        return if (value.matches(rules[key]!!)) key else "invalid [$value] for [$key]"
    }

    @Test
    fun testByr() {
        val regex = """19[2-9][0-9]|200[0-2]""".toRegex()

        for (i in 1920..2002) {
            assertTrue(i.toString().matches(regex))
        }
        for (i in 0..1919) {
            assertFalse(i.toString().matches(regex), "$i matched regex, but it should not")
        }

        for (i in 2003..99999) {
            assertFalse(i.toString().matches(regex), "$i matched regex, but it should not")
        }
    }
}