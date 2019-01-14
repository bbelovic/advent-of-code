package net.bbelovic.adventofcode.year2018.day3

open class FabricTemplate(val onEmptyPosition0: FabricTemplate.(x: Int, y: Int, id: Int) -> Int = { x, y, id -> setClaim(x, y, id.toString());  1},
                          val onOverlapPosition0: FabricTemplate.(x: Int, y: Int)-> Int = {x,y -> setClaim(x, y, overlapFlag);  1},
                          val shouldRegisterClaim0: FabricTemplate.(claim: Rectangle, area: Int) -> Boolean = { _:Rectangle, _: Int -> false},
                          val registerClaim0: FabricTemplate.(claim: Rectangle) -> Unit = {_:Rectangle -> {} }) {
    internal val overlapFlag = "#"
    private val fabric = Array(1000) { Array(1000) { "." } }
    val registeredClaims = mutableListOf<Int>()

    fun makeClaim(claim: Rectangle): Long {
        var overlap = 0L
        var area = 0
        for (i in 0 until claim.height) {
            for (j in 0 until claim.width) {
                val pos = fabric[claim.upperLeftY + i][claim.upperLeftX + j]
                if (pos == ".") {
                    area += onEmptyPosition0(claim.upperLeftY + i, claim.upperLeftX + j, claim.id)
                } else if (pos == overlapFlag) {
                    continue
                } else {
                    overlap += onOverlapPosition0(claim.upperLeftY + i, claim.upperLeftX + j)
                }
            }
        }
        if (shouldRegisterClaim0(claim, area)) {
            registerClaim0(claim)
        }
        return overlap
    }

    protected open fun registerClaim(claim: Rectangle) {}

    protected open fun shouldRegisterClaim(claim: Rectangle, area: Int) = false

    open fun onEmptyPosition(x: Int, y: Int, id: Int): Int = 0

    open fun onOverlapPosition(x: Int, y:Int): Int = 0

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
}