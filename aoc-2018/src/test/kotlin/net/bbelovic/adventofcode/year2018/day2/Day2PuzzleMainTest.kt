package net.bbelovic.adventofcode.year2018.day2

import net.bbelovic.adventofcode.InputReader
import net.bbelovic.adventofcode.Puzzle
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day2PuzzleMainTest {
    @ParameterizedTest
    @MethodSource("testData")
    fun `should solve puzzle`(puzzle: Puzzle<List<String>, Long>, expectedResult: Long) {
        val inputLines = InputReader().readAllLines("input2.txt")
        val actualChecksum = puzzle.solve(inputLines)
        assertEquals(expectedResult, actualChecksum)
    }

    companion object {
        @JvmStatic
        fun testData() = listOf(Arguments.of(Day2PuzzlePart1(), 8715L))
    }
}