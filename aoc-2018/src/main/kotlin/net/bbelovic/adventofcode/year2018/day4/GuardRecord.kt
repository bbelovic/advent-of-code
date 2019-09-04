package net.bbelovic.adventofcode.year2018.day4

data class GuardRecord(val id: Int) {
    private var minuteAsleep: Int = 0


    fun asleep(minute: Int) {
        this.minuteAsleep = minute
    }
}