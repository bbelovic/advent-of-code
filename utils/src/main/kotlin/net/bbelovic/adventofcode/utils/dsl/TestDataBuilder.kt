package net.bbelovic.adventofcode.utils.dsl

import org.junit.jupiter.params.provider.Arguments

class TestDataBuilder {
    val arguments = mutableListOf<Arguments>()

    fun testArguments(vararg values: Any) {
        arguments.add(Arguments.of(*values))
    }
}