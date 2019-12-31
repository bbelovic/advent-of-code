package net.bbelovic.adventofcode.year2019.day3

import kotlin.math.abs

class Day3PuzzlePart1(private val space: Space): AbstractDay3Puzzle(space) {
    override fun solve(input: List<List<String>>): Int {
        val intersections = findIntersections(input)
        return closestIntersection(intersections)
    }

    private fun closestIntersection(intersections: MutableSet<Coordinates>): Int {
        return intersections
                .asSequence()
                .map { coordinateRecord -> computeDistance(coordinateRecord) }
                .min() ?: Int.MIN_VALUE
    }

    private fun computeDistance(coordinate: Coordinates): Int {
        return abs(space.startX - coordinate.x) + abs(space.startY - coordinate.y)
    }
}
