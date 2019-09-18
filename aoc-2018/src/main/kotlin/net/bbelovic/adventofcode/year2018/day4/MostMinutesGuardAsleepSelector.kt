package net.bbelovic.adventofcode.year2018.day4

import java.util.stream.Collectors
import kotlin.streams.asSequence

class MostMinutesGuardAsleepSelector : GuardAsleepSelector {
    override fun process(records: List<GuardRecord>): Int {
        val downStream = Collectors.summingInt { g: GuardRecord -> g.minutesSlept() }
        val max = records.stream()
                .collect(Collectors.groupingBy({ g: GuardRecord? -> g?.id }, downStream))
                .asSequence()
                .maxBy { entry -> entry.value }
        val record = records
                .asSequence()
                .filter { guardRecord -> guardRecord.id == max?.key }
                .flatMap { guardRecord -> guardRecord.minutes.stream().asSequence() ?: emptySequence() }
                .groupingBy { it }.eachCount()
                .asSequence().maxBy { entry -> entry.value }

        val id = max?.key ?:0
        val minute = record?.key ?: 0
        return minute * id
    }
}