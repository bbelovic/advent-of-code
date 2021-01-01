package net.bbelovic.adventofcode.year2020.day2

import net.bbelovic.adventofcode.Puzzle

class Day2PuzzlePart2 : Puzzle<List<String>, Int> {
    override fun solve(input: List<String>): Int {
        return input.asSequence()
            .filter { each -> valid(each) }
            .count()
    }

    private fun valid(line: String): Boolean {
        val regex = """(\d+)-(\d+) (\w): (\w+)""".toRegex()
        val (min, max, what, input) = regex.matchEntire(line)!!.destructured
        val count = sequenceOf(input[min.toInt() - 1], input[max.toInt() - 1])
            .filter { each -> each.toString() == what }
            .count()
        return count == 1
    }
}
