package com.masondoom.rpntool.core.utils

import io.kotlintest.shouldBe
import org.junit.Test

class InputParserTest {
    @Test
    fun `can parse valid string`() {
        val result = InputParser().parse("1 2 3 4 5")
        result shouldBe listOf(
            Pair("1", 1),
            Pair("2", 3),
            Pair("3", 5),
            Pair("4", 7),
            Pair("5", 9),
        )
    }

    @Test
    fun `can parse string with extra space`() {
        val result = InputParser().parse("1  3 4 5")
        result shouldBe listOf(
            Pair("1", 1),
            Pair("", 3),
            Pair("3", 4),
            Pair("4", 6),
            Pair("5", 8),
        )
    }

    @Test
    fun `can parse long string`() {
        val result = InputParser().parse("1 undo 3 4 -5.000")
        result shouldBe listOf(
            Pair("1", 1),
            Pair("undo", 3),
            Pair("3", 8),
            Pair("4", 10),
            Pair("-5.000", 12),
        )
    }
}