package net.bbelovic.adventofcode.year2018.day3

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day3PuzzlePart1Test {
    @Test
    fun `should made claim on fabric`() {
        val fabric = Fabric(3, 3)
        val claim1 = Rectangle(1, 1, 1, 2, 2)

        fabric.makeClaim(claim1)

        val expected = Array ( 3) { Array(3) {false} }
        expected[1][1] = true
        expected[1][2] = true
        expected[2][1] = true
        expected[2][2] = true

        assertTrue(expected.contentDeepEquals(fabric.fabric))

        val claim2 = Rectangle(2, 0, 0, 3, 1)
        fabric.makeClaim(claim2)
        println(fabric.fabric.contentDeepToString())

        expected[0][0] = true
        expected[0][1] = true
        expected[0][2] = true
        assertTrue(expected.contentDeepEquals(fabric.fabric))

        val f2 = Fabric(3, 3)
        f2.makeClaim(Rectangle(1, 0, 0, 1, 3))

        val expectedf2 = arrayOf(arrayOf(true, false, false),
                arrayOf(true, false, false),
                arrayOf(true, false, false))

        println(f2.fabric.contentDeepToString())
        assertTrue(f2.fabric.contentDeepEquals(expectedf2))

    }

    @Test
    fun `should compute rectangle area`() {
        val r = Rectangle(1, 0,0, 5, 3)
        val actualArea = r.area()
        val expectedArea = 15
        Assertions.assertEquals(expectedArea, actualArea)
    }

    @Test
    fun `should compute rectangle intersection`() {
        val first = Rectangle(1,1, 3, 4, 4)
        val second = Rectangle(2,3, 1, 4, 4)
        var area = first.intersect(second)
        assertEquals(4, area)
        area = second.intersect(first)
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
                Arguments { arrayOf("#1 @ 1,3: 4x4", Rectangle(1,2, 4, 4, 4)) },
                Arguments { arrayOf("#99 @ 335,901: 28x17", Rectangle(99,336, 902, 28, 17)) },
                Arguments { arrayOf("#100 @ 52,312: 14x16", Rectangle(100, 53, 313, 14, 16)) },
                Arguments { arrayOf("#101 @ 13,487: 21x13", Rectangle(101, 14, 488, 21, 13)) },
                Arguments { arrayOf("#403 @ 201,97: 6x9", Rectangle(403,202, 98, 6, 9)) },
                Arguments { arrayOf("#96 @ 8,593: 10x21", Rectangle(96,9, 594, 10, 21)) },
                Arguments { arrayOf("#102 @ 937,624: 15x23", Rectangle(102,938, 625, 15, 23)) }
        )
    }
}