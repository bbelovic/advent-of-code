package net.bbelovic.adventofcode.year2019.day3

import net.bbelovic.adventofcode.Puzzle
import kotlin.math.abs

class Day3PuzzlePart1(private val space: Space): Puzzle<List<List<String>>, Int> {
    override fun solve(input: List<List<String>>): Int {
        val wire1Coordinates = space.move(input[0])
        val wire2coordinates = space.move(input[1])

        val intersections = findIntersections(wire1Coordinates, wire2coordinates)
        return closestIntersection(intersections)
    }

    private fun closestIntersection(intersections: MutableSet<Coordinates>): Int {
        return intersections
                .asSequence()
                .map { coordinateRecord -> computeDistance(coordinateRecord) }
                .min() ?: Int.MIN_VALUE
    }

    private fun findIntersections(wire1Coordinates: MutableSet<Coordinates>, wire2coordinates: MutableSet<Coordinates>): MutableSet<Coordinates> {
        val mutableSet = wire1Coordinates.toMutableSet()
        mutableSet.retainAll(wire2coordinates)
        return mutableSet
    }

    private fun computeDistance(coordinate: Coordinates): Int {
        return abs(space.startX - coordinate.x) + abs(space.startY - coordinate.y)
    }
}
