package net.bbelovic.adventofcode.day1

import java.util.*
import kotlin.collections.ArrayList

data class Position(val orientation: Point, val value: Point = Point(0,0), val visitedPoints: List<Point> = emptyList()) {
    infix fun turn(direction: Direction) = Position(orientation.turn(direction), value)
    infix fun moveBy(steps: Int): Position {
        val visitedPoints = visitedPoints(value, steps)
        return Position(orientation, value + orientation * steps, visitedPoints)
    }
    fun visitedPoints(start: Point, steps: Int): List<Point> {
        val result = ArrayList<Point>()
        for (x in 1..steps) {
            result.add(start + orientation * x)
        }
        return result
    }
}