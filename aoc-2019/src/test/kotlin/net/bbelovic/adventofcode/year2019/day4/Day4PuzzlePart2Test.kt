package net.bbelovic.adventofcode.year2019.day4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

private const val PART2_EXPECTED_RESULT = 591
private const val LOW_BOUND = 284639
private const val UP_BOUND = 748759
class Day4PuzzlePart2Test {

    @Test
    fun `should compute how many passwords from input range meet criteria`() {
        val puzzle = Day4PuzzlePart2()
        val actual = generateSequence(LOW_BOUND) { if (it < UP_BOUND) it + 1 else null }
                .map { element -> puzzle.solve(element) }
                .sum()
        assertThat(actual).isEqualTo(PART2_EXPECTED_RESULT)
    }


    @Test
    fun `should run on demo input`() {
        val puzzle = Day4PuzzlePart2()
        val actual = sequenceOf(112233, 123444, 111122, 113444, 681899)
                .map { el -> puzzle.solve(el) }
                .sum()
        assertThat(actual).isEqualTo(3)
    }
}