package net.bbelovic.adventofcode.year2019.day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

private const val WIRE_ID1 = "wire-1"

internal class SpaceTest {
    @Test
    fun `should detect correct number of crossings`() {
        val space = Space()
        space.move(listOf("R8", "U5", "L5", "D3"))
        space.move(listOf("U7", "R6", "D4", "L4"))
        assertThat(space.collisions)
                .isEqualTo(mutableSetOf(CoordinateRecord(WIRE_ID1, 6, 5), CoordinateRecord(WIRE_ID1, 3, 3)))

    }
    @Test
    fun `should move in given direction given number of steps`() {
        val space = Space()
        space.move(listOf("R8", "U5", "L5", "D3"))
        assertThat(space.coordinates).isEqualTo(expectedCoordinateRecords())
    }

    private fun expectedCoordinateRecords(): MutableList<CoordinateRecord> {
        return mutableListOf(CoordinateRecord(WIRE_ID1, 1, 0),
                CoordinateRecord(WIRE_ID1, 2, 0),
                CoordinateRecord(WIRE_ID1, 3, 0),
                CoordinateRecord(WIRE_ID1, 4, 0),
                CoordinateRecord(WIRE_ID1, 5, 0),
                CoordinateRecord(WIRE_ID1, 6, 0),
                CoordinateRecord(WIRE_ID1, 7, 0),
                CoordinateRecord(WIRE_ID1, 8, 0),
                CoordinateRecord(WIRE_ID1, 8, 1),
                CoordinateRecord(WIRE_ID1, 8, 2),
                CoordinateRecord(WIRE_ID1, 8, 3),
                CoordinateRecord(WIRE_ID1, 8, 4),
                CoordinateRecord(WIRE_ID1, 8, 5),
                CoordinateRecord(WIRE_ID1, 7, 5),
                CoordinateRecord(WIRE_ID1, 6, 5),
                CoordinateRecord(WIRE_ID1, 5, 5),
                CoordinateRecord(WIRE_ID1, 4, 5),
                CoordinateRecord(WIRE_ID1, 3, 5),
                CoordinateRecord(WIRE_ID1, 3, 4),
                CoordinateRecord(WIRE_ID1, 3, 3),
                CoordinateRecord(WIRE_ID1, 3, 2)
        )
    }

}