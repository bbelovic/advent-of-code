package net.bbelovic.adventofcode.year2019.day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day1PuzzlePart1Test {
    @Test
    fun `should compute total fuel`() {
        val expectedFuel = 2 + 2 + 654 + 33583L
        val puzzlePart1 = Day1PuzzlePart1()
        val actualFuel = puzzlePart1.solve(listOf("12", "14", "1969", "100756"))
        assertEquals(expectedFuel, actualFuel)
    }
}