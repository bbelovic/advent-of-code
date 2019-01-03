package net.bbelovic.adventofcode.year2018.day3

data class Rectangle(val id: Int, val upperLeftX: Int, val upperLeftY: Int, val width: Int, val height: Int) {
    fun intersect(second: Rectangle): Int {
        val x = upperLeftX..(upperLeftX + width)
        val intersectX = x.intersect(second.upperLeftX..(second.upperLeftX + second.width))
        val y = upperLeftY..(upperLeftY + height)
        val intersectY = y.intersect(second.upperLeftY..(second.upperLeftY + second.height))

        if (intersectX.isEmpty() || intersectY.isEmpty()) return 0
        return (intersectX.size - 1) * (intersectY.size - 1)
    }

    fun area(): Int {
        return width * height
    }
}