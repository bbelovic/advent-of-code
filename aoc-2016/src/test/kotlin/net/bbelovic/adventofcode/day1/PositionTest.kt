package net.bbelovic.adventofcode.day1

import net.bbelovic.adventofcode.day1.Direction.Left
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PositionTest {
    @Test
    fun should_change_direction_of_position_in_given_way() {
        val position = Position(orientation = Point(0, 1))
        val expected = Position(orientation = Point(-1, 0))
        val actual = position turn Left
        assertEquals(expected, actual)
    }

    @Test
    fun should_move_number_of_steps_in_direction() {
        val position = Position(orientation = Point(0, 1))
        val expected = Position(Point(0, 1), Point(0, 3), listOf(Point(0, 1), Point(0, 2), Point(0, 3)))
        val actual = position moveBy 3
        assertEquals(expected, actual)
    }

    @Test
    fun should_enumerate_points_between_start_and_end() {
        val start = Position(orientation = Point(0, 1))
        val end = start moveBy 3
        val visited = end.visitedPoints(start.value, 3)
        val expected = listOf(Point(0, 1), Point(0, 2), Point(0, 3))
        Assertions.assertEquals(expected, visited)
    }

    @Test
    fun test() {
        val s = "L3"
        val split = s.split(Regex("[LR][0-9]{1,3}"))
    }
}