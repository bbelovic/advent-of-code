package net.bbelovic.adventofcode.year2020.day2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day2PuzzlePart1Test {
    @Test
    fun `should count valid passwords - example data`() {
        val exampleInput = listOf("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")

        val actual = exampleInput.asSequence()
            .filter { each -> valid(each) }
            .count()
        assertThat(actual).isEqualTo(2)
    }

    private fun valid(line: String): Boolean {
        val regex = """(\d+)-(\d+) (\w): (\w+)""".toRegex()
        val (min, max, what, input) = regex.matchEntire(line)!!.destructured
        val count = input.asSequence()
            .filter { each -> each.toString() == what }
            .count()
        return count in min.toInt() .. max.toInt()
    }
}