package net.bbelovic.adventofcode.year2018.day3

import net.bbelovic.adventofcode.InputReader
import net.bbelovic.adventofcode.Puzzle
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

const val EXPECTED_OVERLAP_PART_1 = 111326L
const val EXPECTED_NON_OVERLAPPING_ID = 1019L

class Day3PuzzleMainTest {
    @ParameterizedTest
    @MethodSource("testData")
    fun `should solve puzzle`(puzzle: Puzzle<List<String>, Long>, expectedResult: Long) {
        val inputs = InputReader().readAllLines("input3.txt")
        val actualResult = puzzle.solve(inputs)
        assertEquals(expectedResult, actualResult)
    }

    companion object {
        @JvmStatic
        private fun testData() = listOf(
                Arguments { arrayOf(Day3PuzzlePart1(), EXPECTED_OVERLAP_PART_1) },
                Arguments { arrayOf(Day3PuzzlePart2(), EXPECTED_NON_OVERLAPPING_ID) })
    }
}