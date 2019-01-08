package net.bbelovic.adventofcode.year2018.day3

import net.bbelovic.adventofcode.InputReader
import org.junit.jupiter.api.Test

class Day3PuzzleMainTest {
    @Test
    fun `should solve puzzle`() {
        val fabric = Fabric(1000, 1000)
        val inputs = InputReader().readAllLines("input3.txt")
        inputs.asSequence()
                .map { it -> RectangleParser().parse(it) }
                .forEach { it -> fabric.makeClaim(it) }

        print(fabric.overlap())
    }
}