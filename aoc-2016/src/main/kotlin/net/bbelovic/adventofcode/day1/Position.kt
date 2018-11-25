package net.bbelovic.adventofcode.day1

data class Position(val orientation: Point, val endPoint: Point = Point(0,0), val visitedPoints: List<Point> = emptyList()) {
    infix fun turn(direction: Direction) = Position(orientation.turn(direction), endPoint)
    infix fun moveBy(steps: Int): Position {
        val visitedPoints = visitedPoints(endPoint, steps)
        return Position(orientation, endPoint + orientation * steps, visitedPoints)
    }

    private fun visitedPoints(start: Point, steps: Int): List<Point> {
        val result = ArrayList<Point>()
        for (x in 1..steps) {
            result.add(start + orientation * x)
        }
        return result
    }
}