package net.bbelovic.adventofcode.year2018.day3

import net.bbelovic.adventofcode.Puzzle

class Day3PuzzlePart2 : Puzzle<List<Rectangle>, Int> {
    override fun solve(input: List<Rectangle>): Int {
        val sr: FabricTemplate.(claim: Rectangle, area: Int)-> Boolean = {
            claim, area -> claim.width * claim.height == area
        }
        val rc: FabricTemplate.(claim: Rectangle) -> Unit = {claim -> addClaim(claim) }
        val ft = FabricTemplate(shouldRegisterClaim0 = sr, registerClaim0 = rc)

        input.forEach { it -> ft.makeClaim(it) }

        return ft.registeredClaims[0]
    }
}

