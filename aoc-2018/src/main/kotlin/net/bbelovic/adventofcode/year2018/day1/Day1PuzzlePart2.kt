package net.bbelovic.adventofcode.year2018.day1

import net.bbelovic.adventofcode.Puzzle

class Day1PuzzlePart2 : Puzzle<String, Long> {
    override fun solve(input: String): Long {
        var notFound = true
        var startingFrequency = 0L
        val knownFrequencies = mutableSetOf(startingFrequency)
        val frequencyList = input.splitToSequence(", ").map { it -> it.toLong() }.toList()
        var result = Long.MIN_VALUE
        while (notFound) {
            for (frequency in frequencyList) {
                val candidate = startingFrequency + frequency
                if (candidate in knownFrequencies) {
                    result = candidate
                    notFound = false
                    break
                } else {
                    knownFrequencies.add(candidate)
                }
                startingFrequency = candidate
            }
        }
        return result
    }
}