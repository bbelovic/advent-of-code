package net.bbelovic.adventofcode.year2019.day3

import kotlin.math.abs

class Day3PuzzlePart1(private val space: Space) {
    fun solve(input: List<List<String>>): Int {
        val wire1Coordinates = space.move(input[0])
        val wire2coordinates = space.move(input[1])

        val mutableSet = wire1Coordinates.toMutableSet()
        mutableSet.retainAll(wire2coordinates)
        return mutableSet
                .asSequence()
                .map { coordinateRecord -> computeDistance(coordinateRecord) }
                .min() ?: Int.MIN_VALUE
    }

    private fun computeDistance(coordinate: Coordinates): Int {
        return abs(0 - coordinate.x) + abs(0 - coordinate.y)
    }
}
