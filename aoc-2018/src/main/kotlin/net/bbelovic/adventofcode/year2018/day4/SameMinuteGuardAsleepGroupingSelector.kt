package net.bbelovic.adventofcode.year2018.day4

import kotlin.streams.toList

class SameMinuteGuardAsleepGroupingSelector : GuardAsleepSelector {
    override fun process(records: List<GuardRecord>): Int {
        val (id, pair) = records
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
                .mapValues { entry -> entry.value.groupingBy { minutesAsleep -> minutesAsleep }.eachCount() }
                .mapValues { entry -> entry.value.entries.map(this::convertToPair) }
                .mapValues { entry -> entry.value.maxByOrNull { pair -> pair.second } ?: Pair(0, 0)}
                .entries.maxByOrNull { entry -> entry.value.second }!!
        return id * pair.first
    }

    private fun convertToPair(mapEntry: Map.Entry<Int, Int>): Pair<Int, Int> {
        return mapEntry.toPair()
    }
}