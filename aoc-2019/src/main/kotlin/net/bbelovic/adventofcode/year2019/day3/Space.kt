package net.bbelovic.adventofcode.year2019.day3


data class CoordinateRecord(val x: Int, val y: Int)

// TODO - improve direction parsing

class Space {

    private val right = Pair(1, 0)
    private val left = Pair(-1, 0)
    private val up = Pair(0, 1)
    private val down = Pair(0, -1)

    fun move(directions: List<String>): MutableSet<CoordinateRecord> {
        val coordinates = mutableSetOf<CoordinateRecord>()
        var x = 0
        var y = 0
        val regex = """([R,L,D,U])([0-9]+)""".toRegex()
        for (direction in directions) {
            val (c, steps) = regex.matchEntire(direction)!!.destructured
            when (c) {
                "R" -> {
                    val pair = recordPosition(steps, x, y, right, coordinates)
                    x = pair.first
                    y = pair.second
                }
                "U" -> {
                    val pair = recordPosition(steps, x, y, up, coordinates)
                    x = pair.first
                    y = pair.second
                }
                "L" -> {
                    val pair = recordPosition(steps, x, y, left, coordinates)
                    x = pair.first
                    y = pair.second

                }
                "D" -> {
                    val pair = recordPosition(steps, x, y, down, coordinates)
                    x = pair.first
                    y = pair.second
                }
                else -> throw IllegalArgumentException("Unknown direction: [$c]")
            }
        }
        return coordinates
    }

    private fun recordPosition(steps: String, x: Int, y: Int, dir: Pair<Int, Int>, coords: MutableSet<CoordinateRecord>): Pair<Int, Int> {
        var x1 = x
        var y1 = y
        for (i in 0 until steps.toInt()) {
            x1 += dir.first
            y1 += dir.second
            val coordinateRecord = CoordinateRecord(x1, y1)
            coords.add(coordinateRecord)
        }
        return Pair(x1, y1)
    }
}
