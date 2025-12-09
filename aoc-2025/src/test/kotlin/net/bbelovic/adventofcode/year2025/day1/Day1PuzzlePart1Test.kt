package net.bbelovic.adventofcode.year2025.day1

import net.bbelovic.adventofcode.InputReader
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day1PuzzlePart1Test {

    private val EXPECTED_DAY1_PART1_RESULT = 962;

    @Test
    fun `calculate times dial points to 0 at the end of each rotation`() {
        val actual = Day1PuzzlePart1().solve(InputReader().readAllLines("input1.txt"))
        Assertions.assertThat(actual)
            .isEqualTo(EXPECTED_DAY1_PART1_RESULT)
    }

    @Test
    fun `calculate times dial points to 0 during rotation or at the end of each rotation`() {
        val actual = Day1PuzzlePart1().solve(exampleInput())
        Assertions.assertThat(actual)
            .isEqualTo(6)
    }

    private fun exampleInput(): List<String> {
        return """L68
        L30
        R48
        L5
        R60
        L55
        L1
        L99
        R14
        L82""".splitToSequence('\n')
            .map { it.trim()}
            .toList()
    }
}