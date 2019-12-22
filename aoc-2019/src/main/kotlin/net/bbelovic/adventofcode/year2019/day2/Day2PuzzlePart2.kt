package net.bbelovic.adventofcode.year2019.day2

private const val EXPECTED_OUTPUT = "19690720"
private const val RESULT_NOT_FOUND = 0L
private const val RESULT_MULTIPLIER = 100L

const val NOUN_POSITION = 1
const val VERB_POSITION = 2

class Day2PuzzlePart2 {
    private val inputValueRange = 0..99

    fun solve(input: List<Int>): Long {
        val part1 = Day2PuzzlePart1()
        for (noun in inputValueRange) {
            for (verb in inputValueRange) {
                val mutableList = input.toMutableList()
                mutableList[NOUN_POSITION] = noun
                mutableList[VERB_POSITION] = verb
                val result = part1.solve(mutableList)
                if (result.startsWith(EXPECTED_OUTPUT)) {
                    return RESULT_MULTIPLIER * noun + verb
                }
            }
        }
        return RESULT_NOT_FOUND
    }
}
