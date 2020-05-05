package net.bbelovic.adventofcode.year2018.day1

import net.bbelovic.adventofcode.Puzzle
import net.bbelovic.adventofcode.utils.dsl.testDataDsl
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class Day1PuzzlePart1Test {
    @ParameterizedTest
    @MethodSource("testData")
    fun should_compute_final_frequency_from_frequency_changes(input: String, expectedFrequency: Long) {
        val puzzle: Puzzle<String, Long> = Day1PuzzlePart1()
        val actualFrequency = puzzle.solve(input)
        assertEquals(expectedFrequency, actualFrequency)
    }

    companion object {
        @JvmStatic
        fun testData() = testDataDsl {
            testArguments ("+1, -2, +3, +1", 3L)
            testArguments ("+1, +1, +1", 3L)
            testArguments ("+1, +1, -2", 0L)
            testArguments ("-1, -2, -3", -6L)
        }
    }
}