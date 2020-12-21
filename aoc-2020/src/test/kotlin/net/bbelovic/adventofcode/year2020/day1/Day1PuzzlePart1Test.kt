package net.bbelovic.adventofcode.year2020.day1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day1PuzzlePart1Test {

    @Test
    fun `should compute product of two entries that add 2020`() {
        val inputEntries = listOf(1721, 979, 366, 299, 675, 1456)
        val expectedResult = 514579
        var actualResult = 0

        for (each in inputEntries) {
            val otherPart = 2020 - each
            if (otherPart in inputEntries) {
                actualResult = otherPart * each
                break
            }
        }
        assertThat(actualResult).isEqualTo(expectedResult)
    }
}