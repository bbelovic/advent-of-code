package net.bbelovic.adventofcode.year2018.day2

import net.bbelovic.adventofcode.Puzzle
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.StringBuilder

class Day2PuzzlePart2Test {
    @Test
    fun `should return common letters`() {
        val puzzle: Puzzle<List<String>, String> = Day2PuzzlePart2()
        val inputs = listOf("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz")
        val actualResult = puzzle.solve(inputs)
        Assertions.assertEquals("fgij", actualResult)
    }

    @Test
    fun `should return common_letters`() {
        var actual = findCommonLetters("fghij", "fguij")
        assertEquals("fgij", actual)
        actual = findCommonLetters("abcde", "axcye")
        assertEquals("ace", actual)
    }

    private fun findCommonLetters(first: String, second: String): String {
        val result = StringBuilder()
        for (i in 0 until first.length) {
            if (first[i] == second[i]) result += first[i]
        }
        return result.toString()
    }

    operator fun StringBuilder.plusAssign(c: Char) {
        this.append(c)
    }

    @Test
    fun `should find strings with single-letter difference`() {
        val actual = hasSingleDifference("fghij", "fguij")
        assertTrue(actual)
        assertFalse(hasSingleDifference("abcde", "axcye"))
        assertFalse(hasSingleDifference("abcde", "abcde"))
        assertFalse(hasSingleDifference("", ""))
    }

    private fun hasSingleDifference(first: String, second: String): Boolean {
        var diffs = 0
        for (i in 0 until first.length) {
            if (first[i] != second[i]) {
                ++diffs
            }
            if (diffs >= 2) break
        }
        return diffs == 1
    }
}