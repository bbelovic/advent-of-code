package net.bbelovic.adventofcode.year2020.day4

import net.bbelovic.adventofcode.InputReader
import net.bbelovic.adventofcode.utils.dsl.testDataDsl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class Day4PuzzlePart2Test {
    @ParameterizedTest
    @MethodSource("testData")
    fun `should count the number of valid passports - example data`(input: String, expected: Long) {
        val actual = Day4PuzzlePart2().solve(input.lines())
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `should count the number of valid passports`() {
        val inputLines = InputReader().readAllLines("input4.txt")
        val actual = Day4PuzzlePart2().solve(inputLines)
        assertThat(actual).isEqualTo(109)
    }

    companion object {
        @JvmStatic
        fun testData() = testDataDsl {
            testArguments("""pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980
hcl:#623a2f

eyr:2029 ecl:blu cid:129 byr:1989
iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm

hcl:#888785
hgt:164cm byr:2001 iyr:2015 cid:88
pid:545766238 ecl:hzl
eyr:2022

iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719""", 4
            )

            testArguments("""eyr:1972 cid:100
hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926

iyr:2019
hcl:#602927 eyr:1967 hgt:170cm
ecl:grn pid:012533040 byr:1946

hcl:dab227 iyr:2012
ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277

hgt:59cm ecl:zzz
eyr:2038 hcl:74454a iyr:2023
pid:3556412378 byr:2007""", 0)
        }
    }
}