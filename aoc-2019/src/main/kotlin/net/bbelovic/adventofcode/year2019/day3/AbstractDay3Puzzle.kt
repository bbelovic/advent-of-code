package net.bbelovic.adventofcode.year2019.day3

import net.bbelovic.adventofcode.Puzzle

abstract class AbstractDay3Puzzle(private val space: Space) : Puzzle<List<List<String>>, Int> {
    override fun solve(input: List<List<String>>): Int {
        val wire1Coordinates = space.move(input[0])
        val wire2coordinates = space.move(input[1])
        return puzzleSpecific(wire1Coordinates, wire2coordinates)
    }

    protected abstract fun puzzleSpecific(wire1Coordinates: MutableCollection<Coordinates>,
                                          wire2Coordinates: MutableCollection<Coordinates>): Int

    protected fun findIntersections(wire1Coordinates: MutableCollection<Coordinates>, wire2Coordinates: MutableCollection<Coordinates>): Set<Coordinates> {
        val wire1set = wire1Coordinates.toSet()
        return wire1set intersect wire2Coordinates.toSet()
    }

}