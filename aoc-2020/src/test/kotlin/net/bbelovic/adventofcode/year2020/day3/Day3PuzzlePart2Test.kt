package net.bbelovic.adventofcode.year2020.day3

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
}