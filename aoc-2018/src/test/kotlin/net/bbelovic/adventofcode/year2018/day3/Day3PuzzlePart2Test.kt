package net.bbelovic.adventofcode.year2018.day3

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day3PuzzlePart2Test {
    @ParameterizedTest
    @MethodSource("rectangles")
    fun `should identify claim that does not overlap`(rectangles: List<Rectangle>, expectedClaimId: Int) {
        val puzzle = Day3PuzzlePart2()
        val actual = puzzle.solve(rectangles)
        assertEquals(expectedClaimId, actual)
    }

    companion object {
        @JvmStatic
        private fun rectangles() = listOf(
                Arguments {
                    arrayOf(listOf(
                            Rectangle(1, 1, 0, 2, 2)
                    ), 1
                    )
                }
        )

    }
}