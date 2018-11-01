package net.bbelovic.adventofcode.day1

import net.bbelovic.adventofcode.Puzzle
import java.lang.IllegalArgumentException
import kotlin.math.abs

class Day1PuzzlePart1 : Puzzle<String, Long> {
    override fun solve(input: String): Long {
        val list = input.split(", ")

        var start = Position(Point(0, 1))

        for (inp in list) {
            val directionCode = inp.first()
            start = when (directionCode) {
                'L' -> start.turn(Point.Direction.Left).moveBy(inp.last().toString().toInt())
                'R' -> start.turn(Point.Direction.Right).moveBy(inp.last().toString().toInt())
                else -> throw IllegalArgumentException("Unknown input '$input'")
            }
        }
        return distance(start.value)
    }

    private fun distance(p: Point): Long {
        return abs(0L - p.x) + abs(0L - p.y)
    }
}