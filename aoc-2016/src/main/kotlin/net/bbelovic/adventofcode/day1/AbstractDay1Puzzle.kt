package net.bbelovic.adventofcode.day1

import net.bbelovic.adventofcode.Puzzle
import kotlin.math.abs

abstract class AbstractDay1Puzzle : Puzzle<String, Long>{
    override fun solve(input: String): Long {
        val list = loadInstruction(input)
        val position = processInstructions(list)
        return distance(position)
    }

    open fun loadInstruction(input: String): List<String> {
        return input.split(", ")
    }

    abstract fun processInstructions(list: List<String>): Position

    open fun distance(position: Position): Long {
        return abs(0L - position.value.x) + abs(0L - position.value.y)
    }
}