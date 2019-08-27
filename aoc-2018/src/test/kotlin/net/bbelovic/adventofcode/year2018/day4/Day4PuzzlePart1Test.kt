package net.bbelovic.adventofcode.year2018.day4

import org.junit.jupiter.api.Test
import java.time.format.DateTimeFormatter

internal class Day4PuzzlePart1Test {
    @Test
    fun testSortInput(): Unit {
        val s = """[1518-08-06 00:13] falls asleep
                    [1518-06-10 00:37] wakes up
                    [1518-07-08 00:20] wakes up
                    [1518-05-13 00:24] falls asleep
                    [1518-11-07 00:32] falls asleep
                    [1518-11-21 00:01] Guard #641 begins shift
                    [1518-05-29 00:31] falls asleep
                    [1518-09-28 23:59] Guard #3023 begins shift
                    """.lineSequence()


    }

    @Test
    fun testRegex() {
        val regex = """([[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}]) ([a-zA-Z0-9]+)""".toRegex()
        val regex2 = """\[([0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2})\]""".toRegex()
        val input = "[1518-09-28 23:59] Guard #3023 begins shift"
        val input2 = "[1518-09-28 23:59]"
        val (first: String) = regex2.matchEntire(input2)!!.destructured

        val result = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm").parse(first)



        println("${first}, ${result}")
    }
}