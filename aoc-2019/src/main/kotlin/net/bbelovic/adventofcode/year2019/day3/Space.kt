package net.bbelovic.adventofcode.year2019.day3

import java.lang.IllegalArgumentException
import java.util.concurrent.atomic.AtomicLong

data class CoordinateRecord(val id: String, val x: Int, val y: Int)

// TODO - improve direction parsing
// TODO - polish Space class (properties should be defined at top)
// TODO - coordinates should be a list, not set

class Space {
    val coordinates = mutableListOf<CoordinateRecord>()
    val collisions = mutableSetOf<CoordinateRecord>()


    fun move(directions: List<String>) {
        var x = 0
        var y = 0
        val regex = """([R,L,D,U])([0-9]+)""".toRegex()
        val wireId = "wire-${idGenerator.incrementAndGet()}"
        for (direction in directions) {
            val (c, steps) = regex.matchEntire(direction)!!.destructured
            when (c) {
                "R" -> {
                    val pair = recordPosition(steps, x, y, right, wireId)
                    x = pair.first
                    y = pair.second
                }
                "U" -> {
                    val pair = recordPosition(steps, x, y, up, wireId)
                    x = pair.first
                    y = pair.second
                }
                "L" -> {
                    val pair = recordPosition(steps, x, y, left, wireId)
                    x = pair.first
                    y = pair.second

                }
                "D" -> {
                    val pair = recordPosition(steps, x, y, down, wireId)
                    x = pair.first
                    y = pair.second
                }
                else -> throw IllegalArgumentException("Unknown direction: [$c]")
            }
        }

    }

    private fun recordPosition(steps: String, x: Int, y: Int, dir: Pair<Int, Int>, wireId: String): Pair<Int, Int> {
        var x1 = x
        var y1 = y
        for (i in 0 until steps.toInt()) {
            x1 += dir.first
            y1 += dir.second
            val coordinateRecord = CoordinateRecord(wireId, x1, y1)

            collisions.addAll(coordinates.asSequence()
                    .filter { record -> coordinateRecord.x == record.x && coordinateRecord.y == record.y }
                    .filter { record -> coordinateRecord.id != record.id }
                    .toList())
            coordinates.add(coordinateRecord)
        }
        return Pair(x1, y1)
    }
    private val right = Pair(1, 0)
    private val left = Pair(-1, 0)
    private val up = Pair(0, 1)
    private val down = Pair(0, -1)
    private val idGenerator = AtomicLong(0)

}
