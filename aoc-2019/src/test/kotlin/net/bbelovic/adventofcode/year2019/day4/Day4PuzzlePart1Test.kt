package net.bbelovic.adventofcode.year2019.day4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class Day4PuzzlePart1Test {
    @ParameterizedTest
    @MethodSource("testData")
    fun `should test password properties`(password: String, matchCriteria: Int) {
        val actualCount = Day4PuzzlePart1().solve(password)
        assertThat(actualCount).isEqualTo(matchCriteria)
    }

    companion object {
        @JvmStatic
        fun testData() = listOf(
                Arguments { arrayOf("111111", 1) },
                Arguments { arrayOf("223450", 0) },
                Arguments { arrayOf("123789", 0) }
        )
    }

    @Test
    fun `test get digits`() {
        var input = 1233789
        val expected = mutableListOf(1, 2, 3, 3, 7, 8 ,9)
        val actual = mutableListOf<Int>()

        var init = 9
        var act: Int
        var descending = true
        var hasDouble = false
        do {
            act = input % 10
            descending = descending && (act <= init)
            if (!hasDouble) {
                hasDouble = (act == init)
            }
            actual.add(act)
            input /= 10

            init = act
        } while (input != 0)
        actual.reverse()
        assertThat(actual).isEqualTo(expected)
        assertThat(hasDouble && descending).isTrue()
    }

    private fun checkNumber(input: Int): Boolean {
        var inputCopy = input
        var init = 10
        var act: Int
        var descending = true
        var hasDouble = false
        do {
            act = inputCopy % 10
            descending = descending && (act <= init)
            if (!hasDouble) {
                hasDouble = (act == init)
            }
            inputCopy /= 10
            init = act
        } while (inputCopy != 0)
//        println("$hasDouble - $descending")
        return hasDouble && descending
    }
}