package net.bbelovic.adventofcode.year2018.day4

import net.bbelovic.adventofcode.Puzzle
import java.io.File
import java.nio.file.Files
import java.util.stream.Collectors
import kotlin.streams.asSequence

class Day4PuzzlePart1 : Puzzle<List<String>, Int> {
    override fun solve(input: List<String>): Int {

        val tempFile = File.createTempFile("puzzle4-sorted-", ".txt").toPath()
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
        val downStream = Collectors.summingInt { g: GuardRecord -> g.minutesSlept() }

        val max = records.stream()
                .collect(Collectors.groupingBy({ g: GuardRecord? -> g?.id }, downStream))
                .asSequence()
                .maxBy { entry -> entry.value }
        val record = records
                .asSequence()
                .filter { guardRecord -> guardRecord?.id == max?.key }
                .flatMap { guardRecord -> guardRecord?.minutes?.stream()?.asSequence() ?: emptySequence() }
                .groupingBy { it }.eachCount()
                .asSequence().maxBy { entry -> entry.value }

        val id = max?.key ?:0
        val minute = record?.key ?: 0
        return minute * id
    }
}