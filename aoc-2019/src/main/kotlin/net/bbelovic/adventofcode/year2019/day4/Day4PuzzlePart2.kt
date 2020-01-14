package net.bbelovic.adventofcode.year2019.day4

import net.bbelovic.adventofcode.Puzzle

class Day4PuzzlePart2 : Puzzle<Int, Int> {
    private val requiredDigitCount = 2
    private val decimalDivisor = 10

    override fun solve(input: Int): Int {
        return if (checkNumber(input)) 1 else 0
    }

    private fun checkNumber(input: Int): Boolean {
        var inputCopy = input
        var candidate = 10
        var count = 0
        var act: Int
        var descending = true
        var hasDouble = false
        do {
            act = inputCopy % decimalDivisor
            descending = descending && (act <= candidate)
            if (!hasDouble && (act != candidate)) {
                if (count == requiredDigitCount) {
                    hasDouble = true
                }
                count = 1
            } else {
                count += 1
            }
            candidate = act
            inputCopy /= decimalDivisor
        } while (inputCopy != 0)
        return (hasDouble || count == requiredDigitCount) && descending
    }

}
