package net.bbelovic.adventofcode.year2019.day2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

private const val PUZZLE_PART2_RESULT = 2254L

class Day2PuzzlePart2Test {
    @Test
    fun `should compute noun and verb`() {
        val actualResult = Day2PuzzlePart2().solve(parseFileInput())
        assertThat(actualResult).isEqualTo(PUZZLE_PART2_RESULT)
    }
}