package net.bbelovic.adventofcode.day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day1PuzzlePart2Test {
    @ParameterizedTest
    @MethodSource("testData")
    fun should_compute_distance_to_first_location_visited_twice(input: String, expectedResult: Long) {
        val puzzle = Day1PuzzlePart2()
        val actualResult = puzzle.solve(input)
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun should_throw_exception_when_no_position_was_visited_twice() {
        val input = "R8, R4, R4"
        assertThrows(IllegalStateException().javaClass) {Day1PuzzlePart2().solve(input)}
    }

    companion object {
        @JvmStatic
        fun testData() = listOf<Arguments>(
                Arguments.of("R8, R4, R4, R8", 4L)
        )
    }

}