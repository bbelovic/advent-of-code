package net.bbelovic.adventofcode.year2018.day3

class Fabric(width: Int, height: Int) {
    private val overlapFlag = "#"
    private val fabric = Array(width) { Array(height) { "." } }

    fun makeClaim(claim: Rectangle): Long {
        var overlap = 0L
        for (i in 0 until claim.height) {
            for (j in 0 until claim.width) {
                val pos = fabric[claim.upperLeftY + i][claim.upperLeftX + j]
                if (pos == ".") {
                    fabric[claim.upperLeftY + i][claim.upperLeftX + j] = claim.id.toString()
                } else if (pos == overlapFlag) {
                    continue
                } else {
                    fabric[claim.upperLeftY + i][claim.upperLeftX + j] = overlapFlag
                    ++overlap
                }
            }
        }
        return overlap
    }
}