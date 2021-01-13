package net.bbelovic.adventofcode.year2020.day5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day5PuzzlePart1Test {
    @Test
    fun `should find highest seat id on a boarding pass - example data`() {
        val input = "FBFBBFFRLR"
        val expectedSeatId = 357

        var l = 0
        var u = 127
        var row = 0
        val rowDirections = input.substring(0, 7)

        for (i in  rowDirections.toList()) {
            val m = (l + u) / 2
            if (i == 'F') {
                u = m
                row = u
            } else {
                l = m + 1
                row = l
            }

        }
        assertThat(row).isEqualTo(44)

        val colDirections = input.substring(7)
        l = 0
        u = 7
        var col = 0
        for (i in colDirections.toList()) {
            val m = (l + u) / 2
            if (i == 'L') {
                u = m
                col = u
            } else {
                l = m + 1
                col = l
            }
        }
        assertThat(col).isEqualTo(5)

        assertThat(row * 8 + col).isEqualTo(expectedSeatId)
    }
}