package net.bbelovic.adventofcode.year2018.day4

import java.util.function.Function
import java.util.stream.Collectors
import java.util.stream.Stream

data class IdAndMinutes(val id: Int, val minutes: Stream<Int>)

class SameMinuteGuardAsleepSelector : GuardAsleepSelector {
    override fun process(records: List<GuardRecord>): Int {
        val x = {record: GuardRecord -> record.minutes}
        val y = {record: GuardRecord -> record.minutes.stream().boxed()}
        records.asSequence().groupBy (GuardRecord::id , GuardRecord::minutes)

        val m: Map<Int, List<Int>> = records.stream().collect(
                Collectors.groupingBy({g: GuardRecord -> g.id}, Collectors.flatMapping(y, Collectors.toList<Int>())))

        println(m)

        val firstRound = records.asSequence().groupingBy { it.id }
                .aggregate { _, accumulator: MutableList<Int>?, element, first ->
                    val minutes = element.minutes.stream().boxed().collect(Collectors.toList())
                    if (first) {
                        val result = mutableListOf<Int>()
                        result.addAll(minutes)
                        result
                    } else {
                        accumulator!!.addAll(minutes)
                        accumulator
                    }
                }
        println(firstRound)

        val c = firstRound.asSequence().groupingBy { it.key }

        val second = firstRound.asSequence().groupingBy { it.key }
                .aggregate { key, accumulator: MutableMap<Int, Map<Int, Int>>?, element, first ->
                    val groupingBy = element.value!!.asSequence().groupingBy { it }.eachCount()
                    if (first) {
                        val mm = mutableMapOf<Int, Map<Int, Int>>()
                        mm.put(key, groupingBy)
                        mm
                    } else {
                        accumulator!![key] = groupingBy
                        accumulator
                    }

                }
        println(second)



        return 0
    }
}