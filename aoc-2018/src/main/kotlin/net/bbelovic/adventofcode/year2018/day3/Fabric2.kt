package net.bbelovic.adventofcode.year2018.day3

class Fabric2(width: Int, height: Int) : Fabric(width, height) {
    var candidateId = 0
    val candidates = mutableListOf<Int>()
    override fun makeClaim(claim: Rectangle): Long {
        val area = claim.width * claim.height
        var cnt = 0
        var overlap = 0L
        for (i in 0 until claim.height) {
            for (j in 0 until claim.width) {
                val pos = fabric[claim.upperLeftY + i][claim.upperLeftX + j]
                if (pos == ".") {
                    fabric[claim.upperLeftY + i][claim.upperLeftX + j] = claim.id.toString()
                    ++cnt
                } else if (pos == overlapFlag) {
                    continue
                } else {
                    if (candidates.contains(pos.toInt())) {
                        candidates.remove(pos.toInt())
                    }
                    fabric[claim.upperLeftY + i][claim.upperLeftX + j] = overlapFlag
                    ++overlap
                }
            }
        }
        if (overlap == 0L && cnt == area) {
            candidates.add(claim.id)
        }
        return overlap
    }

}