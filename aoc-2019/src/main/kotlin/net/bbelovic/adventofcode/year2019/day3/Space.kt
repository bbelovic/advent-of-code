package net.bbelovic.adventofcode.year2019.day3

import java.lang.IllegalArgumentException

data class CoordinateRecord(val id: String, val x: Int, val y: Int) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CoordinateRecord

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }
}

class Space {
    fun move(directions: List<String>) {
        var x = 0
        var y = 0
        for (direction in directions) {
            val c = direction[0]
            val steps = direction[1].toString()
            when (c) {
                'R' -> {
                    for (i in 0 until steps.toInt()) {
                        x += right.first
                        y += right.second
                        coordinates.add(CoordinateRecord("wire1", x, y))
                    }
                }
                'U' -> {
                    for (i in 0 until steps.toInt()) {
                        x += up.first
                        y += up.second
                        coordinates.add(CoordinateRecord("wire1", x, y))
                    }
                }
                else -> throw IllegalArgumentException("Unknown direction: [$c]")
            }
        }

    }

    val coordinates = mutableSetOf<CoordinateRecord>()
    private val right = Pair(1, 0)
    private val up = Pair(0, 1)

}
