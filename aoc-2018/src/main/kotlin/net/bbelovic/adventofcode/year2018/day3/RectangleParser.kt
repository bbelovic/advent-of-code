package net.bbelovic.adventofcode.year2018.day3

import java.lang.IllegalStateException

class RectangleParser {
    fun parse(input: String): Rectangle {
        val split = input.split(" ")
        if (split.size == 4) {
            val upperLeft = parseUpperLeft(split[2])
            val dimensions = parseDimensions(split[3])
            return Rectangle(upperLeft.first, upperLeft.second, dimensions.first,
                    dimensions.second)
        }
        throw IllegalStateException("Unable to parse rectangle from: [$input]")
    }

    private fun parseUpperLeft(input: String): Pair<Int, Int> {
        val x = input.substring(0, input.indexOf(","))
        val y = input.substring(input.indexOf(",") + 1, input.indexOf(":"))
        return Pair(x.toInt(), y.toInt())
    }

    private fun parseDimensions(input: String): Pair<Int, Int> {
        val idx = input.indexOf("x")
        val width = input.substring(0, idx)
        val height = input.substring(idx + 1)
        return Pair(width.toInt(), height.toInt())
    }
}
