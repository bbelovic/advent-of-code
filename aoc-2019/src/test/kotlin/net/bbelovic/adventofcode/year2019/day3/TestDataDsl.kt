package net.bbelovic.adventofcode.year2019.day3

import net.bbelovic.adventofcode.TestDataBuilder
import org.junit.jupiter.params.provider.Arguments

fun testDataDsl(setup: TestDataBuilder.() -> Unit): List<Arguments> {
    val builder = TestDataBuilder()
    builder.setup()
    return builder.arguments.toList()
}