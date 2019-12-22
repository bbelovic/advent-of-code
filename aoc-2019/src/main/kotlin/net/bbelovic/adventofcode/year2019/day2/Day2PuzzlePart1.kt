package net.bbelovic.adventofcode.year2019.day2

private const val ADDITION_OPCODE = 1
private const val MULTIPLICATION_OPCODE = 2
private const val HALT_OPCODE = 99

class Day2PuzzlePart1 {
    fun solve(input: MutableList<Int>): String {
        var pos = 0
        var instructions = 0
        do {
            pos += instructions
            instructions = when (input[pos]) {
                ADDITION_OPCODE -> {
                    processOpCode(pos, input) {first: Int, second: Int -> first + second}
                }
                MULTIPLICATION_OPCODE -> {
                    processOpCode(pos, input) {first: Int, second: Int -> first * second}
                }
                HALT_OPCODE -> 0
                else -> throw IllegalArgumentException("Unsupported opcode: [${input[pos]}]")
            }
        } while (instructions > 0)
        return input.joinToString(separator = ",")
    }

    private fun processOpCode(pos: Int, input: MutableList<Int>, operation: (Int, Int) -> Int): Int {
        val firstParamPos = input[pos + 1]
        val secondParamPos = input[pos + 2]
        val resultPosition = input[pos + 3]
        input[resultPosition] = operation(input[firstParamPos], input[secondParamPos])
        return 4
    }
}
