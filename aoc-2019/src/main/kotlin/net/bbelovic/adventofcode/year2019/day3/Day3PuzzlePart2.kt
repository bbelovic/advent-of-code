package net.bbelovic.adventofcode.year2019.day3 

class Day3PuzzlePart2(val space: Space) : AbstractDay3Puzzle(space) {
    override fun solve(input: List<List<String>>): Int {
        val wire1Coordinates = space.move(input[0])
        val wire2Coordinates = space.move(input[1])
        val intersections = findIntersections(wire1Coordinates, wire2Coordinates)
        var result = Int.MAX_VALUE
        for (intersection in intersections) {
            var steps1 = 0
            var steps2 = 0
            steps1 = wire1Coordinates.indexOf(intersection) + 1
            steps2 = wire2Coordinates.indexOf(intersection) + 1

            val sum = steps1 + steps2
            if (sum < result) result = sum
        }
        return result
    }

    private fun findIntersections(wire1Coordinates: MutableSet<Coordinates>, wire2Coordinates: MutableSet<Coordinates>): MutableSet<Coordinates> {
        val mutableSet = wire1Coordinates.toMutableSet()
        mutableSet.retainAll(wire2Coordinates)
        return mutableSet
    }
}