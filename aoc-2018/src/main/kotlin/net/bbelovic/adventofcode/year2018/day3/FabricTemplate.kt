package net.bbelovic.adventofcode.year2018.day3

abstract class FabricTemplate {
    protected val overlapFlag = "#"
    private val fabric = Array(1000) { Array(1000) { "." } }

    fun makeClaim(claim: Rectangle): Long {
        var overlap = 0L
        var area = 0
        for (i in 0 until claim.height) {
            for (j in 0 until claim.width) {
                val pos = fabric[claim.upperLeftY + i][claim.upperLeftX + j]
                if (pos == ".") {
                    area += onEmptyPosition(claim.upperLeftY + i, claim.upperLeftX + j, claim.id)
                } else if (pos == overlapFlag) {
                    continue
                } else {
                    overlap += onOverlapPosition(claim.upperLeftY + i, claim.upperLeftX + j)
                }
            }
        }

        if (shouldRegisterClaim(claim, area)) {
            registerClaim(claim)
        }

        return overlap
    }

    protected open fun registerClaim(claim: Rectangle) {}

    protected open fun shouldRegisterClaim(claim: Rectangle, area: Int) = false

    abstract fun onEmptyPosition(x: Int, y: Int, id: Int): Int

    abstract fun onOverlapPosition(x: Int, y:Int): Int

    fun setClaim(x: Int, y: Int, id: String) {
        fabric[x][y] = id
    }

    fun get(x: Int, y: Int) = fabric[x][y]
}