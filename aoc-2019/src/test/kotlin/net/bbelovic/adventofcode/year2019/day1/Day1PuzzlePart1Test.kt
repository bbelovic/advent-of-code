package net.bbelovic.adventofcode.year2019.day1

import net.bbelovic.adventofcode.InputReader
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day1PuzzlePart1Test {
    @Test
    fun `should compute total fuel`() {
        val puzzleInput = InputReader().readAllLines("input1.txt")
        val puzzlePart1 = Day1PuzzlePart1()

        val expectedFuel = 3210097L
        val actualFuel = puzzlePart1.solve(puzzleInput)
        assertEquals(expectedFuel, actualFuel)
    }
}