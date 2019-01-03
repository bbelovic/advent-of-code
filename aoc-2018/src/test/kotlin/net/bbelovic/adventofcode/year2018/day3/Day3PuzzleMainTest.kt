package net.bbelovic.adventofcode.year2018.day3

import net.bbelovic.adventofcode.InputReader
import org.junit.jupiter.api.Test

class Day3PuzzleMainTest {
    @Test
    fun `should solve puzzle`() {
        val inputs = InputReader().readAllLines("input3.txt")
        val rectangles = inputs.asSequence()
                .map { s: String? -> RectangleParser().parse(s!!) }
                .toList()


        var sum = 0L
        for ((idx, rectangle) in rectangles.withIndex()) {
            for (i in (idx + 1)..rectangles.size-1) {
                sum += rectangle.intersect(rectangles[i])
            }
        }
        print(sum)
    }
}