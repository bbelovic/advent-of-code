package net.bbelovic.adventofcode.year2018.day4

import net.bbelovic.adventofcode.InputReader
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.Duration
import java.time.LocalTime
import java.util.*

internal class Day4PuzzlePart1Test {

    @Test
    fun `should sort input file`() {
        val puzzle = Day4PuzzlePart1()
        val input = InputReader().readAllLines("input4.txt")
        puzzle.solve(input)
    }

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

    @Test
    fun test() {
        val asleep = LocalTime.of(0, 24)
        val awake = LocalTime.of(0, 37)
        val between = Duration.between(asleep, awake)
//        println(between.dividedBy(Duration.of(60, ChronoUnit.SECONDS)))

        val bitSet = BitSet()
        val bitSet2 = BitSet()
        val bitSet3 = BitSet()
        bitSet.set(5, 25)
        bitSet2.set(30, 54)
        bitSet3.set(24, 28)

        bitSet.and(bitSet3)
//        bitSet.and(bitSet3)

        bitSet.stream().forEach { println(it) }


    }
}