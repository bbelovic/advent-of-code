package net.bbelovic.adventofcode.day1

data class Position(val orientation: Point, val value: Point = Point(0,0)) {
    infix fun turn(direction: Direction) = Position(orientation.turn(direction), value)
    infix fun moveBy(steps: Int): Position {
        val newX = this.value.x + this.orientation.x * steps
        val newY = this.value.y + this.orientation.y * steps
        return Position(orientation, Point(newX, newY))
    }
}