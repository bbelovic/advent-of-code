package net.bbelovic.adventofcode.year2020.day1

import net.bbelovic.adventofcode.InputReader
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

const val PART1_EXPECTED_RESULT = 982464L

class Day1PuzzlePart1Test {

    @Test
    fun `should compute product of two entries that make 2020 - example data`() {
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

    @Test
    fun `should compute product of two entries that make 2020`() {
        val puzzle = Day1PuzzlePart1()
        val input = InputReader().readAllLines("input1.txt")
        val actualResult = puzzle.solve(input)
        assertThat(actualResult).isEqualTo(PART1_EXPECTED_RESULT)
    }
}