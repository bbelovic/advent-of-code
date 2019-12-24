package net.bbelovic.adventofcode.year2019.day3

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test


class Day3PuzzlePart1Test {
    @Test
    fun `should move in given direction given number of steps`() {
        val space = Space()
//        val first = listOf("R75","D30","R83","U83","L12","D49","R71","U7","L72")
//        val second = listOf("U62","R66","U55", "R34","D71","R55","D58","R83")
        space.move(listOf("R8"))

        Assertions.assertThat(space.coordinates.size).isEqualTo(8)
    }
}