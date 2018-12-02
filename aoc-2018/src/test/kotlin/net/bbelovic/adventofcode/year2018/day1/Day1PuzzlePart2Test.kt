package net.bbelovic.adventofcode.year2018.day1

import net.bbelovic.adventofcode.Puzzle
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day1PuzzlePart2Test {
    @ParameterizedTest
    @MethodSource("testData")
    fun should_tell_what_frequency_is_reached_twice(input: String, expectedFrequency: Long) {
        val puzzle: Puzzle<String, Long> = Day1PuzzlePart2()
        val actualFrequency = puzzle.solve(input)
        assertEquals(expectedFrequency, actualFrequency)
    }

    companion object {
        @JvmStatic
        fun testData() = listOf<Arguments>(
                Arguments.of("+3, +3, +4, -2, -4" , 10L),
                Arguments.of("+1, -1" , 0L),
                Arguments.of("-6, +3, +8, +5, -6" , 5L),
                Arguments.of("+7, +7, -2, -7, -4" , 14L)
        )
    }
}