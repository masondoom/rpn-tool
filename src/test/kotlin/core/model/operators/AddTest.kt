package core.model.operators

import core.model.MutableStack
import core.model.Number
import core.model.State
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import org.junit.Test
import java.lang.IllegalStateException
import java.math.BigDecimal

class AddTest {
    @Test
    fun `add process with valid state should update history and return new state`() {
        val state = State(MutableStack(mutableListOf(
            Number(BigDecimal.valueOf(1.1)),
            Number(BigDecimal.valueOf(2.2))
        )))
        val history = MutableStack<State>()

        val newState = Add(3).operate(state, history)

        newState.toString() shouldBe "stack: 3.3"
        history.size() shouldBe 1
        history.peek().toString() shouldBe "stack: 1.1 2.2"
    }

    @Test
    fun `add process with invalid state should throw error`() {
        val state = State(MutableStack(mutableListOf(
            Number(BigDecimal.valueOf(1.1))
        )))
        val history = MutableStack<State>()

        val exception = shouldThrow<IllegalStateException> {
            Add(2).operate(state, history)
        }
        exception.message shouldBe "Operator + (position: 2): Insufficient parameters"
        state.toString() shouldBe "stack: 1.1"
    }
}