package net.bbelovic.adventofcode.year2018.day4

import java.util.*

class SameMinuteGuardAsleepSelector : GuardAsleepSelector {
    override fun process(records: List<GuardRecord>): Int {
        val groupBy = records.groupBy { it.id }
        println(groupBy)
        val groupingBy = records.groupingBy { it.id }
        groupingBy.reduce { key, accumulator, element -> accumulator.minutes.and(element.minutes) }
        println(groupingBy)
        return 0
    }
}