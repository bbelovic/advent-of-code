package net.bbelovic.adventofcode.year2019.day3 

class Day3PuzzlePart2(val space: Space) : AbstractDay3Puzzle(space) {

    override fun puzzleSpecific(wire1Coordinates: MutableCollection<Coordinates>, wire2Coordinates: MutableCollection<Coordinates>): Int {
        var result = Int.MAX_VALUE
        val wire1set = wire1Coordinates.toSet()
        val intersections = wire1set intersect wire2Coordinates.toSet()
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
}