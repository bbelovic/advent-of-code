package net.bbelovic.adventofcode.year2019.day3

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatNullPointerException
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
                .isEqualTo(mutableSetOf(Coordinates(6, 5), Coordinates(3, 3)))

    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `should move in given direction given number of steps`(input: List<String>, expectedSize: Int) {
        val space = Space()
        val coordinates = space.move(input)
        assertThat(coordinates.size).isEqualTo(expectedSize)
    }

    @Test
    fun `should throw exception for unsupported direction format`() {
        val space = Space()
        assertThatNullPointerException().isThrownBy {
            space.move(listOf("W1234"))
        }
    }

    companion object {
        @JvmStatic
        fun testData() = listOf(
                Arguments { arrayOf(listOf("R8", "U5", "L5", "D3"), 21) },
                Arguments { arrayOf(listOf("R75"), 75) }
        )
    }

    private fun expectedCoordinateRecords(): MutableList<Coordinates> {
        return mutableListOf(Coordinates(1, 0),
                Coordinates(2, 0),
                Coordinates(3, 0),
                Coordinates(4, 0),
                Coordinates(5, 0),
                Coordinates(6, 0),
                Coordinates(7, 0),
                Coordinates(8, 0),
                Coordinates(8, 1),
                Coordinates(8, 2),
                Coordinates(8, 3),
                Coordinates(8, 4),
                Coordinates(8, 5),
                Coordinates(7, 5),
                Coordinates(6, 5),
                Coordinates(5, 5),
                Coordinates(4, 5),
                Coordinates(3, 5),
                Coordinates(3, 4),
                Coordinates(3, 3),
                Coordinates(3, 2)
        )
    }

}