package net.bbelovic.adventofcode.year2018.day3

import net.bbelovic.adventofcode.utils.dsl.testDataDsl
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class Day3PuzzlePart1Test {
    @ParameterizedTest
    @MethodSource("testData")
    fun `should compute fabric overlaps`(rectangles: List<String>, expectedOverlap: Long) {
        val puzzle = Day3PuzzlePart1()
        val actualOverlap = puzzle.solve(rectangles)
        assertEquals(expectedOverlap, actualOverlap)
    }

    @Test
    fun `should throw exception for invalid input`() {
        assertThrows(IllegalArgumentException().javaClass) { RectangleParser.parse("@ 335,901: 28x17") }
        assertThrows(IllegalArgumentException().javaClass) { RectangleParser.parse("# @ 335,901: 28x17") }
        assertThrows(IllegalArgumentException().javaClass) { RectangleParser.parse("#1 @ ,901: 28x17") }
        assertThrows(IllegalArgumentException().javaClass) { RectangleParser.parse("#1 @ 335,901: ") }
    }

    companion object {
        @JvmStatic
        private fun testData() = testDataDsl {
            testArguments (listOf("#1 @ 0,0: 1x3", "#2 @ 0,0: 3x1"), 1L)
            testArguments (listOf("#1 @ 0,0: 3x1", "#2 @ 0,2: 3x1"), 0L)
            testArguments (listOf("#1 @ 0,0: 2x2", "#2 @ 1,1: 2x2"), 1L)
            testArguments (listOf("#1 @ 0,0: 1x1", "#2 @ 0,0: 1x1", "#3 @ 0,0: 1x1"), 1L)
        }
    }
}