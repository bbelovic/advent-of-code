package net.bbelovic.adventofcode.year2020.day2

import net.bbelovic.adventofcode.Puzzle

class Day2PuzzlePart1 : Puzzle<List<String>, Int> {
    override fun solve(input: List<String>): Int {
        return input.asSequence()
            .filter { each -> valid(each) }
            .count()
    }

    private fun valid(line: String): Boolean {
        val regex = """(\d+)-(\d+) (\w): (\w+)""".toRegex()
        val (min, max, what, input) = regex.matchEntire(line)!!.destructured
        val count = input.asSequence()
            .filter { each -> each.toString() == what }
            .count()
        return count in min.toInt() .. max.toInt()
    }
}