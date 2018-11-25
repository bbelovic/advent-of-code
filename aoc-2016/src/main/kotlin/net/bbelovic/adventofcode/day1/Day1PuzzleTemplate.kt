package net.bbelovic.adventofcode.day1

import net.bbelovic.adventofcode.Puzzle
import kotlin.math.abs

abstract class Day1PuzzleTemplate : Puzzle<String, Long>{
    override fun solve(input: String): Long {
        val list = loadInstruction(input)
        val point = processInstructions(list)
        return distance(point)
    }

    open fun loadInstruction(input: String): List<String> {
        return input.split(", ")
    }

    abstract fun processInstructions(list: List<String>): Point

    open fun distance(point: Point): Long {
        return abs(0L - point.x) + abs(0L - point.y)
    }
}