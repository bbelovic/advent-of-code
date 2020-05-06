package net.bbelovic.adventofcode.year2018.day2

import net.bbelovic.adventofcode.Puzzle
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private const val EXPECTED_RESULT = "fgij"

class Day2PuzzlePart2Test {
    @Test
    fun `should return common letters`() {
        val puzzle: Puzzle<List<String>, String> = Day2PuzzlePart2()
        val inputs = listOf("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz")
        val actualResult = puzzle.solve(inputs)
        assertEquals(EXPECTED_RESULT, actualResult)
    }
}