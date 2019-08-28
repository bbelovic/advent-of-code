package net.bbelovic.adventofcode.year2018.day4

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Comparator

object InputLineComparator : Comparator<String> {
    override fun compare(o1: String, o2: String): Int {
        val first = parseDateAndTimeFromLine(o1)
        val second = parseDateAndTimeFromLine(o2)
        return first.compareTo(second)
    }

    fun parseDateAndTimeFromLine(line: String): LocalDateTime {
        val regex = """\[([0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2})\] ([a-zA-Z0-9# ]+)""".toRegex()
        val (dateTimePart: String) = regex.matchEntire(line)!!.destructured
        val temporalAccessor = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm").parse(dateTimePart)
        return LocalDateTime.from(temporalAccessor)
    }
}
