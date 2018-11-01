package net.bbelovic.adventofcode.day1

import net.bbelovic.adventofcode.day1.Point.Direction.Left
import net.bbelovic.adventofcode.day1.Point.Direction.Right

data class Point(val x: Int, val y: Int) {

    fun turn(direction: Direction) =
            when (direction) {
                Left -> Point(-y, x)
                Right -> Point(y, -x)
            }

    enum class Direction { Left, Right }
}