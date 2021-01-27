package net.bbelovic.adventofcode.year2020.day6

import net.bbelovic.adventofcode.InputReader
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

    @Test
    fun `should count number of question answered by everyone`() {
        val lines = InputReader().readAllLines("input6.txt")
        val actual = Day6PuzzlePart2().solve(lines)
        assertThat(actual).isEqualTo(3323L)
    }
}