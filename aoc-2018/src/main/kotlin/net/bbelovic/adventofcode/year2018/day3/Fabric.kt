package net.bbelovic.adventofcode.year2018.day3

open class Fabric(width: Int, height: Int) : FabricTemplate(width, height) {

    override fun onEmptyPosition(x: Int, y: Int, id: Int): Int {
        setClaim(x, y, id.toString())
        return 0
    }

    override fun onOverlapPosition(x: Int, y: Int): Int {
        setClaim(x, y, overlapFlag)
        return +1
    }
}