package net.bbelovic.adventofcode.day1

import net.bbelovic.adventofcode.InputReader
import org.junit.jupiter.api.Test

class Day1PuzzleMainTest {
    @Test
    fun should_solve_puzzle() {
        val inputString = InputReader().readFileIntoString("input1.txt")
        val puzzle = Day1PuzzlePart1()
        val actualResult = puzzle.solve(inputString)
        println(actualResult)
    }
}