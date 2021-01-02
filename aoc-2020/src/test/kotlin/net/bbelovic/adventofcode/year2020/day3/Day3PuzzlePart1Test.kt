package net.bbelovic.adventofcode.year2020.day3

import net.bbelovic.adventofcode.InputReader
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

const val PART1_EXPECTED_RESULT = 195L

class Day3PuzzlePart1Test {
    @Test
    fun `should count trees - example data`() {
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
        val treeCount = Day3PuzzlePart1(listOf(Pair(3, 1))).solve(exampleInput)
        assertThat(treeCount).isEqualTo(7L)
    }

    @Test
    fun `should count trees`() {
        val input = InputReader().readAllLines("input3.txt")
        val actualTreeCount = Day3PuzzlePart1(listOf(Pair(3, 1))).solve(input)
        assertThat(actualTreeCount).isEqualTo(PART1_EXPECTED_RESULT)
    }
}