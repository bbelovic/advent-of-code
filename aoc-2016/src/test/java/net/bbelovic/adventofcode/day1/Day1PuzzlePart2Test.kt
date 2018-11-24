package net.bbelovic.adventofcode.day1

import net.bbelovic.adventofcode.InputReader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day1PuzzlePart2Test {
    @Test
    fun test_main() {
        val inputString = InputReader().readFileIntoString("input1.txt")
        val puzzle = Day1PuzzlePart2()
        val solve = puzzle.solve(inputString)
        Assertions.assertEquals(166, solve)
    }


    @ParameterizedTest
    @MethodSource("testData")
    fun should_compute_distance_to_first_location_visited_twice(input: String,
                                                                expectedResult: Long) {
        val puzzle = Day1PuzzlePart2()
        val actualResult = puzzle.solve(input)
        Assertions.assertEquals(expectedResult, actualResult)

    }

    companion object {
        @JvmStatic
        fun testData() = listOf<Arguments>(Arguments.of("R8, R4, R4, R8", 4L))
    }

}