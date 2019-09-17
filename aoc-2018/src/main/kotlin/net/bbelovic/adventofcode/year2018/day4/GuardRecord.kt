package net.bbelovic.adventofcode.year2018.day4

import java.util.*

class GuardRecord {
    var id: Int = 0
    val minutes = BitSet()

    private var minuteAsleep: Int = 0

    fun wakeUp(minute: Int) {
        minutes.set(minuteAsleep, minute)
    }

    fun asleep(minuteAsleep: Int) {
        this.minuteAsleep = minuteAsleep
    }

    fun minutesSlept() = minutes.cardinality()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GuardRecord

        if (id != other.id) return false
        if (minutes != other.minutes) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + minutes.hashCode()
        return result
    }

    override fun toString(): String {
        return "GuardRecord[id=$id, minutes=$minutes, minuteAsleep=$minuteAsleep]"
    }


}