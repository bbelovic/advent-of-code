package net.bbelovic.adventofcode.day1

import net.bbelovic.adventofcode.day1.DirectionVector.Direction.Left
import net.bbelovic.adventofcode.day1.DirectionVector.Direction.Right

data class DirectionVector(val x: Int, val y: Int) {

    fun turn(direction: Direction) =
            when (direction) {
                Left -> DirectionVector(-y, x)
                Right -> DirectionVector(y, -x)
            }

    enum class Direction { Left, Right }
}