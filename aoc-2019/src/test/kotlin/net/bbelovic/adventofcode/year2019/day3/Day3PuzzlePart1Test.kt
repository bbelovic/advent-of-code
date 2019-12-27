package net.bbelovic.adventofcode.year2019.day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day3PuzzlePart1Test {
    @ParameterizedTest
    @MethodSource("testData")
    fun `should compute Manhattan distance from central port to closest intersection`(first: List<String>,
                                                                                      second: List<String>,
                                                                                      expectedDistance: Int) {
        val puzzle = Day3PuzzlePart1(Space())
        val actualDistance = puzzle.solve(listOf(first, second))
        assertThat(actualDistance).isEqualTo(expectedDistance)
    }

    companion object {
        @JvmStatic
        fun testData() = listOf(
                Arguments { arrayOf(listOf("R8", "U5", "L5", "D3"), listOf("U7", "R6", "D4", "L4"), 6) },
                Arguments { arrayOf(listOf("R98","U47","R26","D63","R33","U87","L62","D20","R33","U53","R51"),
                        listOf("U98","R91","D20","R16","D67","R40","U7","R15","U6","R7"), 135) },
                Arguments { arrayOf(listOf("R75","D30","R83","U83","L12","D49","R71","U7","L72"),
                        listOf("U62","R66","U55", "R34","D71","R55","D58","R83"), 159) }
        )
    }
}