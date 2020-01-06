package net.bbelovic.adventofcode.year2019.day4

import net.bbelovic.adventofcode.Puzzle

class Day4PuzzlePart1 : Puzzle<String, Int>{
    override fun solve(input: String): Int {
        return if (checkNumber(input.toInt())) 1 else 0
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
            if (!hasDouble) {
                hasDouble = (act == init)
            }
            inputCopy /= 10
            init = act
        } while (inputCopy != 0)
//        println("$hasDouble - $descending")
        return hasDouble && descending
    }

}
