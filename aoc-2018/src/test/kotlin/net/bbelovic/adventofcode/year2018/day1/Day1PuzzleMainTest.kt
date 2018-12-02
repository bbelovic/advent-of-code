package net.bbelovic.adventofcode.year2018.day1

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
        val string = InputReader().readAllLines("input.txt").joinToString(", ")
        val actualResult = puzzle.solve(string)
        assertEquals(expectedResult, actualResult)
    }

    companion object {
        @JvmStatic
        fun testData() = listOf(
                Arguments.of(Day1PuzzlePart1(), 430L),
                Arguments.of(Day1PuzzlePart2(), 462L)

        )
    }
}