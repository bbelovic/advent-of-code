package net.bbelovic.adventofcode.year2018.day4

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

internal class Day4PuzzlePart1Test {
    @Test
    fun testSortInput(): Unit {
        val input = """
                    [1518-08-06 00:13] falls asleep
                    [1518-06-10 00:37] wakes up
                    [1518-07-08 00:20] wakes up
                    [1518-05-13 00:24] falls asleep
                    """.lineSequence()
        val expected ="""
            [1518-05-13 00:24] falls asleep
            [1518-06-10 00:37] wakes up
            [1518-07-08 00:20] wakes up
            [1518-08-06 00:13] falls asleep
        """.lines()

        val actual = input.sortedWith(InputLineComparator).toList()
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun testRegex() {
        val regex = """(\[[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}\]) ([a-zA-Z0-9]+)""".toRegex()
        val regex2 = """\[([0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2})\]""".toRegex()
        val input = "[1518-09-28 23:59] Guard #3023 begins shift"
        val input2 = "[1518-09-28 23:59]"
        val (first: String) = regex.matchEntire(input)!!.destructured

        val result = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm").parse(first)
        val dateTime = LocalDateTime.from(result)



        println("${first}, ${dateTime}")
    }
}