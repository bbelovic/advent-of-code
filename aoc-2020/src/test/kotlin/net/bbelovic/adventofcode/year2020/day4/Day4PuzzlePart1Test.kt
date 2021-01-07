package net.bbelovic.adventofcode.year2020.day4

import net.bbelovic.adventofcode.InputReader
import net.bbelovic.adventofcode.utils.dsl.testDataDsl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.io.StringReader

class Day4PuzzlePart1Test {
    @ParameterizedTest
    @MethodSource("testData")
    fun `should count the number of valid passports - example data`(input: String, expected: Long) {
        val actual = Day4PuzzlePart1().solve(StringReader(input).buffered().readLines())
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `should count the number of valid passports`() {
        val allLines = InputReader().readAllLines("input4.txt")
        val actual = Day4PuzzlePart1().solve(allLines)
        assertThat(actual).isEqualTo(182)
    }

    companion object {
        @JvmStatic
        fun testData() = testDataDsl {
            testArguments("""ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
byr:1937 iyr:2017 cid:147 hgt:183cm

iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
hcl:#cfa07d byr:1929

hcl:#ae17e1 iyr:2013
eyr:2024
ecl:brn pid:760753108 byr:1931
hgt:179cm

hcl:#cfa07d eyr:2025 pid:166559648
iyr:2011 ecl:brn hgt:59in""", 2
            )
        }
    }
}