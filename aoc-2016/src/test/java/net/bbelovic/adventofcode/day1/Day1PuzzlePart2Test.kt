package net.bbelovic.adventofcode.day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class Day1PuzzlePart2Test {
    private val puzzle = Day1PuzzlePart2()
    @Test
    fun should_compute_distance_to_first_location_visited_twice() {
        val actualResult = puzzle.solve("R8, R4, R4, R8")
        assertEquals(4L, actualResult)
    }

    @Test
    fun should_throw_exception_when_no_position_was_visited_twice() {
        assertThrows(IllegalStateException().javaClass) {puzzle.solve("R8, R4")}
    }
}