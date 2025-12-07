package net.bbelovic.adventofcode.year2025.day1

import net.bbelovic.adventofcode.InputReader
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day1PuzzlePart1Test {

    @Test
    fun `calculate times dial points to 0 at the end of each rotation`() {
        val actual = Day1PuzzlePart1().solve(InputReader().readAllLines("input1.txt"))
        Assertions.assertThat(actual)
            .isEqualTo(962)
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