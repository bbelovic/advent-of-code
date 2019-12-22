package net.bbelovic.adventofcode.year2019.day2

class Day2PuzzlePart1 {
    fun solve(input: MutableList<String>): String {
        var pos = 0
        var res = ""
        while (res != "halt") {
            when (input[pos]) {
                "1" -> {
                    pos = processOpCode(pos, input) {first: Int, second: Int -> first + second}
                    res = "add"
                }
                "2" -> {
                    pos = processOpCode(pos, input) {first: Int, second: Int -> first * second}
                    res = "add"
                }
                "99" -> res = "halt"
                else -> res = "err"
            }
        }
        return input.joinToString(separator = ",")
    }

    private fun processOpCode(pos: Int, input: MutableList<String>, operation: (Int, Int) -> Int): Int {
        val first = input[pos + 1].toInt()
        val second = input[pos + 2].toInt()
        val resultPos = input[pos + 3].toInt()
        input[resultPos] = ( operation(input[first].toInt(), input[second].toInt()) ).toString()
        return pos + 4
    }
}
