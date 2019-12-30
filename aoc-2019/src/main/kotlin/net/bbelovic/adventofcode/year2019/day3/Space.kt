package net.bbelovic.adventofcode.year2019.day3

sealed class Direction(val steps: Int, val vector: Pair<Int, Int>) {
    fun move(startPosition: Pair<Int, Int>, coordinates: MutableSet<CoordinateRecord>): Pair<Int, Int> {
        var (x, y) = startPosition
        for (i in 0 until steps) {
            x += vector.first
            y += vector.second
            val coordinateRecord = CoordinateRecord(x, y)
            coordinates.add(coordinateRecord)
        }
        return Pair(x, y)
    }

    class LEFT(steps: Int, vector: Pair<Int, Int>) : Direction(steps, vector)
    class RIGHT(steps: Int, vector: Pair<Int, Int>) : Direction(steps, vector)
    class UP(steps: Int, vector: Pair<Int, Int>) : Direction(steps, vector)
    class DOWN(steps: Int, vector: Pair<Int, Int>) : Direction(steps, vector)

}

data class CoordinateRecord(val x: Int, val y: Int)

// TODO - improve direction parsing
// TODO - remove CoordinateRecord

class Space {

    private val right = Pair(1, 0)
    private val left = Pair(-1, 0)
    private val up = Pair(0, 1)
    private val down = Pair(0, -1)

    fun parseDirection(directionString: String): Direction {
        val regex = """([R,L,D,U])([0-9]+)""".toRegex()
        val (code, steps) = regex.matchEntire(directionString)!!.destructured
        return when (code) {
            "R" -> {
                Direction.RIGHT(steps.toInt(), Pair(1, 0))
            }
            "U" -> {
                Direction.UP(steps.toInt(), Pair(0, 1))
            }
            "L" -> {
                Direction.LEFT(steps.toInt(), Pair(-1, 0))

            }
            "D" -> {
                Direction.DOWN(steps.toInt(), Pair(0, -1))
            }
            else -> throw IllegalArgumentException("Unknown direction: [$code]")
        }

    }

    fun move(directions: List<String>): MutableSet<CoordinateRecord> {
        val coordinates = mutableSetOf<CoordinateRecord>()
        var x = 0
        var y = 0
//        val regex = """([R,L,D,U])([0-9]+)""".toRegex()
        for (direction in directions) {
//            val (c, steps) = regex.matchEntire(direction)!!.destructured
            val parsedDirection = parseDirection(direction)
            when (parsedDirection) {
                is Direction.RIGHT -> {
                    val pair = parsedDirection.move(Pair(x, y), coordinates)
                }
                is Direction.UP -> {
                    val pair = parsedDirection.move(Pair(x, y), coordinates)
                }
                is Direction.LEFT -> {
                    val pair = parsedDirection.move(Pair(x, y), coordinates)

                }
                is Direction.DOWN -> {
                    val pair = parsedDirection.move(Pair(x, y), coordinates)
                }
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
