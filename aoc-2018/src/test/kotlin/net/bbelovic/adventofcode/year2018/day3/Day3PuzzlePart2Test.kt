package net.bbelovic.adventofcode.year2018.day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day3PuzzlePart2Test {
    @ParameterizedTest
    @MethodSource("rectangles")
    fun `should identify claim that does not overlap`(rectangles: List<String>, expectedClaimId: Long) {
        val puzzle = Day3PuzzlePart2()
        val actual = puzzle.solve(rectangles)
        assertEquals(expectedClaimId, actual)
    }

    companion object {
        @JvmStatic
        private fun rectangles() = listOf(
                Arguments {
                    arrayOf(listOf("#1 @ 1,0: 2x2"), 1L)
                },
                Arguments {
                    arrayOf(listOf(
                            "#1 @ 1,0: 2x2",
                            "#2 @ 2,1: 2x2",
                            "#3 @ 0,2: 2x2"), 3L)

                },
                Arguments {
                    arrayOf(listOf(
                            "#1 @ 1,0: 2x2",
                            "#2 @ 2,1: 2x2",
                            "#3 @ 0,2: 2x2",
                            "#5 @ 0,0: 1x2",
                            "#4 @ 0,3: 4x1"), 5L)
                },
                Arguments {
                    arrayOf(listOf(
                            "#1 @ 1,0: 2x2",
                            "#2 @ 2,1: 2x2",
                            "#3 @ 0,2: 2x2",
                            "#5 @ 0,0: 1x2",
                            "#4 @ 0,3: 4x1",
                            "#6 @ 0,1: 1x2",
                            "#7 @ 3,0: 1x1"), 7L)
                },
                Arguments {
                    arrayOf(listOf(
                            "#1 @ 1,0: 2x2",
                            "#2 @ 2,1: 2x2",
                            "#3 @ 0,2: 2x2",
                            "#5 @ 0,0: 1x2",
                            "#4 @ 0,3: 4x1",
                            "#6 @ 0,1: 1x2",
                            "#7 @ 3,0: 1x1",
                            "#8 @ 0,1: 1x2"), 7L)

                }
        )
    }
}