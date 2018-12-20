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

        var rgx = "#[0-9] @ [0-9],[0-9]: [0-9]x[0-9]"
        var rgx2 = "#(\\d{1,}) @ (\\d{1,}),(\\d{1,}): (\\d{1,})x(\\d{1,})"
        var rgx3 = "#\\d{1,} @ \\d{1,},\\d{1,}: \\d{1,}x\\d{1,}"

        val pattern = Pattern.compile(rgx2)
        val matcher = pattern.matcher("#415 @ 29,601: 13x12")
        val result = matcher.matches()
        println(result)
        println(matcher.groupCount())
        println(matcher.group(1))

        val input = "#1 @ 1,3: 4x4"
        val expected: Rectangle = RectangleParser().parse(input)
        val actual = Rectangle(1,3, 4, 4)
        Assertions.assertEquals(expected, actual)
    }
}