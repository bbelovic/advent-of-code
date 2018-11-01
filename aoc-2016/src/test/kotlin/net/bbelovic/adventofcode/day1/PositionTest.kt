package net.bbelovic.adventofcode.day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PositionTest {
    @Test
    fun should_change_direction_of_position_in_given_way() {
        val position = Position(orientation = Point(0, 1))
        val expected = Position(orientation = Point(-1, 0))
        val actual = position.turn(Point.Direction.Left)
        assertEquals(expected, actual)
    }

    @Test
    fun should_move_number_of_steps_in_direction() {
        val position = Position(orientation = Point(0, 1))
        val expected = Position(orientation = Point(0, 1))
        val actual = position.moveBy(3)
        assertEquals(expected, actual)

    }
}