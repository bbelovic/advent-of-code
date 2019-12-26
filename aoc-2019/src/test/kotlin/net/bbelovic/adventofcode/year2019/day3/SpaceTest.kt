package net.bbelovic.adventofcode.year2019.day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SpaceTest {
    @Test
    fun `should move in given direction given number of steps`() {
        val space = Space()
        space.move(listOf("R8", "U5", "L5", "D3"))

        val expectedCoordinates = mutableListOf(CoordinateRecord("wire1", 1, 0),
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
                CoordinateRecord("wire1", 8, 5),
                CoordinateRecord("wire1", 7, 5),
                CoordinateRecord("wire1", 6, 5),
                CoordinateRecord("wire1", 5, 5),
                CoordinateRecord("wire1", 4, 5),
                CoordinateRecord("wire1", 3, 5),
                CoordinateRecord("wire1", 3, 4),
                CoordinateRecord("wire1", 3, 3),
                CoordinateRecord("wire1", 3, 2)
        )

        assertThat(space.coordinates).isEqualTo(expectedCoordinates)
    }

}