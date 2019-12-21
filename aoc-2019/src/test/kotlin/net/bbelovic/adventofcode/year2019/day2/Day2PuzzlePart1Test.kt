package net.bbelovic.adventofcode.year2019.day2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day2PuzzlePart1Test {
    @ParameterizedTest
    @MethodSource("testData")
    fun `should process input line with both opcodes`(input: String, expectedOutput: String) {
        val parsedInput = input.split(""",""").toMutableList()
        val actualOutput = Day2PuzzlePart1().solve(parsedInput)
        assertThat(actualOutput).isEqualTo(expectedOutput)
    }

    companion object {
        @JvmStatic
        fun testData() = listOf(
                Arguments { arrayOf("1,0,0,0,99", "2,0,0,0,99")},
                Arguments { arrayOf("2,3,0,3,99", "2,3,0,6,99")},
                Arguments { arrayOf("2,4,4,5,99,0", "2,4,4,5,99,9801")},
                Arguments { arrayOf("1,1,1,4,99,5,6,0,99", "30,1,1,4,2,5,6,0,99")}
        )
    }
}