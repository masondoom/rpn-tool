package core.calculator

import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import org.junit.Test

class CalculatorTest {
    @Test
    fun `calculate valid input and bubble up error if anything wrong`() {
        val calculator = Calculator()

        calculator.calculate("1", 1) shouldBe "stack: 1"
        calculator.calculate("2", 3) shouldBe "stack: 1 2"
        calculator.calculate("3", 5) shouldBe "stack: 1 2 3"
        calculator.calculate("*", 7) shouldBe "stack: 1 6"
        calculator.calculate("5", 9) shouldBe "stack: 1 6 5"
        calculator.calculate("+", 11) shouldBe "stack: 1 11"
        calculator.calculate("*", 13) shouldBe "stack: 11"

        val exception = shouldThrow<IllegalStateException> {
            calculator.calculate("*", 15)
        }
        exception.message shouldBe "Operator * (position: 15): Insufficient parameters"
    }
}