package net.bbelovic.adventofcode.year2018.day1

import net.bbelovic.adventofcode.Puzzle

class Day1PuzzlePart2 : Puzzle<String, Long> {
    override fun solve(input: String): Long {
      val notFound = true
      val frequencies = mutableSetOf<Long>()
      var result = 0L
      while (notFound) {
          var freq = 0L
          if (frequencies.contains(freq)) {
              result = freq
              break
          } else {
              frequencies.add(freq)
              input.splitToSequence(", ")
                      .map { it -> it.toLong() }
                      .forEach {
                          if (frequencies.contains(it)) {
                              result = it
                              return@forEach
                          }
                      }
          }

      }

      return result
    }
}