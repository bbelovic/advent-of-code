package net.bbelovic.adventofcode.year2018.day4

import java.util.stream.Collectors

data class IdAndMinutes(val id: Int, val minutesPair: Pair<Int, Long>)

class SameMinuteGuardAsleepSelector : GuardAsleepSelector {
    override fun process(records: List<GuardRecord>): Int {
        val x = {record: GuardRecord -> record.minutes}
        val y = {record: GuardRecord -> record.minutes.stream().boxed()}
        records.asSequence().groupBy (GuardRecord::id , GuardRecord::minutes)

        val m: Map<Int, List<Int>> = records.stream().collect(
                Collectors.groupingBy({g: GuardRecord -> g.id}, Collectors.flatMapping(y, Collectors.toList<Int>())))

        println(m)

        val identity = { v: Int -> v }

        val keyMapper = {entry: Map.Entry<Int, List<Int>> -> entry.key}
        val valueMapper =
                { entry: Map.Entry<Int, List<Int>> ->
                    entry.value.stream()
                            .collect(Collectors.groupingBy(identity, Collectors.counting()))
                            .entries.stream().map { t: MutableMap.MutableEntry<Int, Long>? -> Pair(t!!.key, t!!.value) }
                            .collect(Collectors.toList())
                }
                        //.values.stream().mapToInt {value -> value.toInt() }.max().orElse(-1) }



        val round2 = m.entries.stream().collect(Collectors.toMap(keyMapper, valueMapper))


        val keyFunction = {e: Map.Entry<Int, List<Pair<Int, Long>>> -> e.key}
        val valueFunction =
                {e: Map.Entry<Int, List<Pair<Int, Long>>> -> e.value
                        .asSequence().maxBy { pair -> pair.second }}

        val round3 = round2.entries
                .stream().collect(Collectors.toMap(keyFunction, valueFunction))



        println("round2=$round2")
        println("round3=$round3")

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