package net.bbelovic.adventofcode.year2020.day4

class Day4PuzzlePart1 : AbstractDay4Puzzle() {
    override fun processElement(line: String): String {
        return """([a-z]{3}):.*""".toRegex().matchEntire(line)!!.destructured.component1()
    }
}
