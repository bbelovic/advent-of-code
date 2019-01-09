package net.bbelovic.adventofcode.year2018.day3

class Fabric(val width: Int, val height: Int) {
    private val fabric = Array(width) { Array(height) { "." } }
    private var overlap = 0L

    fun makeClaim(claim: Rectangle) {
        for (i in 0 until claim.height) {
            for (j in 0 until claim.width) {
                val pos = fabric[claim.upperLeftY + i][claim.upperLeftX + j]
                if (pos == ".") {
                    fabric[claim.upperLeftY + i][claim.upperLeftX + j] = claim.id.toString()
//                    ++overlap
                } else if (pos == "#") {
                    continue
//                    ++overlap
                } else {
                    fabric[claim.upperLeftY + i][claim.upperLeftX + j] = "#"
                    ++overlap
                }

            }
        }
    }

    fun claims() = fabric.copyOf()

    fun overlap(): Long {
/*
        for (i in 0 until height) {
            for (j in 0 until width) {
                if (fabric[i][j] == "#") {
                    ++overlap
                }
            }
        }
*/
        return overlap
    }
}