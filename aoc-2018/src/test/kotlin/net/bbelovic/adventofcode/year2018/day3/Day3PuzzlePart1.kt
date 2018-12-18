package net.bbelovic.adventofcode.year2018.day3

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day3PuzzlePart1 {
    @Test
    fun `should compute rectangle intersection`() {
        val first = Rectangle(1, 3, 4, 4)
        val second = Rectangle(3, 1, 4, 4)
        val area = first.intersect(second)
        Assertions.assertEquals(4, area)
    }

    @Test
    fun `should parse rectangle from string`() {
        val input = "#1 @ 1,3: 4x4"
        val expected: Rectangle = RectangleParser().parse(input)
        val actual = Rectangle(1,3, 4, 4)
        Assertions.assertEquals(expected, actual)
    }
}