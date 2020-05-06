package net.bbelovic.adventofcode.year2018.day4

import net.bbelovic.adventofcode.InputReader
import net.bbelovic.adventofcode.utils.dsl.testDataDsl
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

const val EXPECTED_RESULT_DEMO_INPUT = 4455
const val EXPECTED_RESULT_PUZZLE_INPUT = 117061

internal class Day4PuzzlePart2Test {
    @Test
    fun `should process demo input`() {
        val demoInput = """
            [1518-11-01 00:00] Guard #10 begins shift
            [1518-11-01 00:05] falls asleep
            [1518-11-01 00:25] wakes up
            [1518-11-01 00:30] falls asleep
            [1518-11-01 00:55] wakes up
            [1518-11-01 23:58] Guard #99 begins shift
            [1518-11-02 00:40] falls asleep
            [1518-11-02 00:50] wakes up
            [1518-11-03 00:05] Guard #10 begins shift
            [1518-11-03 00:24] falls asleep
            [1518-11-03 00:29] wakes up
            [1518-11-04 00:02] Guard #99 begins shift
            [1518-11-04 00:36] falls asleep
            [1518-11-04 00:46] wakes up
            [1518-11-05 00:03] Guard #99 begins shift
            [1518-11-05 00:45] falls asleep
            [1518-11-05 00:55] wakes up"""
                .trimIndent().lines().shuffled()
        val puzzle = Day4PuzzlePart1(SameMinuteGuardAsleepSelector())
        val actual = puzzle.solve(demoInput)
        assertEquals(EXPECTED_RESULT_DEMO_INPUT, actual)
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `should process puzzle input`(selector: GuardAsleepSelector) {
        val puzzle = Day4PuzzlePart1(selector)
        val input = InputReader().readAllLines("input4.txt")
        val actual = puzzle.solve(input)
        assertEquals(EXPECTED_RESULT_PUZZLE_INPUT, actual)
    }

    companion object {
        @JvmStatic
        fun testData() = testDataDsl {
            testArguments (SameMinuteGuardAsleepGroupingSelector())
            testArguments (SameMinuteGuardAsleepSelector())
        }
    }
}