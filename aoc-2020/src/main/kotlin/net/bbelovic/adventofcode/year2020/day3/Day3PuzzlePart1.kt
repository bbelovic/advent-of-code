package net.bbelovic.adventofcode.year2020.day3

class Day3PuzzlePart1 {
    fun solve(input: List<String>): Int {
        var treeCount = 0
        var idx = input[0].indexOf('.')
        for (line in input) {
            var copiedLine = line
            if (idx > line.length) {
                val mult = idx / line.length
                copiedLine = line.repeat(mult + 1)
            }
            if (copiedLine[idx] == '#') {
                ++treeCount
            }
            idx += 3
        }
        return treeCount
    }
}