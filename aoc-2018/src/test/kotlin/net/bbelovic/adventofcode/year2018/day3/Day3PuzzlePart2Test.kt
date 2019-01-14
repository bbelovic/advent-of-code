package net.bbelovic.adventofcode.year2018.day3

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
                    ), 1)
                },
                Arguments {
                    arrayOf(listOf(
                            Rectangle(1, 1, 0, 2, 2),
                            Rectangle(2, 2, 1, 2, 2),
                            Rectangle(3, 0, 2, 2, 2)
                    ), 3)

                },
                Arguments {
                    arrayOf(listOf(
                            Rectangle(1, 1, 0, 2, 2),
                            Rectangle(2, 2, 1, 2, 2),
                            Rectangle(3, 0, 2, 2, 2),
                            Rectangle(5, 0, 0, 1, 2),
                            Rectangle(4, 0, 3, 4, 1)
                    ), 5)
                },
                Arguments {
                    arrayOf(listOf(
                            Rectangle(1, 1, 0, 2, 2),
                            Rectangle(2, 2, 1, 2, 2),
                            Rectangle(3, 0, 2, 2, 2),
                            Rectangle(5, 0, 0, 1, 2),
                            Rectangle(4, 0, 3, 4, 1),
                            Rectangle(6, 0, 1, 1, 2),
                            Rectangle(7, 3, 0, 1, 1)
                    ), 7)
                },
                Arguments {
                    arrayOf(listOf(
                            Rectangle(1, 1, 0, 2, 2),
                            Rectangle(2, 2, 1, 2, 2),
                            Rectangle(3, 0, 2, 2, 2),
                            Rectangle(5, 0, 0, 1, 2),
                            Rectangle(4, 0, 3, 4, 1),
                            Rectangle(6, 0, 1, 1, 2),
                            Rectangle(7, 3, 0, 1, 1),
                            Rectangle(8, 0, 1, 1, 2)
                    ), 7)

                }
        )

    }
}