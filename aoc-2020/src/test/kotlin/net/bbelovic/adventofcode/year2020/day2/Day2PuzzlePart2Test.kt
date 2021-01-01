package net.bbelovic.adventofcode.year2020.day2

import net.bbelovic.adventofcode.InputReader
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

const val PART2_EXPECTED_RESULT = 360

class Day2PuzzlePart2Test {
    @Test
    fun `should count valid passwords - example data`() {
        val exampleInput = listOf("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")
        val actual = Day2PuzzlePart2().solve(exampleInput)
        assertThat(actual).isEqualTo(1)
    }

    @Test
    fun `should count valid passwords`() {
        val input = InputReader().readAllLines("input2.txt")
        val actual = Day2PuzzlePart2().solve(input)
        assertThat(actual).isEqualTo(PART2_EXPECTED_RESULT)
    }
}