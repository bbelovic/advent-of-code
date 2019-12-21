package net.bbelovic.adventofcode.year2019.day2

class Day2PuzzlePart1 {
    fun solve(input: MutableList<String>): String {
        var pos = 0
        var res = ""
        while (res != "halt") {
            when (input[pos]) {
                // add two values, write on 3rd position, move forward
                "1" -> {
                    val first = input[pos + 1].toInt()
                    val second = input[pos + 2].toInt()
                    val resultPos = input[pos + 3].toInt()
                    input[resultPos] = (input[first].toInt() + input[second].toInt()).toString()
                    pos += 4; res = "add"
                }
                "2" -> {
                    val first = input[pos + 1].toInt()
                    val second = input[pos + 2].toInt()
                    val resultPos = input[pos + 3].toInt()
                    input[resultPos] = (input[first].toInt() * input[second].toInt()).toString()
                    pos += 4; res = "add"
                }
                "99" -> res = "halt"
                else -> res = "err"
            }
        }
        return input.joinToString(separator = ",")
    }

}
