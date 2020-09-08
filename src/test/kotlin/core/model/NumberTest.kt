package core.model

import core.utils.Constants.DEFAULT_SCALE
import io.kotlintest.shouldBe
import org.junit.Test

class NumberTest {
    @Test
    fun `createNumber should create Number from a String with correct scale and output with correct scale`() {
        listOf(
            Pair("1.0", "1"),
            Pair("1.12345678901234567890", "1.123456789")
        ).forEach {
            val number = Number.createNumber(it.first)
            number.value.scale() shouldBe DEFAULT_SCALE
            number.toString() shouldBe it.second
        }
    }

    @Test
    fun `createNumber should not use scientific notation`() {
        listOf(
            Pair("1000", "1000"),
            Pair("20", "20")
        ).forEach {
            Number.createNumber(it.first).toString() shouldBe it.second
        }
    }
}