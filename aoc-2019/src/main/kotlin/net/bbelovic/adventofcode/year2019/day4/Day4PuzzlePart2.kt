package net.bbelovic.adventofcode.year2019.day4

import net.bbelovic.adventofcode.Puzzle

class Day4PuzzlePart2 : Puzzle<Int, Int> {
    override fun solve(input: Int): Int {
        return if (checkNumber(input)) 1 else 0
    }

    private fun checkNumber(input: Int): Boolean {
        var inputCopy = input
        var candidate = -1
        var count = 0
        var act: Int
        var descending = true
        var hasDouble = false
        do {
            act = inputCopy % 10
            if (act != candidate ) {
                if (count == 2) {
                    hasDouble = true
                }
                candidate = act
                count = 1
            } else {
                candidate = act
                count += 1
            }
            descending = descending && (act <= candidate)
            inputCopy /= 10
        } while (inputCopy != 0)
        return (hasDouble || count == 2) && descending
    }

}
