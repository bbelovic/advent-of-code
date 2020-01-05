package net.bbelovic.adventofcode.year2019.day3

import kotlin.math.abs

class Day3PuzzlePart1(private val space: Space): AbstractDay3Puzzle(space) {

    override fun puzzleSpecific(wire1Coordinates: MutableCollection<Coordinates>, wire2Coordinates: MutableCollection<Coordinates>): Int {
        val wire1set = wire1Coordinates.toSet()
        val intersections = wire1set intersect wire2Coordinates.toSet()
        return intersections
                .asSequence()
                .map { coordinateRecord -> computeDistance(coordinateRecord) }
                .min() ?: Int.MIN_VALUE
    }

    private fun computeDistance(coordinate: Coordinates): Int {
        return abs(space.startX - coordinate.x) + abs(space.startY - coordinate.y)
    }
}
