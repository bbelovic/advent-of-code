package net.bbelovic.adventofcode.year2018.day3

class Fabric2(width: Int, height: Int) : FabricTemplate(width, height) {
    val candidates = mutableListOf<Int>()
    override fun onEmptyPosition(x: Int, y: Int, id: Int): Int {
        setClaim(x, y, id.toString())
        return 1
    }

    override fun onOverlapPosition(x: Int, y: Int): Int {
        val pos = get(x, y)
        if (candidates.contains(pos.toInt())) {
            candidates.remove(pos.toInt())
        }
        setClaim(x, y, overlapFlag)
        return 0
    }
}