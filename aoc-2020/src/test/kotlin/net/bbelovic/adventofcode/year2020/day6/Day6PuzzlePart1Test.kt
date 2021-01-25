package net.bbelovic.adventofcode.year2020.day6

import net.bbelovic.adventofcode.InputReader
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day6PuzzlePart1Test {
    @Test
    fun `should count yes answers - example data`() {
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
        val actual = Day6PuzzlePart1().solve(input.lines())
        assertThat(actual).isEqualTo(11)
    }

    @Test
    fun `should count yes answers`() {
        val lines = InputReader().readAllLines("input6.txt")
        val actual = Day6PuzzlePart1().solve(lines)
        assertThat(actual).isEqualTo(6530L)
    }
}