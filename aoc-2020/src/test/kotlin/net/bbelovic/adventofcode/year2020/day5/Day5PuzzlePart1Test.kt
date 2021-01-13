package net.bbelovic.adventofcode.year2020.day5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day5PuzzlePart1Test {
    @Test
    fun `should find highest seat id on a boarding pass - example data`() {
        val expectedSeatId = 357
        val actualSeatId = Day5PuzzlePart1().solve(listOf("FBFBBFFRLR"))
        assertThat(actualSeatId).isEqualTo(expectedSeatId)

    }
}