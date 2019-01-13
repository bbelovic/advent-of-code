package net.bbelovic.adventofcode.year2018.day3

import net.bbelovic.adventofcode.Puzzle

class Day3PuzzlePart1 : Puzzle<List<String>, Long> {
    override fun solve(input: List<String>): Long {
        val ep: FabricTemplate.(x: Int,y: Int,id: Int)-> Int =
                {x,y,id -> setClaim(x, y, id.toString());  1}

        val op: FabricTemplate.(x: Int,y: Int)-> Int =
                {x,y -> setClaim(x, y, overlapFlag);  1}

        val sr: FabricTemplate.(claim: Rectangle, area: Int)-> Boolean = {
            claim, area -> claim.width * claim.height == area
        }

        val rc: FabricTemplate.(claim: Rectangle) -> Unit = {claim -> addClaim(claim) }

        val ft = FabricTemplate(
                { x, y, id -> setClaim(x, y, id.toString());  1},
                {x,y -> setClaim(x, y, overlapFlag);  1})

        return input.asSequence()
                .map { it -> RectangleParser().parse(it) }
                .map { it -> ft.makeClaim(it) }
                .sum()
    }
}