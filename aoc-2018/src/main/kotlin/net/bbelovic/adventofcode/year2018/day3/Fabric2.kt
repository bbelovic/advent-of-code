package net.bbelovic.adventofcode.year2018.day3

class Fabric2(width: Int, height: Int) : Fabric(width, height) {
    var candidateId = 0
    override fun makeClaim(claim: Rectangle): Long {
        var overlap = 0L
        for (i in 0 until claim.height) {
            for (j in 0 until claim.width) {
                val pos = fabric[claim.upperLeftY + i][claim.upperLeftX + j]
                if (pos == ".") {
                    fabric[claim.upperLeftY + i][claim.upperLeftX + j] = claim.id.toString()
                } else if (pos == overlapFlag) {
                    continue
                } else {
                    if (fabric[claim.upperLeftY + i][claim.upperLeftX + j].toInt() == candidateId) {
                        candidateId = 0
                    }
                    fabric[claim.upperLeftY + i][claim.upperLeftX + j] = overlapFlag
                    ++overlap
                }
            }
        }
        if (overlap == 0L) {
            candidateId = claim.id
        }
        return overlap
    }

}