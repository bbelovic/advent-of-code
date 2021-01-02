package net.bbelovic.adventofcode.year2020.day3

class Day3PuzzlePart1 {
    fun solve(input: List<String>): Int {
        val tobogganRacer = TobogganRacer(listOf(Pair(3, 1)))
        return tobogganRacer.solve(input)

//        var treeCount = 0
//        var idx = input[0].indexOf('.')
//
//        for (i in input.indices step 1) {
//            val inputLine = repeatIfNeeded(idx, input[i])
//            if (inputLine[idx] == '#') {
//                ++treeCount
//            }
//            idx += 3
//
//        }
//        return treeCount
    }

    private fun repeatIfNeeded(idx: Int, line: String): String {
        if (idx > line.length) {
            return line.repeat((idx / line.length) + 1)
        }
        return line
    }
}