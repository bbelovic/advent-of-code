package net.bbelovic.adventofcode.year2018.day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day3PuzzlePart1Test {
    @Test
    fun `should compute rectangle intersection`() {
        val first = Rectangle(1, 3, 4, 4)
        val second = Rectangle(3, 1, 4, 4)
        val area = first.intersect(second)
        assertEquals(4, area)
    }

    @ParameterizedTest
    @MethodSource("testRectangles")
    fun `should parse rectangle from string`(input: String, expectedRectangle: Rectangle) {
        val actualRectangle: Rectangle = RectangleParser().parse(input)
        assertEquals(expectedRectangle, actualRectangle)
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
        private fun testRectangles() = listOf(
                Arguments { arrayOf("#1 @ 1,3: 4x4", Rectangle(1, 3, 4,4)) },
                Arguments { arrayOf("#99 @ 335,901: 28x17", Rectangle(335, 901, 28, 17)) },
                Arguments { arrayOf("#100 @ 52,312: 14x16", Rectangle( 52, 312, 14, 16)) },
                Arguments { arrayOf("#101 @ 13,487: 21x13", Rectangle( 13, 487, 21, 13)) },
                Arguments { arrayOf("#403 @ 201,97: 6x9", Rectangle(201, 97, 6, 9)) },
                Arguments { arrayOf("#96 @ 8,593: 10x21", Rectangle(8, 593, 10, 21)) },
                Arguments { arrayOf("#102 @ 937,624: 15x23", Rectangle(937, 624, 15, 23)) }
        )
    }
}