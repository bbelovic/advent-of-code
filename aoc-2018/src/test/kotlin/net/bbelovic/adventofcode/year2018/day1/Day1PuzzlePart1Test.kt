package net.bbelovic.adventofcode.year2018.day1

import net.bbelovic.adventofcode.Puzzle
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day1PuzzlePart1Test {
    @Test
    fun should_compute_final_frequency_from_frequency_changes() {
        val input = "+1, -2, +3, +1"
        val puzzle: Puzzle<String, Long> = Day1PuzzlePart1()
        val actualFrequency = puzzle.solve(input)
        val expectedFrequency = 3L
        Assertions.assertEquals(expectedFrequency, actualFrequency)
    }
}