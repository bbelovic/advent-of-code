package net.bbelovic.adventofcode.day1

import net.bbelovic.adventofcode.InputReader
import net.bbelovic.adventofcode.Puzzle
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day1PuzzleMainTest {
    @ParameterizedTest
    @MethodSource("testData")
    fun should_solve_puzzle(puzzle: Puzzle<String, Long>, expectedResult: Long) {
        val inputString = InputReader().readFileIntoString("input1.txt")
        val actualResult = puzzle.solve(inputString)
        assertEquals(expectedResult, actualResult)
    }

    companion object {
        @JvmStatic
        fun testData() = listOf<Arguments>(Arguments.of(Day1PuzzlePart1(), 332))
    }
}