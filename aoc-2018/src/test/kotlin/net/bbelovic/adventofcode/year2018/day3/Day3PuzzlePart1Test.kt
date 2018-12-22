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
        assertThrows(IllegalArgumentException().javaClass) {RectangleParser().parse("@ 335,901: 28x17") }
        assertThrows(IllegalArgumentException().javaClass) {RectangleParser().parse("# @ 335,901: 28x17") }
        assertThrows(IllegalArgumentException().javaClass) {RectangleParser().parse("#1 @ ,901: 28x17") }
        assertThrows(IllegalArgumentException().javaClass) {RectangleParser().parse("#1 @ 335,901: ") }
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `should parse fabric information the Kotlin way`(input: String, expected: List<Int>) {
        val regex = """#(\d{1,}) @ (\d{1,}),(\d{1,}): (\d{1,})x(\d{1,})""".toRegex()
        val (id, x, y, width, height) = regex.matchEntire(input)!!.destructured
        val actual = listOf(id.toInt(), x.toInt(), y.toInt(), width.toInt(), height.toInt())
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        private fun testRectangles() = listOf(
                Arguments.of("#1 @ 1,3: 4x4", Rectangle(1, 3, 4,4)),
                Arguments.of("#99 @ 335,901: 28x17", Rectangle(335, 901, 28, 17)),
                Arguments.of("#100 @ 52,312: 14x16", Rectangle( 52, 312, 14, 16)),
                Arguments.of("#101 @ 13,487: 21x13", Rectangle( 13, 487, 21, 13)),
                Arguments.of("#403 @ 201,97: 6x9", Rectangle(201, 97, 6, 9)),
                Arguments.of("#96 @ 8,593: 10x21", Rectangle(8, 593, 10, 21)),
                Arguments.of("#102 @ 937,624: 15x23", Rectangle(937, 624, 15, 23))

        )

        @JvmStatic
        private fun testData() = listOf(
                Arguments.of("#1 @ 1,3: 4x4", listOf(1, 1, 3, 4, 4)),
                Arguments.of("#99 @ 335,901: 28x17", listOf(99, 335, 901, 28, 17)),
                Arguments.of("#100 @ 52,312: 14x16", listOf(100, 52, 312, 14, 16)),
                Arguments.of("#101 @ 13,487: 21x13", listOf(101, 13, 487, 21, 13)),
                Arguments.of("#403 @ 201,97: 6x9", listOf(403, 201, 97, 6, 9)),
                Arguments.of("#96 @ 8,593: 10x21", listOf(96, 8, 593, 10, 21)),
                Arguments.of("#102 @ 937,624: 15x23", listOf(102, 937, 624, 15, 23))
        )
    }
}