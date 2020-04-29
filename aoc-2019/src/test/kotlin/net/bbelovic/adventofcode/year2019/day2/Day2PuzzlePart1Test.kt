package net.bbelovic.adventofcode.year2019.day2

import net.bbelovic.adventofcode.InputReader
import net.bbelovic.adventofcode.year2019.day3.testDataDsl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

private const val INPUT_FILENAME = "input2.txt"
private const val PUZZLE_PART1_RESULT = "11590668"
private const val INPUT_DELIMITER = ""","""
private const val PUZZLE_PART1_NOUN = 12
private const val PUZZLE_PART1_VERB = 2

internal class Day2PuzzlePart1Test {

    @ParameterizedTest
    @MethodSource("testData")
    fun `should process input line with both opcodes`(input: String, expectedOutput: String) {
        val parsedInput = parseInput(input).toMutableList()
        val actualOutput = Day2PuzzlePart1().solve(parsedInput)
        assertThat(actualOutput).isEqualTo(expectedOutput)
    }

    @Test
    fun `should run on puzzle input`() {
        val parsedInput = parseFileInput().toMutableList()
        parsedInput[NOUN_POSITION] = PUZZLE_PART1_NOUN
        parsedInput[VERB_POSITION] = PUZZLE_PART1_VERB
        val actualOutput = Day2PuzzlePart1().solve(parsedInput)
        assertThat(actualOutput).startsWith(PUZZLE_PART1_RESULT)
    }

    companion object {
        @JvmStatic
        fun testData() = testDataDsl {
            testArguments ("1,0,0,0,99", "2,0,0,0,99")
            testArguments ("2,3,0,3,99", "2,3,0,6,99")
            testArguments ("2,4,4,5,99,0", "2,4,4,5,99,9801")
            testArguments ("1,1,1,4,99,5,6,0,99", "30,1,1,4,2,5,6,0,99")
        }
    }
}

private fun parseInput(input: String) = input.split(INPUT_DELIMITER)
        .map { opCode -> opCode.toInt() }
        .toList()

fun parseFileInput() = parseInput(InputReader().readFileIntoString(INPUT_FILENAME))
