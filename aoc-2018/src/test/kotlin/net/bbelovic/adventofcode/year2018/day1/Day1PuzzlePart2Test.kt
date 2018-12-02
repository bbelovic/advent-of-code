package net.bbelovic.adventofcode.year2018.day1

import net.bbelovic.adventofcode.Puzzle
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day1PuzzlePart2Test {
    @Test
    fun should_tell_what_frequency_is_reached_twice() {
        val input = "+3, +3, +4, -2, -4"
        val puzzle: Puzzle<String, Long> = Day1PuzzlePart2()
        val actualFrequency = puzzle.solve(input)
        val expectedFrequency = 10
        assertEquals(expectedFrequency, actualFrequency)
    }
}