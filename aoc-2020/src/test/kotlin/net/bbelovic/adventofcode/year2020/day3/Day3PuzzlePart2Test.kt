package net.bbelovic.adventofcode.year2020.day3

import net.bbelovic.adventofcode.InputReader
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

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
        val actualResult = Day3PuzzlePart2().solve(exampleInput)
        assertThat(actualResult).isEqualTo(336)
    }

    @Test
    fun `should multiply number of tree encountered using different slopes`() {
        val input = InputReader().readAllLines("input3.txt")
        val actualResult = Day3PuzzlePart2().solve(input)
        assertThat(actualResult).isEqualTo(3772314000)
    }
}