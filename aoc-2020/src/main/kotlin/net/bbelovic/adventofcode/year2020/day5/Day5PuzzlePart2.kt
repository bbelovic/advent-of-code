package net.bbelovic.adventofcode.year2020.day5

class Day5PuzzlePart2 : AbstractDay5Puzzle() {
    override fun solve(input: List<String>): Long {
        val seatIds = input.asSequence()
            .map { each -> computeRowAndCols(each) }
            .toCollection(mutableListOf())
        val max = seatIds.maxOrNull() ?: -1
        val min = seatIds.minOrNull() ?: -1
        var result = 0L
        for (x in min..max) {
            if (!seatIds.contains(x)) {
                result = x
                break
            }
        }
        return result
    }

}
