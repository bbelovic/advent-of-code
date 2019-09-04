package net.bbelovic.adventofcode.year2018.day4

import java.io.BufferedReader
import java.util.*

object Day4PuzzlePart1InputParser {
    private val regex1 = """.*#([0-9]{1,4}).*""".toRegex()
    private val regex2 = """\[([0-9]{4}-[0-9]{2}-[0-9]{2}).*:([0-9]{2}).*asleep""".toRegex()
    private val regex3 = """.*[0-9]{2}:([0-9]{2}).*up""".toRegex()
    fun parse(r: BufferedReader): List<GuardRecord?> {
        val result = mutableListOf<GuardRecord?>()
        r.use {
            var record: GuardRecord? = null
            it.forEachLine {line ->
                var asleep = -1
                var awake = -1
                if (line matches regex1) {
                    val (id: String) = regex1.matchEntire(line)!!.destructured
                    record = GuardRecord(id.toInt(), null, BitSet())
                    result.add(record)
                } else if (line matches regex2) {
                    val (date: String, minuteAsleep: String) = regex2.matchEntire(line)!!.destructured
                    if (asleep == -1) {
                        asleep = minuteAsleep.toInt()
                    }
                } else if (line matches regex3) {
                    val (minuteAwake: String) = regex3.matchEntire(line)!!.destructured
                    if (awake == -1) {
                        awake = minuteAwake.toInt()
                        record?.minutesAsleep?.set(asleep, awake)
                    }
                }

            }
        }
        return result
    }

}
