package net.bbelovic.adventofcode.year2020.day3

import net.bbelovic.adventofcode.InputReader
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

const val PART2_EXPECTED_RESULT = 3772314000L

class Day3PuzzlePart2Test {
    @Test
    fun `should multiply number of tree encountered using different slopes - example data`() {
        val exampleInput = listOf(
            "..##.......",
            "#...#...#..",
            ".#....#..#.",
            "..#.#...#.#",
            ".#...##..#.",
            "..#.##.....",
            ".#.#.#....#",
            ".#........#",
            "#.##...#...",
            "#...##....#",
            ".#..#...#.#"
        )
        val actualResult = Day3PuzzlePart1(listOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2)))
            .solve(exampleInput)
        assertThat(actualResult).isEqualTo(336L)
    }

    @Test
    fun `should multiply number of tree encountered using different slopes`() {
        val input = InputReader().readAllLines("input3.txt")
        val actualResult = Day3PuzzlePart1(listOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2)))
            .solve(input)
        assertThat(actualResult).isEqualTo(PART2_EXPECTED_RESULT)
    }
}