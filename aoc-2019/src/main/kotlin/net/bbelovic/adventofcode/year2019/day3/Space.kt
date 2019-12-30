package net.bbelovic.adventofcode.year2019.day3

sealed class Direction(private val steps: Int, private val vector: Pair<Int, Int>) {
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

    fun move(directions: List<String>): MutableSet<CoordinateRecord> {
        val coordinates = mutableSetOf<CoordinateRecord>()
        var actualPosition = Pair(0, 0)
        for (direction in directions) {
            val parseDirection = parseDirection(direction);
            actualPosition = parseDirection.move(actualPosition, coordinates)
        }
        return coordinates
    }

    private fun parseDirection(directionString: String): Direction {
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
}
