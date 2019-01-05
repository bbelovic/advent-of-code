package net.bbelovic.adventofcode.year2018.day3

class Fabric(width: Int, height: Int) {
    val fabric = Array(width) { Array(height) { false } }

    fun makeClaim(claim: Rectangle) {
        for (i in claim.upperLeftX..claim.width) {
            for (j in claim.upperLeftY..claim.height) {
                fabric[i][j] = true
            }
        }

    }

    fun printFabric() = println(fabric.contentDeepToString())

}
