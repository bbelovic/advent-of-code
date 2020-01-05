package net.bbelovic.adventofcode.year2019.day4

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class Day4PuzzlePart1Test {
    @ParameterizedTest
    @MethodSource("testData")
    fun `should test password properties`(password: String, matchCriteria: Boolean) {
        val actualCount = Day4PuzzlePart1().solve(password)
        assertThat(actualCount).isEqualTo(1)
    }

    companion object {
        @JvmStatic
        fun testData() = listOf<Arguments>(
                Arguments { arrayOf("111111", true) },
                Arguments { arrayOf("223450", false) },
                Arguments { arrayOf("123789", false) }
        )
    }

    @Test
    fun `test get digits`() {
        var input = 123789
        val expected = mutableListOf(1, 2, 3, 7, 8 ,9)
        val actual = mutableListOf<Int>()

        do {
            actual.add(input % 10)
            input /= 10
        } while (input != 0)
        actual.reverse()
        assertThat(actual).isEqualTo(expected)
    }
}