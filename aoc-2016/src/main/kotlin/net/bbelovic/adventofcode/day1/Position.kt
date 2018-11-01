package net.bbelovic.adventofcode.day1

data class Point(val x: Int, val y: Int) {
    fun turnLeft(): Point =
            Point(x * 0 - y * 1, x * 1 + y * 0)


}