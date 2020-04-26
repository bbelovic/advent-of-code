package net.bbelovic.adventofcode.year2019.day3

import net.bbelovic.adventofcode.ArgumentsBuilder
import net.bbelovic.adventofcode.InputReader
import net.bbelovic.adventofcode.TestDataBuilder
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

private const val DAY3_PART2_EXPECTED_RESULT = 12304

internal class Day3PuzzlePart2Test {

    @Test
    fun `should compute fewest combined steps to intersection`() {
        val input = InputReader().readAllLines("input3.txt")
        val toList = input.asSequence().map { each -> each.split(",") }.toList()
        val steps = Day3PuzzlePart2(Space()).solve(toList)
        assertThat(steps).isEqualTo(DAY3_PART2_EXPECTED_RESULT)
    }
    
    @ParameterizedTest
    @MethodSource("testData2")
    fun `should compute minimal number of steps to intersection`(first: List<String>, second: List<String>,
                                                                 expectedSteps: Int) {
        val puzzle = Day3PuzzlePart2(Space())
        val actualSteps = puzzle.solve(listOf(first, second))
        assertThat(actualSteps).isEqualTo(expectedSteps)

    }

    companion object {
//        @JvmStatic
//        fun testData() = listOf(
//                Arguments { arrayOf(listOf("R8", "U5", "L5", "D3"), listOf("U7", "R6", "D4", "L4"), 30) },
//                Arguments { arrayOf(listOf("R98","U47","R26","D63","R33","U87","L62","D20","R33","U53","R51"),
//                        listOf("U98","R91","D20","R16","D67","R40","U7","R15","U6","R7"), 410) },
//                Arguments { arrayOf(listOf("R75","D30","R83","U83","L12","D49","R71","U7","L72"),
//                        listOf("U62","R66","U55", "R34","D71","R55","D58","R83"), 610) }
//        )
        @JvmStatic
        fun testData2() = TestDataBuilder()
                .withArguments(ArgumentsBuilder()
                        .withValues(listOf("R8", "U5", "L5", "D3"), listOf("R8", "U5", "L5", "D3"), 30)
                        .build()).arguments
    }

}