package net.bbelovic.adventofcode.year2019.day3

private const val UP_CODE = "U"
private const val DOWN_CODE = "D"
private const val LEFT_CODE = "L"
private const val RIGHT_CODE = "R"

data class Coordinates(val x: Int, val y: Int)

internal sealed class Direction(private val steps: Int, private val vector: Coordinates) {

    internal class LEFT(steps: Int, vector: Coordinates) : Direction(steps, vector)
    internal class RIGHT(steps: Int, vector: Coordinates) : Direction(steps, vector)
    internal class UP(steps: Int, vector: Coordinates) : Direction(steps, vector)
    internal class DOWN(steps: Int, vector: Coordinates) : Direction(steps, vector)

    fun move(startPosition: Coordinates, coordinates: MutableSet<Coordinates>): Coordinates {
        var (x, y) = startPosition
        for (i in 0 until steps) {
            x += vector.x
            y += vector.y
            val coordinateRecord = Coordinates(x, y)
            coordinates.add(coordinateRecord)
        }
        return Coordinates(x, y)
    }
}

class Space {

    val startX = 0
    val startY = 0

    fun move(directions: List<String>): MutableSet<Coordinates> {
        val coordinates = mutableSetOf<Coordinates>()
        var actualPosition = Coordinates(startX, startY)
        for (direction in directions) {
            val parsedDirection = parseDirection(direction)
            actualPosition = parsedDirection.move(actualPosition, coordinates)
        }
        return coordinates
    }


    fun move(directions: List<String>, intersection: Coordinates): Int {
        val coordinates = mutableSetOf<Coordinates>()
        var actualPosition = Coordinates(startX, startY)
        for (direction in directions) {
            val parsedDirection = parseDirection(direction)
            actualPosition = parsedDirection.move(actualPosition, coordinates)
            if (actualPosition == intersection) {
                return coordinates.size
            }
        }
        return -1
    }


    private fun parseDirection(directionString: String): Direction {
        val regex = """([RLDU])([0-9]+)""".toRegex()
        val (code, steps) = regex.matchEntire(directionString)!!.destructured
        return when (code) {
            RIGHT_CODE -> Direction.RIGHT(steps.toInt(), Coordinates(1, 0))
            UP_CODE -> Direction.UP(steps.toInt(), Coordinates(0, 1))
            LEFT_CODE -> Direction.LEFT(steps.toInt(), Coordinates(-1, 0))
            DOWN_CODE -> Direction.DOWN(steps.toInt(), Coordinates(0, -1))
            else -> throw IllegalArgumentException("Unknown direction: [$code]")
        }
    }
}
