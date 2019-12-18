package net.bbelovic.adventofcode.year2018.day4

import kotlin.streams.toList

class SameMinuteGuardAsleepGroupingSelector : GuardAsleepSelector {
    override fun process(records: List<GuardRecord>): Int {
        val groupingBy = records.asSequence().groupingBy { record -> record.id }


        val op = {key: Int, accumulator: MutableList<Int>?, el: GuardRecord, first: Boolean ->
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

        val round1 = groupingBy.aggregate(op)


        val round2 = round1.mapValues { entry -> entry.value.groupingBy { list -> list }.eachCount() }
        val round3 = round2.mapValues { entry -> entry.value.entries.map { e -> e.toPair() } }

        val round4 = round3.mapValues { entry -> entry.value.asSequence().maxBy { pair -> pair.second } ?: Pair(0, 0)}


        val (id, pair) = round4.entries.asSequence().maxBy { entry -> entry.value.second }!!
        return id * pair.first
    }
}