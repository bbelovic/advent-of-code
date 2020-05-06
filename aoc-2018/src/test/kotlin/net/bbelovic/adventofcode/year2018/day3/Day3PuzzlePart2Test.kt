package net.bbelovic.adventofcode.year2018.day3

import net.bbelovic.adventofcode.utils.dsl.testDataDsl
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class Day3PuzzlePart2Test {
    @ParameterizedTest
    @MethodSource("testData")
    fun `should identify claim that does not overlap`(rectangles: List<String>, expectedClaimId: Long) {
        val puzzle = Day3PuzzlePart2()
        val actual = puzzle.solve(rectangles)
        assertEquals(expectedClaimId, actual)
    }

    companion object {
        @JvmStatic
        private fun testData() = testDataDsl {
            testArguments (listOf("#1 @ 1,0: 2x2"), 1L)

            testArguments (listOf(
                    "#1 @ 1,0: 2x2",
                    "#2 @ 2,1: 2x2",
                    "#3 @ 0,2: 2x2"), 3L)

            testArguments (listOf(
                    "#1 @ 1,0: 2x2",
                    "#2 @ 2,1: 2x2",
                    "#3 @ 0,2: 2x2",
                    "#5 @ 0,0: 1x2",
                    "#4 @ 0,3: 4x1"), 5L)

            testArguments (listOf(
                    "#1 @ 1,0: 2x2",
                    "#2 @ 2,1: 2x2",
                    "#3 @ 0,2: 2x2",
                    "#5 @ 0,0: 1x2",
                    "#4 @ 0,3: 4x1",
                    "#6 @ 0,1: 1x2",
                    "#7 @ 3,0: 1x1"), 7L)

            testArguments (listOf(
                    "#1 @ 1,0: 2x2",
                    "#2 @ 2,1: 2x2",
                    "#3 @ 0,2: 2x2",
                    "#5 @ 0,0: 1x2",
                    "#4 @ 0,3: 4x1",
                    "#6 @ 0,1: 1x2",
                    "#7 @ 3,0: 1x1",
                    "#8 @ 0,1: 1x2"), 7L)
        }
    }
}