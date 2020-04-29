package net.bbelovic.adventofcode.year2019.day3

import net.bbelovic.adventofcode.InputReader
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

private const val DAY3_PART1_EXPECTED_RESULT = 258

class Day3PuzzlePart1Test {

    @Test
    fun `should compute Manhattan distance from central port for puzzle part1 input`() {
        val input = InputReader().readAllLines("input3.txt")
        val toList = input.asSequence().map { each -> each.split(",") }.toList()
        val actualDistance = Day3PuzzlePart1(Space()).solve(toList)
        assertThat(actualDistance).isEqualTo(DAY3_PART1_EXPECTED_RESULT)
    }

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
        fun testData() = testDataDsl {
            testArguments (listOf("R8", "U5", "L5", "D3"), listOf("U7", "R6", "D4", "L4"), 6)
            testArguments (listOf("R98","U47","R26","D63","R33","U87","L62","D20","R33","U53","R51"),
                        listOf("U98","R91","D20","R16","D67","R40","U7","R15","U6","R7"), 135)

            testArguments (listOf("R75","D30","R83","U83","L12","D49","R71","U7","L72"),
                        listOf("U62","R66","U55", "R34","D71","R55","D58","R83"), 159)

        }
    }
}