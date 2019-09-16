package net.bbelovic.adventofcode.year2018.day4

import net.bbelovic.adventofcode.Puzzle
import java.io.File
import java.nio.file.Files

class Day4PuzzlePart1(private val selector: GuardAsleepSelector) : Puzzle<List<String>, Int> {
    override fun solve(input: List<String>): Int {

        val tempFile = File.createTempFile("puzzle4-sorted-", ".txt").toPath()
        val records = try {
            val writer = Files.newBufferedWriter(tempFile)
            writer.use { w ->
                input.asSequence()
                        .sortedWith(InputLineComparator)
                        .forEach {
                            w.write(it)
                            w.newLine()
                        }
            }
            Day4PuzzlePart1InputParser.parse(Files.newBufferedReader(tempFile))
        } finally {
            Files.deleteIfExists(tempFile)
        }
        return selector.process(records)
    }
}