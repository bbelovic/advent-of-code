package net.bbelovic.adventofcode.year2018.day4

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class Day4PuzzlePart2Test {
    @Test //@Disabled
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
        assertEquals(4455, actual)

    }

    @Test
    fun testGrouping() {

        val m = mapOf(1 to listOf(1, 2, 1, 1, 3, 3, 5), 2 to emptyList(), 3 to listOf(1, 9, 9, 5, 0, 1, 5))
        m.asSequence().groupingBy {  }



        val eachCount = listOf(1, 0, 40, 1, 4, 4, 5, 7, 0, 9, 1)
                .asSequence()
                .groupingBy { it }.eachCount()
        println(eachCount)

        val maxBy = eachCount.asSequence().maxBy { entry -> entry.value }
        assertEquals(maxBy?.value, 3)
    }
}