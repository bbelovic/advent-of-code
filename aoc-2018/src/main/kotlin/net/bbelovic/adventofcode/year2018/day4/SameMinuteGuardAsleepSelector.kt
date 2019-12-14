package net.bbelovic.adventofcode.year2018.day4

import java.util.stream.Collectors

data class IdMinuteAndFrequency(val id: Int, val minute: Int, val freq: Long)

class SameMinuteGuardAsleepSelector : GuardAsleepSelector {
    override fun process(records: List<GuardRecord>): Int {

        val y = {record: GuardRecord -> record.minutes.stream().boxed()}
        records.asSequence().groupBy (GuardRecord::id , GuardRecord::minutes)

        val m: Map<Int, List<Int>> = records.stream().collect(
                Collectors.groupingBy({g: GuardRecord -> g.id}, Collectors.flatMapping(y, Collectors.toList<Int>())))

        val identity = { v: Int -> v }

        val keyMapper = {entry: Map.Entry<Int, List<Int>> -> entry.key}
        val valueMapper =
                { entry: Map.Entry<Int, List<Int>> ->
                    entry.value.stream()
                            .collect(Collectors.groupingBy(identity, Collectors.counting()))
                            .entries.stream().map { t: MutableMap.MutableEntry<Int, Long>? -> Pair(t!!.key, t.value) }
                            .collect(Collectors.toList())
                }

        val round2 = m.entries.stream().collect(Collectors.toMap(keyMapper, valueMapper))
        val keyFunction = {e: Map.Entry<Int, List<Pair<Int, Long>>> -> e.key}
        val valueFunction =
                {e: Map.Entry<Int, List<Pair<Int, Long>>> -> e.value
                        .asSequence().maxBy { pair -> pair.second }}

        val round3 = round2.entries
                .stream().collect(Collectors.toMap(keyFunction, valueFunction))

        val round4 = round3.entries.asSequence()
                .map { e -> IdMinuteAndFrequency(e.key, e.value!!.first, e.value!!.second) }
                .toList()

        val maxBy = round4.asSequence().maxBy { idMinuteAndFrequency -> idMinuteAndFrequency.freq }

        return maxBy!!.id * maxBy.minute
    }
}