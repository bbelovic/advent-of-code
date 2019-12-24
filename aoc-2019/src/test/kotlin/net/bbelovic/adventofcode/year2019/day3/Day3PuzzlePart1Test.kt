package net.bbelovic.adventofcode.year2019.day3

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test


class Day3PuzzlePart1Test {
    @Test
    fun `should move in given direction given number of steps`() {
        val space = Space()
//        val first = listOf("R75","D30","R83","U83","L12","D49","R71","U7","L72")
//        val second = listOf("U62","R66","U55", "R34","D71","R55","D58","R83")
        space.move(listOf("R8", "U5"))

        val expectedCoordinates = mutableSetOf(CoordinateRecord("wire1", 1, 0),
                CoordinateRecord("wire1", 2, 0),
                CoordinateRecord("wire1", 3, 0),
                CoordinateRecord("wire1", 4, 0),
                CoordinateRecord("wire1", 5, 0),
                CoordinateRecord("wire1", 6, 0),
                CoordinateRecord("wire1", 7, 0),
                CoordinateRecord("wire1", 8, 0),
                CoordinateRecord("wire1", 8, 1),
                CoordinateRecord("wire1", 8, 2),
                CoordinateRecord("wire1", 8, 3),
                CoordinateRecord("wire1", 8, 4),
                CoordinateRecord("wire1", 8, 5)
        )

        Assertions.assertThat(space.coordinates).isEqualTo(expectedCoordinates)
    }
}