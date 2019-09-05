package net.bbelovic.adventofcode.year2018.day4

import java.util.*

data class GuardRecord(val id: Int) {
    private val minutes = BitSet()
    var minuteAsleep: Int = 0

    fun wakeUp(minute: Int) {
        minutes.set(minuteAsleep, minute)
    }
}