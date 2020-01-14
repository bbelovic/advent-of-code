package net.bbelovic.adventofcode.year2019.day4

import net.bbelovic.adventofcode.Puzzle

class Day4PuzzlePart1 : Puzzle<Int, Int>{
    override fun solve(input: Int): Int {
        return if (checkNumber(input)) 1 else 0
    }

    private fun checkNumber(input: Int): Boolean {
        var inputCopy = input
        var candidate = 10
        var act: Int
        var descending = true
        var hasDouble = false
        do {
            act = inputCopy % 10
            descending = descending && (act <= candidate)
            if (!hasDouble) {
                hasDouble = (act == candidate)
            }
            inputCopy /= 10
            candidate = act
        } while (inputCopy != 0)
        return hasDouble && descending
    }

}
