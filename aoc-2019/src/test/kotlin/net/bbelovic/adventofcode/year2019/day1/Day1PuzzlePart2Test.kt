package net.bbelovic.adventofcode.year2019.day1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day1PuzzlePart2Test {
    @Test
    fun `should compute total required fuel`() {
        var actualFuel = computeTotalFuel(14)
        Assertions.assertEquals(0, actualFuel)
    }

    private fun computeTotalFuel(inputMass: Int): Long {
        var sum = 0L
        var mass = Math.floorDiv(inputMass, 3) - 2
        sum += mass
        while (mass != 0) {
            mass = Math.floorDiv(mass, 3) - 2
            sum += mass
        }
        return sum
    }
}