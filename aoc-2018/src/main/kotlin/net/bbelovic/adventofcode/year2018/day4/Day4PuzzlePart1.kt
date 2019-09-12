package net.bbelovic.adventofcode.year2018.day4

import net.bbelovic.adventofcode.Puzzle
import java.nio.file.Files
import java.util.stream.Collectors

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
        val records = Day4PuzzlePart1InputParser.parse(Files.newBufferedReader(tempFile))
        val recordIdExtractor: (GuardRecord)->Int = GuardRecord::id
        val minutesSlept: (GuardRecord) -> Int = GuardRecord::minutesSlept
        val downStream = Collectors.summingInt(minutesSlept)
        val m: Map<Int, Int> = records.stream()
                .collect(Collectors.groupingBy(GuardRecord::id, downStream))
        println(m)
        return 0
    }
}