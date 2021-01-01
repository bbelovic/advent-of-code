package net.bbelovic.adventofcode.year2020.day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

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
        var treeCount = 0
        var idx = exampleInput[0].indexOf('.')
        for (line in exampleInput) {
            var copiedLine = line
            if (idx > line.length) {
                val mult = idx / line.length
                copiedLine = line.repeat(mult + 1)
            }
            if (copiedLine[idx] == '#') {
                ++treeCount
            }
            idx += 3
        }
        assertThat(treeCount).isEqualTo(7)
    }
}