package net.bbelovic.adventofcode.year2020.day2

import net.bbelovic.adventofcode.InputReader
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

const val PART1_EXPECTED_RESULT = 542

class Day2PuzzlePart1Test {
    @Test
    fun `should count valid passwords - example data`() {
        val exampleInput = listOf("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")
        val actual = Day2PuzzlePart1().solve(exampleInput)
        assertThat(actual).isEqualTo(2)
    }

    @Test
    fun `should count valid password`() {
        val puzzle = Day2PuzzlePart1()
        val input = InputReader().readAllLines("input2.txt")
        val actual = puzzle.solve(input)
        assertThat(actual).isEqualTo(PART1_EXPECTED_RESULT)
    }

}