package net.bbelovic.adventofcode.year2020.day1

import net.bbelovic.adventofcode.InputReader
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

const val PART2_EXPECTED_RESULT = 162292410L
class Day1PuzzlePart2Test {
    @Test
    fun `should compute product from three numbers that add to 2020 - example data`() {
        val actualResult = Day1PuzzlePart2()
            .solve(listOf("1721", "979", "366", "299", "675", "1456"))
        assertThat(actualResult).isEqualTo(241861950)
    }

    @Test
    fun `should compute product of two entries that make 2020`() {
        val puzzle = Day1PuzzlePart2()
        val input = InputReader().readAllLines("input1.txt")
        val actualResult = puzzle.solve(input)
        assertThat(actualResult).isEqualTo(PART2_EXPECTED_RESULT)
    }
}