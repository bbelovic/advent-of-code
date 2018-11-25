package net.bbelovic.adventofcode.day1

import net.bbelovic.adventofcode.Puzzle
import kotlin.math.abs

class Day1PuzzlePart1 : Puzzle<String, Long> {
    override fun solve(input: String): Long {
        val list = input.split(", ")
        var actualPosition = Position(Point(0, 1))
        for (inp in list) {
            actualPosition = InstructionProcessor.process(inp, actualPosition)
        }
        return distance(actualPosition.value)
    }

    private fun distance(p: Point): Long {
        return abs(0L - p.x) + abs(0L - p.y)
    }
}