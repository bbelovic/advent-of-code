package net.bbelovic.adventofcode.year2018.day4

interface GuardAsleepSelector {
    fun process(records: List<GuardRecord?>): Int
}