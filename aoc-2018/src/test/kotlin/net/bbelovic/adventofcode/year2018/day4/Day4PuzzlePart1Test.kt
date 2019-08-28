package net.bbelovic.adventofcode.year2018.day4

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day4PuzzlePart1Test {
    @Test
    fun testSortInput() {
        val input = """
                    [1518-08-06 00:13] falls asleep
                    [1518-06-10 00:37] wakes up
                    [1518-07-08 00:20] wakes up
                    [1518-05-13 00:24] falls asleep
                    """.trimIndent().lineSequence()
        val expected ="""
            [1518-05-13 00:24] falls asleep
            [1518-06-10 00:37] wakes up
            [1518-07-08 00:20] wakes up
            [1518-08-06 00:13] falls asleep
        """.trimIndent().lines()

        val actual = input.sortedWith(InputLineComparator).toList()
        assertEquals(expected, actual)
    }
}