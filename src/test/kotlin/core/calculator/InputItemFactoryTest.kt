package core.calculator

import core.model.operators.Add
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import org.junit.Test
import java.lang.IllegalArgumentException

class InputItemFactoryTest {
    @Test
    fun `InputItemFactory create InputItem for valid input`() {
        val result = InputItemFactory.create("+", 1)
        (result is Add) shouldBe true
    }

    @Test
    fun `InputItemFactory throws exception for invalid input`() {
        val exception = shouldThrow<IllegalArgumentException> {
            InputItemFactory.create("X", 1)
        }
        exception.message shouldBe "Input read (position: 1): Invalid input=X"
    }
}