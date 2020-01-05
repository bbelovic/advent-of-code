package net.bbelovic.adventofcode.year2019.day3 

class Day3PuzzlePart2(space: Space) : AbstractDay3Puzzle(space) {

    override fun puzzleSpecific(wire1Coordinates: MutableCollection<Coordinates>, wire2Coordinates: MutableCollection<Coordinates>): Int {
        var result = Int.MAX_VALUE
        val intersections = findIntersections(wire1Coordinates, wire2Coordinates)
        for (intersection in intersections) {
            val steps1 = wire1Coordinates.indexOf(intersection) + 1
            val steps2 = wire2Coordinates.indexOf(intersection) + 1

            val sum = steps1 + steps2
            if (sum < result) result = sum
        }
        return result
    }
}