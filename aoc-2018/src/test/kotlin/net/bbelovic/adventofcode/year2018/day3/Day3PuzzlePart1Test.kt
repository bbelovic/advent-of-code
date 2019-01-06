package net.bbelovic.adventofcode.year2018.day3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day3PuzzlePart1Test {
    @ParameterizedTest
    @MethodSource("testFabric")
    fun `should made claim on fabric`(claim: Rectangle, expectedFabric: Array<Array<Boolean>>) {
        val fabric = Fabric(3, 3)
        fabric.makeClaim(claim)
        assertTrue(expectedFabric.contentDeepEquals(fabric.claims()))
    }

    @ParameterizedTest
    @MethodSource("testOverlaps")
    fun `should compute fabric overlaps`(rectangles: List<Rectangle>, expectedOverlap: Long) {
        val fabric = Fabric(3, 3)
        rectangles.forEach { it -> fabric.makeClaim(it) }
        val actualOverlap = fabric.overlap()
        assertEquals(expectedOverlap, actualOverlap)
    }

    @Test
    fun `should throw exception for invalid input`() {
        assertThrows(IllegalArgumentException().javaClass) { RectangleParser().parse("@ 335,901: 28x17") }
        assertThrows(IllegalArgumentException().javaClass) { RectangleParser().parse("# @ 335,901: 28x17") }
        assertThrows(IllegalArgumentException().javaClass) { RectangleParser().parse("#1 @ ,901: 28x17") }
        assertThrows(IllegalArgumentException().javaClass) { RectangleParser().parse("#1 @ 335,901: ") }
    }

    companion object {
        @JvmStatic
        private fun testFabric() = listOf(
                Arguments { arrayOf(Rectangle(1, 1, 1, 2, 2),
                        arrayOf(arrayOf(false, false, false),
                                arrayOf(false, true, true),
                                arrayOf(false, true, true))
                ) },
                Arguments { arrayOf(Rectangle(2, 0, 0, 1, 3),
                        arrayOf(arrayOf(true, false, false),
                                arrayOf(true, false, false),
                                arrayOf(true, false, false))
                        ) },
                Arguments { arrayOf(Rectangle(3, 0, 0, 3, 1),
                        arrayOf(arrayOf(true, true, true),
                                arrayOf(false, false, false),
                                arrayOf(false, false, false))
                        ) }
        )

        @JvmStatic
        private fun testOverlaps() = listOf(
                Arguments { arrayOf(listOf(Rectangle(1, 0, 0, 1, 3),
                        Rectangle(2, 0, 0, 3, 1)), 1L) },

                Arguments { arrayOf(listOf(Rectangle(1, 0, 0, 3, 1),
                        Rectangle(2, 0, 2, 3, 1)), 0L) }

        )
    }
}