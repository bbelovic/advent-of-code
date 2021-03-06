package net.bbelovic.adventofcode.year2018.day4

import java.io.BufferedReader

object Day4PuzzlePart1InputParser {
    private val regex1 = """.*#([0-9]{1,4}).*""".toRegex()
    private val regex2 = """.*:([0-9]{2}).*asleep""".toRegex()
    private val regex3 = """.*[0-9]{2}:([0-9]{2}).*up""".toRegex()
    fun parse(r: BufferedReader): List<GuardRecord> {
        val result = mutableListOf<GuardRecord>()
        r.use {
            var record = GuardRecord()
            it.forEachLine {line ->
                when {
                    line matches regex1 -> {
                        val (id: String) = regex1.matchEntire(line)!!.destructured
                        record = GuardRecord()
                        record.id = id.toInt()
                        result.add(record)
                    }
                    line matches regex2 -> {
                        val (minuteAsleep: String) = regex2.matchEntire(line)!!.destructured
                        record.asleep(minuteAsleep.toInt())
                    }
                    line matches regex3 -> {
                        val (minuteAwake: String) = regex3.matchEntire(line)!!.destructured
                        record.wakeUp(minuteAwake.toInt())
                    }
                }
            }
        }
        return result
    }
}
