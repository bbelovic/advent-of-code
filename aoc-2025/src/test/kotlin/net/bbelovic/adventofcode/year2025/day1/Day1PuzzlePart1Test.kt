package net.bbelovic.adventofcode.year2025.day1

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day1PuzzlePart1Test {

    @Test
    fun `calculate times dial points to 0`() {

        val inputs = """L68
        L30
        R48
        L5
        R60
        L55
        L1
        L99
        R14
        L82""".splitToSequence('\n')
            .map {it -> it.trim()}
            .toList()

        val actual = Day1PuzzlePart1().solve(inputs)
        Assertions.assertThat(actual)
            .isEqualTo(3)
    }
}