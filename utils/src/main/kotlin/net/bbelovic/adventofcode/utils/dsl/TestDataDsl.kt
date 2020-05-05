package net.bbelovic.adventofcode.utils.dsl

import org.junit.jupiter.params.provider.Arguments

fun testDataDsl(setup: TestDataBuilder.() -> Unit): List<Arguments> {
    val builder = TestDataBuilder()
    builder.setup()
    return builder.arguments.toList()
}