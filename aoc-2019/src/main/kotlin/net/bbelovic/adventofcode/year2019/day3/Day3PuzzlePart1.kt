package net.bbelovic.adventofcode.year2019.day3

import kotlin.math.abs

class Day3PuzzlePart1(private val space: Space): AbstractDay3Puzzle(space) {

    override fun puzzleSpecific(wire1Coordinates: MutableCollection<Coordinates>, wire2Coordinates: MutableCollection<Coordinates>): Int {
        val intersections = findIntersections(wire1Coordinates, wire2Coordinates)
        return intersections
                .asSequence()
                .map { coordinateRecord -> computeDistance(coordinateRecord) }
                .minOrNull() ?: Int.MIN_VALUE
    }

    private fun computeDistance(coordinate: Coordinates): Int {
        return abs(space.startX - coordinate.x) + abs(space.startY - coordinate.y)
    }
}
