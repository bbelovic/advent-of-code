package net.bbelovic.adventofcode.year2019.day3

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatNullPointerException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SpaceTest {

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
}