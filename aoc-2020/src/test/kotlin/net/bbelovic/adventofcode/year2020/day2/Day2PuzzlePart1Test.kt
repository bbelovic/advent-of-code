package net.bbelovic.adventofcode.year2020.day2

import org.junit.jupiter.api.Test

class Day2PuzzlePart1Test {
    @Test
    fun `should count valid passwords - example data`() {
        val exampleInput = listOf("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")
        val result = """(.*[a]{1,3}.*)""".toRegex()

        print(result.matches("baaaa"))
    }
}