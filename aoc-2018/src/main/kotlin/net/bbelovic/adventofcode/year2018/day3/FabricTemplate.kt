package net.bbelovic.adventofcode.year2018.day3

abstract class FabricTemplate(width: Int, height: Int) {
    protected val overlapFlag = "#"
    private val fabric = Array(width) { Array(height) { "." } }
    fun makeClaim(claim: Rectangle): Long {
        var overlap = 0L
        for (i in 0 until claim.height) {
            for (j in 0 until claim.width) {
                val pos = fabric[claim.upperLeftY + i][claim.upperLeftX + j]
                if (pos == ".") {
                    onEmptyPosition(claim.upperLeftY + i, claim.upperLeftX + j, claim.id)
                } else if (pos == overlapFlag) {
                    continue
                } else {
                    overlap += onOverlapPosition(claim.upperLeftY + i, claim.upperLeftX + j)
                }
            }
        }
        return overlap
    }

    abstract fun onEmptyPosition(x: Int, y: Int, id: Int): Int

    abstract fun onOverlapPosition(x: Int, y:Int): Int

    fun setClaim(x: Int, y: Int, id: String) {
        fabric[x][y] = id
    }

    fun get(x: Int, y: Int) = fabric[x][y]
}