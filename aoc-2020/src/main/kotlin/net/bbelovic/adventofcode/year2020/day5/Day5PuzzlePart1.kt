package net.bbelovic.adventofcode.year2020.day5

import java.util.Comparator

class Day5PuzzlePart1 : AbstractDay5Puzzle(){

    override fun solve(input: List<String>): Long {
        return input.asSequence().map { each -> computeRowAndCols(each) }
            .maxWithOrNull(Comparator.naturalOrder()) ?: -1
    }

}
