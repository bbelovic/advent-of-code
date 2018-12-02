package net.bbelovic.adventofcode.year2018.day1

import net.bbelovic.adventofcode.Puzzle

class Day1PuzzlePart2 : Puzzle<String, Long> {
    override fun solve(input: String): Long {
      var notFound = true
        var init = 0L




        val frequencies = mutableSetOf(init)
        val list = input.splitToSequence(", ").map { it -> it.toLong() }.toList()
        var result = Long.MIN_VALUE
        while (notFound) {
          for (f in list) {
              val newFreq = init + f
              if (newFreq in frequencies) {
                  result = newFreq
                  notFound = false
                  break
              } else {
                  frequencies.add(newFreq)
              }
              init = newFreq

          }

      }

      return result
    }
}