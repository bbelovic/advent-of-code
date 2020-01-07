package net.bbelovic.adventofcode.year2019.day4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

private const val PART1_EXPECTED_RESULT = 895

internal class Day4PuzzlePart1Test {
    @ParameterizedTest
    @MethodSource("testData")
    fun `should test password properties`(password: Int, matchCriteria: Int) {
        val actualCount = Day4PuzzlePart1().solve(password)
        assertThat(actualCount).isEqualTo(matchCriteria)
    }


    @Test
    fun `should compute how many passwords from input range meet criteria`() {
        val puzzle = Day4PuzzlePart1()
        val sum = generateSequence(284639) { if (it < 748759) it + 1 else null }
                .map { element -> puzzle.solve(element) }
                .sum()
        assertThat(sum).isEqualTo(PART1_EXPECTED_RESULT)
    }

    companion object {
        @JvmStatic
        fun testData() = listOf(
                Arguments { arrayOf(111111, 1) },
                Arguments { arrayOf(223450, 0) },
                Arguments { arrayOf(123789, 0) }
        )
    }
}