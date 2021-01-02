package net.bbelovic.adventofcode.year2020.day3

class Day3PuzzlePart2 {

    fun solve(input: List<String>): Int {
        val slopes = listOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2))
        val tobogganRacer = TobogganRacer(slopes)
        return tobogganRacer.solve(input)
    }
}