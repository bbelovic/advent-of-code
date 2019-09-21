package net.bbelovic.adventofcode.year2018.day4

class SameMinuteGuardAsleepSelector : GuardAsleepSelector {
    override fun process(records: List<GuardRecord>): Int {
        val groupBy = records.groupBy { it.id }
        println(groupBy)
        val groupingBy = records.groupingBy { it.id }
        println(groupingBy)
        return 0
    }
}