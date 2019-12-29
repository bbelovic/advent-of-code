package net.bbelovic.adventofcode.year2019.day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SpaceTest {
    @Test
    fun `should detect correct number of crossings`() {
        val space = Space()
        val wire1Coordinates = space.move(listOf("R8", "U5", "L5", "D3"))
        val wire2coordinates = space.move(listOf("U7", "R6", "D4", "L4"))

        val mutableSet = wire1Coordinates.toMutableSet()
        mutableSet.retainAll(wire2coordinates)
        assertThat(mutableSet)
                .isEqualTo(mutableSetOf(CoordinateRecord(6, 5), CoordinateRecord(3, 3)))

    }

    @Test
    fun testRegex() {
        val regex = """([R,L,D,U])([0-9]+)"""
        val (direction, steps) = regex.toRegex().matchEntire("D780")!!.destructured
        assertThat(direction).isEqualTo("D")
        assertThat(steps).isEqualTo("780")
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `should move in given direction given number of steps`(input: List<String>, expectedSize: Int) {
        val space = Space()
        val coordinates = space.move(input)
        assertThat(coordinates.size).isEqualTo(expectedSize)
    }

    companion object {
        @JvmStatic
        fun testData() = listOf(
                Arguments { arrayOf(listOf("R8", "U5", "L5", "D3"), 21) },
                Arguments { arrayOf(listOf("R75"), 75) }
        )
    }

    private fun expectedCoordinateRecords(): MutableList<CoordinateRecord> {
        return mutableListOf(CoordinateRecord(1, 0),
                CoordinateRecord(2, 0),
                CoordinateRecord(3, 0),
                CoordinateRecord(4, 0),
                CoordinateRecord(5, 0),
                CoordinateRecord(6, 0),
                CoordinateRecord(7, 0),
                CoordinateRecord(8, 0),
                CoordinateRecord(8, 1),
                CoordinateRecord(8, 2),
                CoordinateRecord(8, 3),
                CoordinateRecord(8, 4),
                CoordinateRecord(8, 5),
                CoordinateRecord(7, 5),
                CoordinateRecord(6, 5),
                CoordinateRecord(5, 5),
                CoordinateRecord(4, 5),
                CoordinateRecord(3, 5),
                CoordinateRecord(3, 4),
                CoordinateRecord(3, 3),
                CoordinateRecord(3, 2)
        )
    }

}