package net.bbelovic.adventofcode.year2018.day2

import net.bbelovic.adventofcode.Puzzle
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private const val EXPECTED_RESULT = 12L

class Day2PuzzlePart1Test {
    @Test
    fun `Should return a checksum for box` () {
        val input = listOf("abcdef", "bababc", "abbcde",
                "abcccd", "aabcdd", "abcdee", "ababab")
        val puzzle: Puzzle<List<String>, Long> = Day2PuzzlePart1()
        val actual = puzzle.solve(input)
        assertEquals(EXPECTED_RESULT, actual)
    }
}