package net.bbelovic.adventofcode.year2019.day4

import net.bbelovic.adventofcode.utils.dsl.testDataDsl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

private const val PART1_EXPECTED_RESULT = 895
private const val LOW_BOUND = 284639
private const val UP_BOUND = 748759

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
        val result = generateSequence(LOW_BOUND) { if (it < UP_BOUND) it + 1 else null }
                .map { element -> puzzle.solve(element) }
                .sum()
        assertThat(result).isEqualTo(PART1_EXPECTED_RESULT)
    }

    companion object {
        @JvmStatic
        fun testData() = testDataDsl {
            testArguments (111111, 1)
            testArguments (223450, 0)
            testArguments (123789, 0)
        }
    }
}