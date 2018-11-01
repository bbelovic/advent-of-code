package net.bbelovic.adventofcode.day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PositionTest {
    @Test
    fun should_change_direction_of_position_in_given_way() {
        val position = Position(Point(0, 1), Point(0, 0))
        val expected = Position(Point(-1, 0), Point(0, 0))
        val actual = position.turn(Point.Direction.Left)
        assertEquals(expected, actual)
    }

    @Test
    fun should_move_number_of_steps_in_direction() {
        val position = Position(Point(0, 1), Point(0, 0))
        val expected = Position(Point(0, 1), Point(3, 0))
        val actual = position.moveBy(3)
        assertEquals(expected, actual)

    }
}