package net.bbelovic.adventofcode.year2018.day2

import net.bbelovic.adventofcode.Puzzle
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day2PuzzlePart1Test {
    @Test
    fun `Should return a checksum for box` () {
        val input = listOf("abcdef", "bababc", "abbcde",
                "abcccd", "aabcdd", "abcdee", "ababab")
        val puzzle: Puzzle<List<String>, Long> = Day2PuzzlePart1()
        val actual = puzzle.solve(input)
        Assertions.assertEquals(12, actual)
    }
}