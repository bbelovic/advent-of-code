package net.bbelovic.adventofcode.year2019.day4

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day4PuzzlePart2Test {
    @Test
    fun `should run on demo input`() {
        val puzzle = Day4PuzzlePart2()
        val actual = sequenceOf(112233, 123444, 111122)
                .map { el -> puzzle.solve(el) }
                .sum()
        Assertions.assertThat(actual).isEqualTo(2)

    }
}