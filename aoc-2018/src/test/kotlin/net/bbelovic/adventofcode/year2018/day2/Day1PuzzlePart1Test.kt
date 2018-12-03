package net.bbelovic.adventofcode.year2018.day2

import org.junit.jupiter.api.Test

class Day1PuzzlePart1Test {
    @Test
    fun test() {
        val destination = mutableMapOf<Char,Long>()

        val f: (Char) -> Long = {it -> if (destination.containsKey(it)) {
            val value = destination[it]
            value?.plus(1) ?: -1

        } else {
            1L
        }
        }

        val associateWithTo = "ababacb".asSequence()
                .associateWithTo(destination, f)
                .values.asSequence().
        println(destination)

    }
}