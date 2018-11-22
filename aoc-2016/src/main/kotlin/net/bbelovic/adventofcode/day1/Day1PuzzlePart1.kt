package net.bbelovic.adventofcode.day1

import net.bbelovic.adventofcode.Puzzle
import net.bbelovic.adventofcode.day1.Direction.Left
import net.bbelovic.adventofcode.day1.Direction.Right
import kotlin.math.abs

class Day1PuzzlePart1 : Puzzle<String, Long> {
    override fun solve(input: String): Long {
        val allVisitedPoints = hashSetOf<Point>()
        val list = input.split(", ")
        var actualPosition = Position(Point(0, 1))
        for (inp in list) {
            val directionCode = inp.first()
            val steps = inp.substring(1).toInt()
            actualPosition = when (directionCode) {
                'L' -> actualPosition turn Left moveBy steps
                'R' -> actualPosition turn Right  moveBy steps
                else -> throw IllegalArgumentException("Unknown input [$input]")
            }
            val visitedPoints = actualPosition.visitedPoints()
            for (point in visitedPoints) {
                if (point in allVisitedPoints) {
                    return distance(point)
                }
            }
        }
        return distance(actualPosition.value)
    }

    private fun distance(p: Point): Long {
        return abs(0L - p.x) + abs(0L - p.y)
    }
}