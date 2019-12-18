package net.bbelovic.adventofcode.year2018.day4

import kotlin.streams.toList

class SameMinuteGuardAsleepGroupingSelector : GuardAsleepSelector {
    override fun process(records: List<GuardRecord>): Int {
        val (id, pair) = records.asSequence()
                .groupingBy { record -> record.id }
                .aggregate { _: Int, accumulator: MutableList<Int>?, el: GuardRecord, first: Boolean ->
                    val boxedMinutesStream = el.minutes.stream().boxed().toList()
                    if (first) {
                        val list = mutableListOf<Int>()
                        list.addAll(boxedMinutesStream)
                        list
                    } else {
                        accumulator!!.addAll(boxedMinutesStream)
                        accumulator
                    }
                }
                .mapValues { entry -> entry.value!!.groupingBy { minutesAsleep -> minutesAsleep }.eachCount() }
                .mapValues { entry -> entry.value.entries.map { e -> e.toPair() } }
                .mapValues { entry -> entry.value.asSequence().maxBy { pair -> pair.second } ?: Pair(0, 0)}
                .entries.asSequence().maxBy { entry -> entry.value.second }!!
        return id * pair.first
}
}