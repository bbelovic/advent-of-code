package net.bbelovic.adventofcode.year2018.day3

class Fabric(width: Int, height: Int) {
    val fabric = Array(width) { Array(height) { false } }

    fun makeClaim(claim: Rectangle) {
        for (i in 0 until claim.height) {
            for (j in 0 until claim.width) {
                fabric[claim.upperLeftX + i][claim.upperLeftY + j] = true
            }
        }

    }

}