package net.bbelovic.adventofcode.year2020.day5

import net.bbelovic.adventofcode.InputReader
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day5PuzzlePart1Test {
    @Test
    fun `should find highest seat id on a boarding pass - example data`() {
        val actualSeatId = Day5PuzzlePart1().solve(listOf("BBFFBBFRLL", "BFFFBBFRRR", "FFFBBBFRRR", "FBFBBFFRLR"))
        assertThat(actualSeatId).isEqualTo(820L)
    }

    @Test
    fun `should find highest seat id on a boarding pass`() {
        val lines = InputReader().readAllLines("input5.txt")
        val actualSeatId = Day5PuzzlePart1().solve(lines)
        assertThat(actualSeatId).isEqualTo(953L)
    }
}