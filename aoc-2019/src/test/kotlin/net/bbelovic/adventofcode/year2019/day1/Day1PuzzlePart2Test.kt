package net.bbelovic.adventofcode.year2019.day1

import net.bbelovic.adventofcode.InputReader
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day1PuzzlePart2Test {
    @Test
    fun `should compute total required fuel`() {
        val puzzle = Day1PuzzlePart2()
        val input = InputReader().readAllLines("input1.txt")
        val actualFuel = puzzle.solve(input)
        val expectedFuel = 4812287L
        assertEquals(expectedFuel, actualFuel)
    }
}