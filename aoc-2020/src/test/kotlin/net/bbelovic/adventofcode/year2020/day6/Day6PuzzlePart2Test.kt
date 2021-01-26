package net.bbelovic.adventofcode.year2020.day6

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day6PuzzlePart2Test {

    @Test
    fun `should count number of questions answered by everyone - example data`() {
        val input = """abc

a
b
c

ab
ac

a
a
a
a

b"""

        val actual = Day6PuzzlePart2().solve(input.lines())
        assertThat(actual).isEqualTo(6L)
    }
}