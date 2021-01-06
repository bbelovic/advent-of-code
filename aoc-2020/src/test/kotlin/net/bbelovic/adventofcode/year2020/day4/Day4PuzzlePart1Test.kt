package net.bbelovic.adventofcode.year2020.day4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.StringReader

class Day4PuzzlePart1Test {
    @Test
    fun `should count the number of valid passports - example data`() {
        val exampleInput = """ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
byr:1937 iyr:2017 cid:147 hgt:183cm

iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
hcl:#cfa07d byr:1929

hcl:#ae17e1 iyr:2013
eyr:2024
ecl:brn pid:760753108 byr:1931
hgt:179cm

hcl:#cfa07d eyr:2025 pid:166559648
iyr:2011 ecl:brn hgt:59in"""

        val bufferedReader = StringReader(exampleInput).buffered()

        var cnt = 0
        val collectedKeys = mutableSetOf<String>()
        bufferedReader.forEachLine { eachLine ->
            if (eachLine != "") {
                eachLine.splitToSequence(" ")
                    .map { each -> """([a-z]{3}):.*""".toRegex().matchEntire(each)!!.destructured.component1() }
                    .toCollection(collectedKeys)
            } else {

                cnt += if (collectedKeys.containsAll(setOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"))) +1 else 0
                collectedKeys.clear()
            }
        }




        assertThat(cnt).isEqualTo(2)

    }

}