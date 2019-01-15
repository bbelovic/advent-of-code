package net.bbelovic.adventofcode.year2018.day3

import net.bbelovic.adventofcode.Puzzle

class Day3PuzzlePart2 : Puzzle<List<String>, Long> {
    override fun solve(input: List<String>): Long {
        val shouldRegister: FabricTemplate.(claim: Rectangle, area: Int)-> Boolean = {
            claim, area -> claim.width * claim.height == area
        }

        val registerClaim: FabricTemplate.(claim: Rectangle) -> Unit = { claim -> addClaim(claim) }

        val onOverlap: FabricTemplate.(x: Int, y: Int) -> Int = {x,y ->
            removeClaimIfPresent(get(x, y).toInt())
            setClaim(x, y, overlapFlag);  1}

        val fabricTemplate = FabricTemplate(onOverlap = onOverlap,
                shouldRegisterClaim = shouldRegister,
                registerClaim = registerClaim)

        input.asSequence()
                .map { it -> RectangleParser.parse(it) }
                .forEach { it -> fabricTemplate.makeClaim(it) }

        return fabricTemplate.getNonOverlappingClaimId().toLong()
    }
}

