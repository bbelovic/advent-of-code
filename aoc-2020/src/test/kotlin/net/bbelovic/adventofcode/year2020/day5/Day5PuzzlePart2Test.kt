package net.bbelovic.adventofcode.year2020.day5

import net.bbelovic.adventofcode.InputReader
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day5PuzzlePart2Test {
    @Test
    fun `should find seat ID`() {
        val lines = InputReader().readAllLines("input5.txt")
        val actualSeatId = Day5PuzzlePart2().solve(lines)
        assertThat(actualSeatId).isEqualTo(615L)
    }
}