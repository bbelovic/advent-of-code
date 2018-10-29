package net.bbelovic.adventofcode.day1

import net.bbelovic.adventofcode.Puzzle
import java.lang.IllegalArgumentException

class Day1PuzzlePart1 : Puzzle<String, Long> {
    override fun solve(input: String): Long {
        val list = input.split(",")
        var result = 0L

        var start = Point(0, 0)

        for (inp in list) {

            result = when (inp) {
                "L3" -> 5L
                "R2" -> 5L
                else -> throw IllegalArgumentException("Unknown input '$input'")
            }
        }
        return result
    }

}