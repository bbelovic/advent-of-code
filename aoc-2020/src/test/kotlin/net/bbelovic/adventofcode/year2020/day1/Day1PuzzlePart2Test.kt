package net.bbelovic.adventofcode.year2020.day1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day1PuzzlePart2Test {
    @Test
    fun `should compute product from three numbers that add to 2020 - example data`() {
        val actualResult = Day1PuzzlePart2()
            .solve(listOf("1721", "979", "366", "299", "675", "1456"))
        assertThat(actualResult).isEqualTo(241861950)
    }
}