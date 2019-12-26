package net.bbelovic.adventofcode.year2019.day3

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day3PuzzlePart1Test {
    @Test
    fun `should compute Manhattan distance from central port to closest intersection`() {
        val first = listOf("R75","D30","R83","U83","L12","D49","R71","U7","L72")
        val second = listOf("U62","R66","U55", "R34","D71","R55","D58","R83")
        val puzzle = Day3PuzzlePart1()
        val actualDistance = puzzle.solve(listOf(listOf("R8", "U5", "L5", "D3"), listOf("U7", "R6", "D4", "L4")))
        Assertions.assertThat(actualDistance).isEqualTo(6)
    }
}