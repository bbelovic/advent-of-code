package net.bbelovic.adventofcode.year2018.day3

import net.bbelovic.adventofcode.Puzzle

class Day3PuzzlePart1 : Puzzle<List<String>, Long> {
    override fun solve(input: List<String>): Long {
        val ep: FabricTemplate.(x: Int,y: Int,id: Int)-> Int =
                {x,y,id -> setClaim(x, y, id.toString());  1}

        val op: FabricTemplate.(x: Int,y: Int)-> Int =
                {x,y -> setClaim(x, y, overlapFlag);  1}



        val ft = FabricTemplate()

        return input.asSequence()
                .map { it -> RectangleParser().parse(it) }
                .map { it -> ft.makeClaim(it) }
                .sum()
    }
}