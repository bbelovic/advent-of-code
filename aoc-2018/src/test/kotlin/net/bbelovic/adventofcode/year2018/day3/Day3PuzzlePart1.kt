package net.bbelovic.adventofcode.year2018.day3

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.regex.Pattern

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

    @Test
    fun `should parse fabric information the Kotlin way`() {
        val input = "#1 @ 1,3: 4x4"
        val regex = """#(\d{1,}) @ (\d{1,}),(\d{1,}): (\d{1,})x(\d{1,})""".toRegex()
        val (id, x, y, width, height) = regex.matchEntire(input)!!.destructured
        val groupValues = regex.matchEntire(input)!!.groupValues
        println(groupValues)

        Assertions.assertEquals(1, id.toInt())
        Assertions.assertEquals(1, x.toInt())
        Assertions.assertEquals(3, y.toInt())
        Assertions.assertEquals(4, width.toInt())
        Assertions.assertEquals(4, height.toInt())


    }
}