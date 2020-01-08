package net.bbelovic.adventofcode.year2019.day4

import net.bbelovic.adventofcode.Puzzle

class Day4PuzzlePart2 : Puzzle<Int, Int> {
    override fun solve(input: Int): Int {
        return if (checkNumber(input)) 1 else 0
    }

    private fun checkNumber(input: Int): Boolean {
        var inputCopy = input
        var init = 10
        var act: Int
        var descending = true
        var hasDouble = false
        do {
            act = inputCopy % 10
            descending = descending && (act <= init)
            if (act == init ) {
                if (!hasDouble) {
                    hasDouble = true
                } else {
                    hasDouble = false
                    break
                }
            }
            inputCopy /= 10
            init = act
        } while (inputCopy != 0)
        return hasDouble && descending
    }

}
