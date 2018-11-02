package net.bbelovic.adventofcode.day1

import net.bbelovic.adventofcode.day1.Direction.Left
import net.bbelovic.adventofcode.day1.Direction.Right

data class Point(val x: Int, val y: Int) {

    fun turn(direction: Direction) =
            when (direction) {
                Left -> Point(-y, x)
                Right -> Point(y, -x)
            }

    operator fun plus(other: Point) = Point(x + other.x, y + other.y)

    operator fun times(scale: Int) = Point(scale * x, scale * y)
}