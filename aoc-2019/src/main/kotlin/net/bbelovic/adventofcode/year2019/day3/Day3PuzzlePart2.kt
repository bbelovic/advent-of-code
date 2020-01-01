package net.bbelovic.adventofcode.year2019.day3 

class Day3PuzzlePart2(val space: Space) : AbstractDay3Puzzle(space) {
    override fun solve(input: List<List<String>>): Int {
        val intersections = findIntersections(input)
        var result = Int.MAX_VALUE
        for (intersection in intersections) {
            val sum = space.move(input[0], intersection) + space.move(input[1], intersection)
            if (sum < result) result = sum
        }
        return result
    }
}