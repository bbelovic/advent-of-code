package net.bbelovic.adventofcode.year2019.day3

import net.bbelovic.adventofcode.InputReader
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PuzzleBugHuntingTest {
    // 142375

    @Test
    fun `test regular expression`() {
        val input = InputReader().readFileIntoString("wire1.txt")
        val regex = """\(((-?[0-9]+), (-?[0-9]+))\)""".toRegex()
        val result = mutableListOf<Coordinates>()
        regex.findAll(input).forEach {
            val (component1, component2, component3) = it.destructured
            result.add(Coordinates(component2.toInt(), component3.toInt()))
        }
        assertThat(result.toSet().size)
                .isEqualTo(142375)
    }
}