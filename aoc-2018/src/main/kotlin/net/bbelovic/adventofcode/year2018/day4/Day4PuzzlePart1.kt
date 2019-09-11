package net.bbelovic.adventofcode.year2018.day4

import net.bbelovic.adventofcode.Puzzle
import java.nio.file.Files

class Day4PuzzlePart1 : Puzzle<List<String>, Int> {
    override fun solve(input: List<String>): Int {

        val tempFile = Files.createTempFile("puzzle4-sorted-", ".txt")
        val writer = Files.newBufferedWriter(tempFile)

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