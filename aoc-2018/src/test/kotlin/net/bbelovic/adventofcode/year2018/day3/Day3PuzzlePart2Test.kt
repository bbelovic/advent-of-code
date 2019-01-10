package net.bbelovic.adventofcode.year2018.day3

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day3PuzzlePart2Test {
    @Test
    fun `should identify claim that does not overlap`() {
        val rectangles = listOf(
                Rectangle(1, 1, 0, 2, 2)
//                Rectangle(2, 2, 1, 2, 2)
        )
        val puzzle = Day3PuzzlePart2()
        val actual = puzzle.solve(rectangles)
        val expected = 1
        Assertions.assertEquals(expected, actual)
    }
}