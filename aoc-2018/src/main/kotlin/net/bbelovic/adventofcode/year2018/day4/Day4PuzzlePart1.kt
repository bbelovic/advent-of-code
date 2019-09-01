package net.bbelovic.adventofcode.year2018.day4

import net.bbelovic.adventofcode.InputReader
import net.bbelovic.adventofcode.Puzzle
import java.nio.file.Files
import java.nio.file.Paths

class Day4PuzzlePart1 : Puzzle<List<String>, Int> {
    override fun solve(input: List<String>): Int {

        val writer = Files.newBufferedWriter(Paths.get("sorted-input4.txt"))

        writer.use { w ->
                    input.asSequence()
                    .sortedWith(InputLineComparator)
                    .forEach {
                        w.write(it)
                        w.newLine()
                    }
        }
        return 0
    }
}