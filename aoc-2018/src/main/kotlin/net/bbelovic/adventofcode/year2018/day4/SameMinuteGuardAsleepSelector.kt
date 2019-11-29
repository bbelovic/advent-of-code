package net.bbelovic.adventofcode.year2018.day4

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

        print(m)



        return 0
    }
}