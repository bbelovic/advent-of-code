package net.bbelovic.adventofcode.year2018.day4

import java.util.*

class SameMinuteGuardAsleepSelector : GuardAsleepSelector {
    override fun process(records: List<GuardRecord>): Int {
        val groupBy = records.groupBy { it.id }
        println(groupBy)
        val records99 = groupBy[99]!!
        val acc = records99[0].minutes
        for (i in 1 until records99.size) {
            acc.and(records99[i].minutes)
        }

        println(acc)

        val groupingBy = records.groupingBy { it.id }
//        groupingBy.reduce { key, accumulator, element -> accumulator.minutes.and(element.minutes) }
        println(groupingBy)
        return 0
    }
}