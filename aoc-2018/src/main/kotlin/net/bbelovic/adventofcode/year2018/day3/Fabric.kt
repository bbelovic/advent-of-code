package net.bbelovic.adventofcode.year2018.day3

class Fabric(val width: Int, val height: Int) {
    private val fabric = Array(width) { Array(height) { false } }
    private var overlap = 0L

    fun makeClaim(claim: Rectangle) {
        for (i in 0 until claim.height) {
            for (j in 0 until claim.width) {
                if (fabric[claim.upperLeftY + i][claim.upperLeftX + j]) {
//                    ++overlap
                } else {
                    fabric[claim.upperLeftY + i][claim.upperLeftX + j] = true
//                    ++overlap
                }
            }
        }
    }

    fun claims() = fabric.copyOf()

    fun overlap(): Long {
        for (i in 0 until height) {
            for (j in 0 until width) {
                if (fabric[i][j]) {
                    ++overlap
                }
            }
        }
        return overlap
    }
}