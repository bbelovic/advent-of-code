package net.bbelovic.adventofcode.year2018.day3

class FabricTemplate(val onEmpty: FabricTemplate.(x: Int, y: Int, id: Int) -> Int = { x, y, id -> setClaim(x, y, id.toString());  1},
                          val onOverlap: FabricTemplate.(x: Int, y: Int)-> Int = { x, y -> setClaim(x, y, overlapFlag);  1},
                          val shouldRegisterClaim: FabricTemplate.(claim: Rectangle, area: Int) -> Boolean = { _:Rectangle, _: Int -> false},
                          val registerClaim: FabricTemplate.(claim: Rectangle) -> Unit = { run {} }) {
    internal val overlapFlag = "#"
    private val fabric = Array(1000) { Array(1000) { "." } }
    private val registeredClaims = mutableListOf<Int>()

    fun makeClaim(claim: Rectangle): Long {
        var overlap = 0L
        var area = 0
        for (i in 0 until claim.height) {
            for (j in 0 until claim.width) {
                val pos = fabric[claim.upperLeftY + i][claim.upperLeftX + j]
                if (pos == ".") {
                    area += onEmpty(claim.upperLeftY + i, claim.upperLeftX + j, claim.id)
                } else if (pos == overlapFlag) {
                    continue
                } else {
                    overlap += onOverlap(claim.upperLeftY + i, claim.upperLeftX + j)
                }
            }
        }
        if (shouldRegisterClaim(claim, area)) {
            registerClaim(claim)
        }
        return overlap
    }

    fun addClaim(claim: Rectangle) {
        registeredClaims.add(claim.id)
    }

    fun setClaim(x: Int, y: Int, id: String) {
        fabric[x][y] = id
    }

    fun get(x: Int, y: Int) = fabric[x][y]

    fun removeClaimIfPresent(claimId: Int) {
        if (claimId in registeredClaims) {
            registeredClaims.remove(claimId)
        }
    }

    fun getNonOverlappingClaimId() = if (registeredClaims.isEmpty()) 0 else registeredClaims[0]
}