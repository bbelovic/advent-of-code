package net.bbelovic.adventofcode.year2019.day3

import net.bbelovic.adventofcode.Puzzle

abstract class AbstractDay3Puzzle(private val space: Space) : Puzzle<List<List<String>>, Int> {
    protected fun findIntersections(input: List<List<String>>): MutableSet<Coordinates> {
        val wire1Coordinates = space.move(input[0])
        val wire2coordinates = space.move(input[1])
        val mutableSet = wire1Coordinates.toMutableSet()
        mutableSet.retainAll(wire2coordinates)
        return mutableSet
    }
}