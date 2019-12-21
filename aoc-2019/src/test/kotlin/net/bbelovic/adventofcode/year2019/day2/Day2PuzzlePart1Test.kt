package net.bbelovic.adventofcode.year2019.day2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day2PuzzlePart1Test {
    @Test
    fun `should process input line`() {
        val input = "1,0,0,0,99"
        val expectedOutput = "2,0,0,0,99"
        val actualOutput = Day2PuzzlePart1()
        assertThat(actualOutput).isEqualTo(expectedOutput)
    }
}