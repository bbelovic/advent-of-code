package net.bbelovic.adventofcode.year2019.day3

import kotlin.math.abs

class Day3PuzzlePart1(private val space: Space) {
    fun solve(input: List<List<String>>): Int {
        space.move(input[0])
        space.move(input[1])
        return space.collisions
                .asSequence()
                .map { coordinateRecord -> computeDistance(coordinateRecord) }
                .min() ?: Int.MIN_VALUE
    }

    private fun computeDistance(coordinate: CoordinateRecord): Int {
        return abs(0 - coordinate.x) + abs(0 - coordinate.y)
    }
}
