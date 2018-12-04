package net.bbelovic.adventofcode.year2018.day2

import net.bbelovic.adventofcode.Puzzle
import java.lang.IllegalStateException

class Day2PuzzlePart1 : Puzzle<List<String>, Long> {
    override fun solve(input: List<String>): Long {

        val checksum = BoxChecksum(0, 0)
        return input.asSequence()
                .map { it -> listOfOccurrences(it) }
                .map { it -> asBoxDescription(it) }
                .fold(checksum) { acc, description ->
                    acc.couples += description.couple
                    acc.triplets += description.triplet
                    acc
                }.computeChecksum().toLong()

    }

    private fun listOfOccurrences(s: String) = s.asSequence()
            .groupingBy {  it -> it}
            .eachCount()
            .map { it -> it.value }
            .filter { it -> it in 2..3 }
            .distinct()
            .toList()

    private fun asBoxDescription(ocurrences: List<Int>) = when (ocurrences.size) {
         0 -> BoxDescription(0, 0)
         1 -> processSingleOccurrence(ocurrences)
         2 -> BoxDescription(1, 1)
         else -> throw IllegalStateException("Unexpected size of character occurrences list: [${ocurrences.size}]")
    }

    private fun processSingleOccurrence(occurrences: List<Int>) = when (occurrences[0]) {
        2 -> BoxDescription(1, 0)
        3 -> BoxDescription(0, 1)
        else -> throw IllegalStateException("Unexpected character occurrence count: [${occurrences[0]}]")
    }
}

private data class BoxDescription(val couple: Int, val triplet: Int)
private data class BoxChecksum(var couples: Int, var triplets: Int) {
    fun computeChecksum() = couples * triplets
}