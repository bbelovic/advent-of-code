package net.bbelovic.adventofcode.year2018.day3

class Fabric2(width: Int, height: Int) : FabricTemplate(width, height) {
    val registeredClaims = mutableListOf<Int>()
    override fun onEmptyPosition(x: Int, y: Int, id: Int): Int {
        setClaim(x, y, id.toString())
        return 1
    }

    override fun onOverlapPosition(x: Int, y: Int): Int {
        val pos = get(x, y)
        if (registeredClaims.contains(pos.toInt())) {
            registeredClaims.remove(pos.toInt())
        }
        setClaim(x, y, overlapFlag)
        return 0
    }

    override fun shouldRegisterClaim(claim: Rectangle, area: Int): Boolean {
        return area == (claim.height * claim.width)
    }

    override fun registerClaim(claim: Rectangle) {
        registeredClaims.add(claim.id)
    }
}