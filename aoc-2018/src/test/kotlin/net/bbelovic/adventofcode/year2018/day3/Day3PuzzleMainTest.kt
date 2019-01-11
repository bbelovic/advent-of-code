package net.bbelovic.adventofcode.year2018.day3

import net.bbelovic.adventofcode.InputReader
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.ArrayList

const val WIDTH = 1000
const val HEIGHT = 1000
const val EXPECTED_OVERLAP_PART_1 = 111326L

class Day3PuzzleMainTest {
    @Test
    fun `should solve puzzle`() {
        val fabric = Fabric(WIDTH, HEIGHT)
        val inputs = InputReader().readAllLines("input3.txt")
        val actualOverlap = inputs.asSequence()
                .map { it -> RectangleParser().parse(it) }
                .map { it -> fabric.makeClaim(it) }
                .sum()

        assertEquals(EXPECTED_OVERLAP_PART_1, actualOverlap)
    }

    @Test
    fun `should solve puzzle part 2`() {
        val inputs = InputReader().readAllLines("input3.txt")
        val puzzle = Day3PuzzlePart2()
        val rectangles = inputs.asSequence()
                .map { it -> RectangleParser().parse(it) }
                .toCollection(ArrayList())
        val actual = puzzle.solve(rectangles)
        print(actual)

    }
}