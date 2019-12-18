package net.bbelovic.adventofcode.year2018.day4

import net.bbelovic.adventofcode.InputReader
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

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
        val expected = 4455
        val actual = puzzle.solve(demoInput)
        assertEquals(expected, actual)
    }

    @Test
    fun `should process puzzle input`() {
        val puzzle = Day4PuzzlePart1(SameMinuteGuardAsleepSelector())
        val input = InputReader().readAllLines("input4.txt")
        val expected = 117061
        val actual = puzzle.solve(input)
        assertEquals(expected, actual)
    }

    @Test
    fun `should understand grouping`() {
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
        val puzzle = Day4PuzzlePart1(SameMinuteGuardAsleepGroupingSelector())
        val expected = 4455
        val actual = puzzle.solve(demoInput)
        assertEquals(expected, actual)

    }
}