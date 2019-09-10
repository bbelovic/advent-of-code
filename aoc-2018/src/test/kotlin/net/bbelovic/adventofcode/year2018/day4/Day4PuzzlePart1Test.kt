package net.bbelovic.adventofcode.year2018.day4

import net.bbelovic.adventofcode.InputReader
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import java.io.BufferedReader
import java.io.StringReader

internal class Day4PuzzlePart1Test {

    @Test @Disabled
    fun `should process demo input`() {

    }

    @Test @Disabled
    fun `should sort input file`() {
        val puzzle = Day4PuzzlePart1()
        val input = InputReader().readAllLines("input4.txt")
        puzzle.solve(input)
    }

    @Test
    fun `should parse input`() {
        val input = """
            [1518-02-10 23:56] Guard #1487 begins shift
            [1518-02-11 00:14] falls asleep
            [1518-02-11 00:40] wakes up
            [1518-02-11 23:53] Guard #1493 begins shift
            [1518-02-12 00:04] falls asleep
            [1518-02-12 00:05] wakes up
            [1518-02-12 00:22] falls asleep
            [1518-02-12 00:43] wakes up
            [1518-02-12 23:57] Guard #103 begins shift
            [1518-02-13 00:25] falls asleep
            [1518-02-13 00:47] wakes up
            [1518-02-13 00:52] falls asleep
            [1518-02-13 00:58] wakes up
        """.trimIndent()
        val r = StringReader(input)
        val actual:List<GuardRecord?> = Day4PuzzlePart1InputParser.parse(BufferedReader(r))

        val gd1 = GuardRecord(1487)
        gd1.asleep(14)
        gd1.wakeUp(40)
        val gd2 = GuardRecord(1493)
        gd2.asleep(4)
        gd2.wakeUp(5)
        gd2.asleep(22)
        gd2.wakeUp(43)
        val gd3 = GuardRecord(103)
        gd3.asleep(25)
        gd3.wakeUp(47)
        gd3.asleep(52)
        gd3.wakeUp(58)

        val expected = listOf(gd1, gd2, gd3)
        assertEquals(expected, actual)

    }

    @Test
    fun `should sort test input`() {
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